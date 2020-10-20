package com.fineex.printer;

import android.app.Application;
import android.content.res.Resources;

/**
 * Created by FC on 2020/10/19.
 * Desc：
 */
public class PrinterApplication extends Application {
    private static PrinterApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public synchronized static PrinterApplication getInstance() {
        return mApplication;
    }

    public Resources getResource() {
        return getResources();
    }
}
