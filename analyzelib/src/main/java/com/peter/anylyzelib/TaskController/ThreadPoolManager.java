package com.peter.anylyzelib.TaskController;

import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager {

    private final int corePoolSize = 4;
    private final int maximumPoolSize = 10;
    private final int keepAliveTime = 10;

    private static ThreadPoolManager instance;

    private static class ThreadPoolManagerHolder{
        private static ThreadPoolManager INSTANCE = new ThreadPoolManager();
    }

    public static ThreadPoolManager getInstance(){
        return ThreadPoolManagerHolder.INSTANCE;
    }

    // 線程池
    private ThreadPoolExecutor threadPoolExecutor;
    //请求队列
    private LinkedBlockingQueue<Future<?>> service = new LinkedBlockingQueue<>();
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
}
