package com.peter.anylyzelib;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import com.peter.anylyzelib.InfoCollector.ActivityCollector;
import com.peter.anylyzelib.config.MonitorConfig;
import com.peter.anylyzelib.util.CommonUtil;

public class Monitor {
    private MonitorConfig mConfig;
    private static volatile Monitor sInstance;
    private ActivityCollector mActivityControler;

    private Monitor(Application application){
//        this.mConfig = config;
        checkConfig();
        //对传入配置进行初始化
        init(application);
    }

    public static void install(Application application){
        if (application != null){
            synchronized (Monitor.class){
                sInstance = new Monitor(application);
            }
        }
//        return sInstance;
    }

    public static Monitor getInstance(){
        return sInstance;
    }

    private boolean checkConfig(){
        return false;
    }

    private void init(Application application) {
        ActivityCollector.init(application);

        InitConfig(application);
    }

    private void InitConfig(Application application) {
        PackageManager pm = application.getPackageManager();
        try {
            PackageInfo pi = pm.getPackageInfo(application.getPackageName(), PackageManager.GET_ACTIVITIES);
            String appversion = pi.versionName;
            String systemVersion = Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT;
            if (ActivityCompat.checkSelfPermission(application, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            String deviceId = CommonUtil.getDeviceId(application);
            this.mConfig = new MonitorConfig.Builder(application)
                    .setCustomAttribute("custom")
                    .setSystemVersion(systemVersion)
                    .setAppVersion(appversion)
                    .setDeviceId(deviceId)
                    .setDeviceType("android")
                    .create();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MonitorConfig getConfig() {
        return mConfig;
    }
}
