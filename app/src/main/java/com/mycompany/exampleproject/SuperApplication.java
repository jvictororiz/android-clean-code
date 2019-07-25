package com.mycompany.exampleproject;

import android.app.Application;

public class SuperApplication extends Application {
    private static SuperApplication superApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        setSuperApplication(this);
    }

    public static SuperApplication getSuperApplication() {
        return superApplication;
    }

    public static void setSuperApplication(SuperApplication superApplication) {
        SuperApplication.superApplication = superApplication;
    }
}
