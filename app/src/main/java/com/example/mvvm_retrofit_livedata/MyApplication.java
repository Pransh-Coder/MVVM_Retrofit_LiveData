package com.example.mvvm_retrofit_livedata;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        context = this;
        super.onCreate();
    }

    public static Context getContext(){
        return context;
        // or return instance.getApplicationContext();
    }
}