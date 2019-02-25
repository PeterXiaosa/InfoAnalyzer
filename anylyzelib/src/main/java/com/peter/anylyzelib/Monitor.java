package com.peter.anylyzelib;

import android.app.Application;

public class Monitor {
    private static Analyzer mAnalyzer;

    public static void install(Application application){
        mAnalyzer =  new Analyzer.AnalyzerBuilder(application)
                .build();
    }
}
