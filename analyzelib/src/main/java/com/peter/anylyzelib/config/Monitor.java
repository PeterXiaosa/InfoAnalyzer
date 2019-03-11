package com.peter.anylyzelib.config;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.peter.anylyzelib.InfoCollector.ActivityCollector;

public class Monitor {
    private MonitorConfig mConfig;
    private static volatile Monitor sInstance;
    private ActivityCollector mActivityControler;

    private Monitor(MonitorConfig config){
        this.mConfig = config;
        checkConfig();
        init();
    }

    public static Monitor install(MonitorConfig config){

        if (sInstance == null){
            synchronized (Monitor.class){
                if (sInstance == null){
                    sInstance = new Monitor(config);
                }
            }
        }
        return sInstance;
    }

    public static Monitor getInstance(){
        return sInstance;
    }

    private boolean checkConfig(){
        return false;
    }

    private void init() {
        mActivityControler = new ActivityCollector(mConfig.application);
    }
}
