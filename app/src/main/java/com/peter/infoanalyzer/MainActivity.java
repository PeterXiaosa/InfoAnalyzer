package com.peter.infoanalyzer;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.peter.anylyzelib.TaskController.ThreadPoolConfig;
import com.peter.anylyzelib.TaskController.ThreadPoolManager;
import com.peter.anylyzelib.retrofit.ApiCallback;
import com.peter.anylyzelib.retrofit.ApiCollectior;
import com.peter.infoanalyzer.bean.SOrderInsert;

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

        String[] strState = {Manifest.permission.READ_PHONE_STATE};
        ActivityCompat.requestPermissions(this, strState, 1);

        ThreadPoolConfig config = new ThreadPoolConfig.Builder(this)
                .create();
        ThreadPoolManager.getInstance().install(config);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btn_go.getId()){
//            startActivity(new Intent(this, SecondActivity.class));
            SOrderInsert orderInsert = new SOrderInsert();
            orderInsert.setOrderPrice(1.21);
            orderInsert.setContractNo("ZCE|F|SR|901");

            ApiCollectior.recordOrder(orderInsert, new ApiCallback() {
                @Override
                public void onSuccess(Object model) {
                    Toast.makeText(getApplicationContext(), "http success", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(String msg) {
                    Toast.makeText(getApplicationContext(), "http fail", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFinish() {
                    Toast.makeText(getApplicationContext(), "http finish", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
//        View group = getWindow().getDecorView().findViewById(android.R.id.content);
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            View view = ViewIdentifier.getViewByCoordinate((int) event.getRawX(), (int) event.getRawY(), group);
//            if (view != null) {
//                Log.d("peterTest", "View id is " + ViewIdentifier.getViewId(view));
//            }
//        }
        return super.dispatchTouchEvent(event);
    }
}
