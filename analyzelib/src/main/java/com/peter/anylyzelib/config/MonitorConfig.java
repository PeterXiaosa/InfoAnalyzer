package com.peter.anylyzelib.config;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class MonitorConfig {

    List<String> mCustomAttributeList = new ArrayList<>();
    Context mContext;

    private MonitorConfig(){

    }

    public static class Builder{
        List<String> mCustomAttributeList = new ArrayList<>();
        Context mContext;

        public Builder(Context context){
            this.mContext = context;
        }

        public Builder setCustomAttribute(String attribute){
            if (! mCustomAttributeList.contains(attribute)){
                mCustomAttributeList.add(attribute);
            }
            return this;
        }

        void applyConfig(MonitorConfig config){
            config.mCustomAttributeList = this.mCustomAttributeList;
            config.mContext = this.mContext;
        }

        public MonitorConfig create(){
            MonitorConfig config = new MonitorConfig();
            applyConfig(config);
            return config;
        }
    }
}
