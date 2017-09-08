package com.ys.haier.model;

import android.content.Context;
import android.os.Environment;

import com.ys.haier.interfaces.ObserverListener;
import com.ys.haier.util.HttpUtil;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by chen on 2017/9/7.
 */

public class HeadPortrait_Model implements ObserverListener {

    Context context;

    public HeadPortrait_Model(Context context){
        this.context = context;
    }

    public void uploadHeadPortrait(byte[] bytes){

//        new HttpUtil().uploadHeadPoritrait("123",new String(bytes),"123.png",this);

        File file = new File(Environment.getExternalStorageDirectory()+"//"+"aaa.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            // 创建文件
            file.createNewFile();
            // 声明字符输出流
            Writer out = null;
            // 通过子类实例化，表示可以追加
            out = new FileWriter(file,false);
            // 写入数据
            out.write(new String(bytes));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void Success(Object object, int flag) {

    }

    @Override
    public void onComplete() {

    }
}
