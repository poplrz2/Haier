package com.ys.haier.model;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.ys.haier.MainActivity;
import com.ys.haier.PerfectUserInfoActivity;
import com.ys.haier.data.UserInfo;
import com.ys.haier.interfaces.ObserverListener;
import com.ys.haier.util.HttpUtil;
import com.ys.haier.util.SPUtils;
import com.ys.haier.util.SnackbarUtil;

/**
 * Created by wz on 2017-08-08.
 */

public class Login_Model implements ObserverListener{
    private   String userName;
    private   String userPwd;
    Activity context;
    public Login_Model(Activity context, String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.context=context;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

   public void login(){
       if("".equals(userName)){
           SnackbarUtil.showFail(context,"请输入用户名");
       }else if("".equals(userPwd)){
           SnackbarUtil.showFail(context,"请输入用户密码");
       }else {
           new HttpUtil().UserLogin(userName, userPwd, this);
       }
    }

    @Override
    public void onError(Throwable e) {
        SnackbarUtil.showFail(context,"请求发生异常");
    }

    @Override
    public void Success(Object object,int flag) {
        Logger.i(object.toString());
       UserInfo userInfo= new Gson().fromJson(object.toString(),UserInfo.class);
        if(userInfo.isSuccess()){
          int isPeerfect=  userInfo.getRows().get(0).getNull2();
            Log.d("userid",userInfo.getRows().get(0).getID()+"");
            //存储用户id
            new SPUtils(context).StorageInt("userid",userInfo.getRows().get(0).getID());
            if(isPeerfect==0){
             Intent it = new Intent(context, PerfectUserInfoActivity.class);
                it.putExtra("userid",userInfo.getRows().get(0).getID());
                context.startActivity(it);
            }else{
            context.startActivity(new Intent(context, MainActivity.class));}
        }
        else{
            SnackbarUtil.showFail(context,"账号或密码错误");
        }

    }

    @Override
    public void onComplete() {

    }
}
