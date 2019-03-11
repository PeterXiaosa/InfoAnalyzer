package com.peter.infoanalyzer;

import android.content.Intent;
import android.os.Bundle;
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

import com.peter.anylyzelib.InfoCollector.ViewIdentifier;
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
//        btn_go.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, SecondActivity.class));
//            }
//        });

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btn_go.getId()){
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        ViewGroup group = layout;
        View view = ViewIdentifier.getViewByCoordinate((int) event.getRawX(), (int)event.getRawY(), group);
        if(view != null){
            Log.d("peterTest", "View id is " + ViewIdentifier.getViewId(view));
        }
        return super.dispatchTouchEvent(event);
    }
}
