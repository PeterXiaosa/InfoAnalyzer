package com.peter.anylyzelib.config;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class MonitorConfig {

    List<String> mCustomAttributeList = new ArrayList<>();
    Application application;

    private MonitorConfig(){

    }

    public static class Builder{
        List<String> mCustomAttributeList = new ArrayList<>();
        Application application;

        public Builder(Application application){
            this.application = application;
        }

        public Builder setCustomAttribute(String attribute){
            if (! mCustomAttributeList.contains(attribute)){
                mCustomAttributeList.add(attribute);
            }
            return this;
        }

        void applyConfig(MonitorConfig config){
            config.mCustomAttributeList = this.mCustomAttributeList;
            config.application = this.application;
        }

        public MonitorConfig create(){
            MonitorConfig config = new MonitorConfig();
            applyConfig(config);
            return config;
        }
    }
}
