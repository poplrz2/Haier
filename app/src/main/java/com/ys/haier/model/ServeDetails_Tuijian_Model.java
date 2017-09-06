package com.ys.haier.model;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ys.haier.Doctor_Details;
import com.ys.haier.adapter.Serve_Details_Adapter;
import com.ys.haier.data.ServeDetail;
import com.ys.haier.interfaces.ObserverListener;
import com.ys.haier.util.DividerItemDecoration;
import com.ys.haier.util.HttpUtil;

import java.util.List;

/**
 * Created by lzc on 2017-08-27.
 */

public class ServeDetails_Tuijian_Model implements ObserverListener {

    private Activity activity;
    private RecyclerView serveDetials_tuijian_Rcy;
    private String fw_id,dl_id;
    private Serve_Details_Adapter serve_details__adapter;

    public ServeDetails_Tuijian_Model(Activity activity, RecyclerView serveDetials_tuijian_Rcy, String fw_id, String dl_id) {
        this.activity = activity;
        this.serveDetials_tuijian_Rcy = serveDetials_tuijian_Rcy;
        this.fw_id = fw_id;
        this.dl_id = dl_id;
    }

    public void initServeDetialsTuiJianRcy(){
        LinearLayoutManager manager = new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false);
        serveDetials_tuijian_Rcy.setLayoutManager(manager);
        serveDetials_tuijian_Rcy.addItemDecoration(new DividerItemDecoration(activity,DividerItemDecoration.VERTICAL_LIST));
        new HttpUtil().getServeDetials_tuijian(fw_id,dl_id,this);
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(activity, "推荐请求失败!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Success(Object object, int flag) {
//            Toast.makeText(activity, "推荐请求成功!", Toast.LENGTH_SHORT).show();
            Log.d("FWTJ",object.toString());
            ServeDetail serveDetail = new Gson().fromJson(object.toString(), ServeDetail.class);
            if (serveDetail.isSuccess()){
                List<ServeDetail.RowsBean> tuijianList = serveDetail.getRows();
                serve_details__adapter = new Serve_Details_Adapter(activity, tuijianList);
                serveDetials_tuijian_Rcy.setAdapter(serve_details__adapter);
                setServeDetails_TuiJianRecyCliclListener(tuijianList);
            }
        }

    private void setServeDetails_TuiJianRecyCliclListener(final List<ServeDetail.RowsBean> tuijianList) {
        serve_details__adapter.setOnItemClickListener(new Serve_Details_Adapter.OnItemClickListener() {
            @Override
            public void onitemclicklistener(View view, int pos) {
//                Toast.makeText(activity, "服务详情之推荐", Toast.LENGTH_SHORT).show();
                Log.d("doctor1",""+tuijianList.get(pos).getImage_Url());//头像
                Log.d("doctor2",""+tuijianList.get(pos).getDoctor_Name());
                Log.d("doctor2",""+tuijianList.get(pos).getDE_Name());//科室
                Log.d("doctor3",""+tuijianList.get(pos).getJT_Name());//职称
                Log.d("doctor4",""+tuijianList.get(pos).getDoctor_SCLY());//擅长
                Log.d("doctor5",""+tuijianList.get(pos).getDoctor_GRJS());//简介
                Intent intent = new Intent(activity, Doctor_Details.class);
                intent.putExtra("doctor_image_url",tuijianList.get(pos).getImage_Url());
                intent.putExtra("doctor_name",tuijianList.get(pos).getDoctor_Name());
                intent.putExtra("doctor_de_name",tuijianList.get(pos).getDE_Name());
                intent.putExtra("doctor_jt_name",tuijianList.get(pos).getJT_Name());
                intent.putExtra("doctor_scly",tuijianList.get(pos).getDoctor_SCLY());
                intent.putExtra("doctor_grjj",tuijianList.get(pos).getDoctor_GRJS());
                activity.startActivity(intent);
            }

            @Override
            public void onlongitemclicklistener(View view, int pos) {

            }
        });
    }

    @Override
    public void onComplete() {

    }
}
