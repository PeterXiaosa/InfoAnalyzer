package com.peter.infoanalyzer;

import android.app.Application;

import com.peter.anylyzelib.config.Monitor;
import com.peter.anylyzelib.config.MonitorConfig;

public class AppContext extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        MonitorConfig config = new MonitorConfig.Builder(this)
                .setCustomAttribute("custom")
                .create();
        Monitor.install(config);
    }
}
