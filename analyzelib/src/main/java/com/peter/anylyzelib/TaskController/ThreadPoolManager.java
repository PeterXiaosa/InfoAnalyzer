package com.peter.anylyzelib.TaskController;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager {

    public interface AsyncHandler{
        void onFinished();
    }

    private Context context;

    private final int corePoolSize = 4;
    private final int maximumPoolSize = 10;
    private final int keepAliveTime = 10;

    private static ThreadPoolManager instance;

    public static ThreadPoolManager getInstance(){
        return ThreadPoolManagerHolder.INSTANCE;
    }

    public void install(ThreadPoolConfig config){
        this.context = config.context;
        mainHandler = new Handler(context.getMainLooper());
    }

    // 線程池
    private ThreadPoolExecutor threadPoolExecutor;
    //请求队列
    private LinkedBlockingQueue<Future<?>> service = new LinkedBlockingQueue<>();
    // Handler
    private Map<FutureTask, AsyncHandler> handlerMap = new ConcurrentHashMap<>();
    //主线程handler
    private Handler mainHandler;
    // 拒绝机制
    private RejectedExecutionHandler handler = new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                service.put(new FutureTask<>(r, null));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    };

    private ThreadPoolManager(){
        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(4), handler);
        threadPoolExecutor.execute(runnable);
    }

    //请求队列里的线程任务排队到线程池执行
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while (true){
                FutureTask futureTask = null;
                try {
                    Log.d("myThreadPook", "service size : " + service.size());
                    futureTask = (FutureTask) service.take();
                    Log.d("myThreadPook", "service size : " + service.size());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if (futureTask != null){
                    threadPoolExecutor.execute(futureTask);
                }
                try {
                    if ((futureTask.get() instanceof  Boolean)
                            && (boolean)futureTask.get()
                            && handlerMap.get(futureTask) != null){
                        //任务完成，通知主线程
                        final FutureTask finalFutureTask = futureTask;
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                Objects.requireNonNull(handlerMap.get(finalFutureTask)).onFinished();
                            }
                        });

                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public <T> void execute(final  FutureTask<T> futureTask, Object delayed){
        if (futureTask == null){
            return;
        }
        if (delayed != null){
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        service.put(futureTask);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }, (long)delayed);
        }

    }

    public <T> void execute(Runnable runnable, Object delayed, AsyncHandler asyncHandler){
        if (runnable == null){
            return;
        }

        final FutureTask<Boolean> futureTask = new FutureTask<>(runnable, true);
//        service.put(new FutureTask<>(r, null));
        if (delayed != null){
            Timer timer = new Timer();
            handlerMap.put(futureTask, asyncHandler);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        service.put(futureTask);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }, (long)delayed);
        }

    }


    private static class ThreadPoolManagerHolder{
        private static ThreadPoolManager INSTANCE = new ThreadPoolManager();
    }
}
