package com.intergrupo.reportedetiemposig.Helper;

import android.app.Application;

/**
 * Created by mauricio on 18/11/15.
 */
public class ApplicationContext extends Application {
    private static ApplicationContext instance;


    public static ApplicationContext getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }
}

