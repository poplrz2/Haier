package com.ys.haier.model;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.ys.haier.RegisterActivity;
import com.ys.haier.interfaces.ObserverListener;
import com.ys.haier.listener.MyObserverListener;
import com.ys.haier.util.HttpUtil;
import com.ys.haier.util.SPUtils;
import com.ys.haier.util.SnackbarUtil;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wz on 2017-08-09.
 */

public class User_Register_Model implements ObserverListener {
    String userName;
    String userPwd;
    String userPwd_Ok;
    String vercode;
    String phone;
    Activity context;

    public User_Register_Model(Activity activity,String userName,String phone,String vercode,String userPwd,String userPwd_Ok){
        this.context = activity;
        this.userName = userName;
        this.phone = phone;
        this.vercode = vercode;
        this.userPwd = userPwd;
        this.userPwd_Ok = userPwd_Ok;
    }

    public void register() {

         String TempVerCode = new SPUtils(context).getStorageData("vercode");

        if ("".equals(userName)) {
            SnackbarUtil.showFail(context, "请输入用户名");
        }else if ("".equals(phone)){
            SnackbarUtil.showFail(context,"请输入手机号");
        }else if ("".equals(vercode)){
            SnackbarUtil.showFail(context,"请输入验证码");
        }
        else if (!vercode.equals(TempVerCode)){
            SnackbarUtil.showFail(context,"验证码输入错误！");
        }
        else if ("".equals(userPwd)) {
            SnackbarUtil.showFail(context, "请输入密码");
        } else if ("".equals(userPwd_Ok)) {
            SnackbarUtil.showFail(context, "请再次输入密码");
        } else if (!userPwd.equals(userPwd_Ok)) {
            SnackbarUtil.showFail(context, "两次密码输入不一致，请重新输入");
        } else {
            new HttpUtil().UserRegister(userName,userPwd_Ok,phone,this);
        }
    }


    @Override
    public void onError(Throwable e) {
        SnackbarUtil.showFail(context, "请求发生异常，请重试");
    }

    @Override
    public void Success(Object object,int flag) {
        try {
            JSONObject jsonObject=new JSONObject(object.toString());
            if(jsonObject.getBoolean("success")){
                context.finish();
            }
            else{
                SnackbarUtil.showFail(context,jsonObject.getString("rows"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            SnackbarUtil.showFail(context,"数据发生异常");
        }
    }

    @Override
    public void onComplete() {

    }
}
