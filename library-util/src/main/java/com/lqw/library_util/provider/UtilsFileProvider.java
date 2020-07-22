package com.lqw.library_util.provider;

import android.app.Application;

import androidx.core.content.FileProvider;


public class UtilsFileProvider extends FileProvider {
    @Override
    public boolean onCreate() {
        AppContext.init((Application) getContext().getApplicationContext());
        return true;
    }
}
