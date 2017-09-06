package com.ys.haier.interfaces;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by lzc on 2017-08-21.
 */

public interface VerificationServer {
    @FormUrlEncoded
    @POST("/")
    Call<String> SendSms(@Field("Action")String Action, @Field("UserName")String userName, @Field("Password")String pwd, @Field("Mobile")String phone, @Field("Message")String message,@Field("IsP2p") String Isp2p);
}
