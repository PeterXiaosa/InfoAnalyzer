package com.peter.anylyzelib;

import android.app.Application;

import com.peter.anylyzelib.config.MonitorConfig;

public class Monitor {
    private MonitorConfig mConfig;
    private static volatile Monitor sInstance;

    private Monitor(MonitorConfig config){
        this.mConfig = config;
        checkConfig();
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

    private void checkConfig(){

    }
}
