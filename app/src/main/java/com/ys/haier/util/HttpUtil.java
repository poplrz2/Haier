package com.ys.haier.util;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.ys.haier.MyApp;
import com.ys.haier.listener.MyObserverListener;
import com.ys.haier.interfaces.MyServer;
import com.ys.haier.interfaces.ObserverListener;

import org.json.JSONObject;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by wz on 2017-08-08.
 */

public class HttpUtil {
    Retrofit retrofit;
    MyServer myServer;

    public HttpUtil() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApp.URL_SERVER)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(okHttpClient)
                .build();
        myServer = retrofit.create(MyServer.class);
    }

    //登录
    public void UserLogin(String name, String pwd, ObserverListener observerListener) {
        myServer.UserLogin("UserLogin", name, pwd)
                .compose(new Observable_Thread())
                .subscribe(new MyObserverListener(observerListener));
    }

    //注册
    public void UserRegister(String name,String pwd,String phone,ObserverListener observerListener){
        myServer.UserRegister("UserRegion",name,pwd,phone)
                .compose(new Observable_Thread())
                .subscribe(new MyObserverListener(observerListener));
    }

    //首页分类
    public void getFl(ObserverListener observerListener){
        myServer.getFl("BindFl")
                .compose(new Observable_Thread())
                .subscribe(new MyObserverListener(observerListener));
    }

    public void getBinner_pic(int type, ObserverListener observerListener) {
        myServer.getBinner_pic("BindNav",type)
                .compose(new Observable_Thread())
                .subscribe(new MyObserverListener(observerListener));
    }
    public void getProvinces(ObserverListener observerListener){

        myServer.getProvinces("BindSheng")
                .compose(new Observable_Thread())
                .subscribe(new MyObserverListener(observerListener,0));
    }
    public void getCity(String id,ObserverListener observerListener){

        myServer.getCities("BindShi",id)
                .compose(new Observable_Thread())
                .subscribe(new MyObserverListener(observerListener,1));
    }
    public void getPerfect_Register(JSONObject jsonObject, ObserverListener observerListener){
        myServer.getPerfect_Register("CompleteXX",jsonObject)
                .compose(new Observable_Thread())
                .subscribe(new MyObserverListener(observerListener,2));
    }
    public void getNews(String type, ObserverListener observerListener){
        myServer.getNews("BindNew",type)
                .compose(new Observable_Thread())
                .subscribe(new MyObserverListener(observerListener,3));
    }

    public void getNewsGD(String type,ObserverListener observerListener){
        myServer.getNewsGD("BindNew_GD",type)
                .compose(new Observable_Thread())
                .subscribe(new MyObserverListener(observerListener,4));
    }

    public void getService(String type,ObserverListener observerListener){
        myServer.getService("BindFw",type)
                .compose(new Observable_Thread())
                .subscribe(new MyObserverListener(observerListener,5));
    }

    public void getServeDetials_tuijian(String fw_id,String dlid,ObserverListener observerListener){
        myServer.getServeDetials_tuijian("Bind_TJFwXq",fw_id,dlid)
                .compose(new Observable_Thread())
                .subscribe(new MyObserverListener(observerListener));
    }

    public void getServeDetials_guanzhu(String fw_id,String dlid,ObserverListener observerListener){
        myServer.getServeDetials_guanzhu("Bind_GZFwXq",fw_id,dlid)
                .compose(new Observable_Thread())
                .subscribe(new MyObserverListener(observerListener));
    }

}
