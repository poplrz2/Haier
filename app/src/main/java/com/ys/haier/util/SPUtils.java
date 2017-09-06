package com.ys.haier.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wz on 2017-08-25.
 */

public class SPUtils {

    //使用SharedPreferences进行读取
    private SharedPreferences pref;
    //使用SharedPreferences.Editor进行存储
    private SharedPreferences.Editor editor;

    public SPUtils(Context context) {
        pref = context.getSharedPreferences("data",Context.MODE_PRIVATE);
    }

    public void StorageString(String key, String value){

        editor = pref.edit();
        editor.putString(key,value);
        editor.commit();
    }

    public String  getStorageData(String key){
        String value = pref.getString(key, "");
        return value;
    }

    public void StorageInt(String key,int value){
        editor = pref.edit();
        editor.putInt(key,value);
        editor.commit();
    }

    public int getStorageInt(String key){
        int value = pref.getInt(key,-1);
        return value;
    }
}
