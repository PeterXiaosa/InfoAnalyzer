package com.peter.anylyzelib.TaskController;

import android.content.Context;

public class ThreadPoolConfig {
    Context context;

    public ThreadPoolConfig() {
    }

    public static class Builder{
        Context context;

        public Builder(Context context){
            this.context = context;
        }

        ThreadPoolConfig applyConfig(ThreadPoolConfig config){
            config.context = this.context;
            return config;
        }

        public ThreadPoolConfig create(){
            ThreadPoolConfig config = new ThreadPoolConfig();
            return applyConfig(config);
        }
    }
}
