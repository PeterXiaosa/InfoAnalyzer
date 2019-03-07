package com.peter.infoanalyzer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.peter.anylyzelib.InfoCollector.ViewIdentifier;
import com.peter.anylyzelib.TaskController.ThreadPoolManager;

import java.util.LinkedList;
import java.util.concurrent.FutureTask;

public class MainActivity extends AppCompatActivity {

    private Button btn_go;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_go = findViewById(R.id.btn_go);
        layout = findViewById(R.id.layout);
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 100; i++){
                    final int finalI = i;
                    Thread thread = new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            Log.d("threadTest", "runnable----->" + finalI);
                        }
                    };
                    ThreadPoolManager.getInstance().execute(new FutureTask<Object>(thread, null), null);
                }
//                Thread thread = new Thread(){
//                    @Override
//                    public void run() {
//                        super.run();
//                        Log.d("threadTest", "runnable----->finalIrunnable");
//                    }
//                };
//                ThreadPoolManager.getInstance().execute(new FutureTask<Object>(thread, null), (long)10000);

//                Log.d("peterdebug", "view Id is " + ViewIdentifier.getViewId(btn_go));
            }
        });

    }

}
