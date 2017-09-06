package com.ys.haier;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.ys.haier.util.StatusBarUtils;


/**
 * Created by Administrator on 2017-08-08.
 */

public class MyApp extends Application {
   public static  final String URL_SERVER="http://192.168.1.100:8015";
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
