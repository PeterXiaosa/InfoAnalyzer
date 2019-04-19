package com.peter.infoanalyzer;

import android.app.Application;

import com.peter.anylyzelib.Monitor;

public class AppContext extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Monitor.install(this);
    }
}
