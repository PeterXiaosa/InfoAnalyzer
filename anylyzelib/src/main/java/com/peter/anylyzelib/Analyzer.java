package com.peter.anylyzelib;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {

    private List<String> mCustomAttribute = new ArrayList<>();

    private Context mContext;

    private Analyzer(){}

    private Analyzer(AnalyzerBuilder builder){
        this.mContext = builder.mContext;
        this.mCustomAttribute = builder.mCustomAttribute;
    }

    public static final class AnalyzerBuilder {

        private Context mContext;
        private List<String> mCustomAttribute = new ArrayList<>();

        public AnalyzerBuilder(Context context){
            this.mContext = context.getApplicationContext();
        }

        public AnalyzerBuilder setCustomAttribute(String attribute){
            if (! mCustomAttribute.contains(attribute)){
                mCustomAttribute.add(attribute);
            }
            return this;
        }

        public Analyzer build(){
            return new Analyzer(this);
        }
    }
}
