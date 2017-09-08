package com.ys.haier.interfaces;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by wz on 2017-08-08.
 */

public interface MyServer {
    @FormUrlEncoded
    @POST("SJ_Handler/YH_Login.ashx")
    Observable<String> UserLogin(@Field("action") String action, @Field("name") String UserName, @Field("pwd") String UserPwd);
    @FormUrlEncoded
    @POST("SJ_Handler/YH_Login.ashx")
    Observable<String> UserRegister(@Field("action") String action, @Field("name") String UserName,@Field("pwd") String pwd,@Field("phone")String phone);
    @FormUrlEncoded
    @POST("SJ_Handler/YH_Login.ashx")
    Observable<String> getBinner_pic(@Field("action") String action, @Field("Ad_SHD") int type);

    @FormUrlEncoded
    @POST("SJ_Handler/YH_Login.ashx")
    Observable<String> getFl(@Field("action") String action);

    @FormUrlEncoded
    @POST("SJ_Handler/YH_Login.ashx")
    Observable<String> getProvinces(@Field("action") String action);
    @FormUrlEncoded
    @POST("SJ_Handler/YH_Login.ashx")
    Observable<String> getCities(@Field("action") String action,@Field("Shengid")String id );
    @FormUrlEncoded
    @POST("SJ_Handler/YH_Login.ashx")
    Observable<String> getPerfect_Register(@Field("action") String action, @Field("json") JSONObject jsonObject);
    @FormUrlEncoded
    @POST("SJ_Handler/YH_Login.ashx")
    Observable<String> getNews(@Field("action") String action,@Field("News_CategoryID") String type);
    @FormUrlEncoded
    @POST("SJ_Handler/YH_Login.ashx")
    Observable<String>getNewsGD(@Field("action") String action,@Field("News_CategoryID") String type);
    @FormUrlEncoded
    @POST("SJ_Handler/YH_Login.ashx")
    Observable<String>getService(@Field("action")String action,@Field("News_CategoryID")String type);

    @FormUrlEncoded
    @POST("SJ_Handler/YH_Login.ashx")
    Observable<String> getServeDetials_tuijian(@Field("action") String action,@Field("FW_ID")String fw_id,@Field("dlid")String dlid);
    @FormUrlEncoded
    @POST("SJ_Handler/YH_Login.ashx")
    Observable<String> getServeDetials_guanzhu(@Field("action") String action,@Field("FW_ID")String fw_id,@Field("dlid")String dlid);

    @FormUrlEncoded
    @POST("SJ_Handler/YH_Login.ashx")
    Observable<String> uploadHeadPortrait(@Field("action") String action,@Field("User_ID")String User_ID,@Field("Stream")String Stream,@Field("img_Name")String img_Name);
}
