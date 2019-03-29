package com.peter.infoanalyzer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.peter.anylyzelib.InfoCollector.ViewIdentifier;
import com.peter.anylyzelib.TaskController.ThreadPoolConfig;
import com.peter.anylyzelib.TaskController.ThreadPoolManager;

import java.util.LinkedList;
import java.util.concurrent.FutureTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_go;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_go = findViewById(R.id.btn_go);
        layout = findViewById(R.id.layout);
        btn_go.setOnClickListener(this);

        ThreadPoolConfig config = new ThreadPoolConfig.Builder(this)
                .create();
        ThreadPoolManager.getInstance().install(config);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btn_go.getId()){

        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        View group = getWindow().getDecorView().findViewById(android.R.id.content);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View view = ViewIdentifier.getViewByCoordinate((int) event.getRawX(), (int) event.getRawY(), group);
            if (view != null) {
                Log.d("peterTest", "View id is " + ViewIdentifier.getViewId(view));
            }
        }
        return super.dispatchTouchEvent(event);
    }
}
