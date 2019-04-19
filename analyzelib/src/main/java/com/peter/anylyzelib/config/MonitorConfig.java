package com.peter.anylyzelib.config;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class MonitorConfig {

    private List<String> mCustomAttributeList = new ArrayList<>();
    private Application application;
    private String deviceId;
    private String appVersion;
    private String systemVersion;
    private String deviceType;

    private MonitorConfig(){

    }

    public Application getApplication() {
        return application;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public static class Builder{
        List<String> mCustomAttributeList = new ArrayList<>();
        Application application;
        String deviceId;
        String appVersion;
        String systemVersion;
        String deviceType;

        public Builder(Application application){
            this.application = application;
        }

        public Builder setCustomAttribute(String attribute){
            if (! mCustomAttributeList.contains(attribute)){
                mCustomAttributeList.add(attribute);
            }
            return this;
        }

        public Builder setDeviceId(String deviceId){
            this.deviceId = deviceId;
            return this;
        }

        public Builder setDeviceType(String deviceType){
            this.deviceType = deviceType;
            return this;
        }

        public Builder setAppVersion(String appversion){
            this.appVersion = appversion;
            return this;
        }

        public Builder setSystemVersion(String systemVersion){
            this.systemVersion = systemVersion;
            return this;
        }

        void applyConfig(MonitorConfig config){
            config.mCustomAttributeList = this.mCustomAttributeList;
            config.application = this.application;
            config.systemVersion = this.systemVersion;
            config.appVersion = this.appVersion;
            config.deviceId = this.deviceId;
            config.deviceType = this.deviceType;
        }

        public MonitorConfig create(){
            MonitorConfig config = new MonitorConfig();
            applyConfig(config);
            return config;
        }
    }
}
