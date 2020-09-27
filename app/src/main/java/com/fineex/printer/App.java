package com.fineex.printer;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

/**
 * @author： Chen
 * create： 2020/9/27
 * description：
 */
public class App extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //方法数超过分包
        MultiDex.install(this);
    }

}
