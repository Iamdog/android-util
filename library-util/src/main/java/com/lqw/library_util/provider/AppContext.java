package com.lqw.library_util.provider;

import android.annotation.SuppressLint;
import android.app.Application;

public class AppContext {
    @SuppressLint("StaticFieldLeak")
    private static Application sApp;

    private AppContext() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void init(final Application app) {
        if (sApp == null) {
            sApp = app;
        }
    }


    public static Application getApp() {
        if (sApp != null) return sApp;
        return null;
    }


}
