package com.example.cursoudemy.secc8_cursoudemy;

import android.app.Application;
import android.os.SystemClock;

public class MyApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        SystemClock.sleep(3000);
    }
}
