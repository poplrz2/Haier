package com.ys.haier.model;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ys.haier.adapter.Serve_Details_Adapter;
import com.ys.haier.data.ServeDetail;
import com.ys.haier.interfaces.ObserverListener;
import com.ys.haier.util.DividerItemDecoration;
import com.ys.haier.util.HttpUtil;

import java.util.List;

/**
 * Created by lzc on 2017-08-27.
 */

public class ServeDetails_Guanzhu_Model implements ObserverListener {

    private Activity activity;
    private RecyclerView serveDetials_guanzhu_Rcy;
    private String fw_id,dl_id;
    private Serve_Details_Adapter serve_details_adapter;

    public ServeDetails_Guanzhu_Model(Activity activity, RecyclerView serveDetials_tuijian_Rcy, String fw_id, String dl_id) {
        this.activity = activity;
        this.serveDetials_guanzhu_Rcy = serveDetials_tuijian_Rcy;
        this.fw_id = fw_id;
        this.dl_id = dl_id;
    }

    public void initServeGuanZhuRcy(){
        LinearLayoutManager manager = new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false);
        serveDetials_guanzhu_Rcy.setLayoutManager(manager);
        serveDetials_guanzhu_Rcy.addItemDecoration(new DividerItemDecoration(activity,DividerItemDecoration.VERTICAL_LIST));
        new HttpUtil().getServeDetials_guanzhu(fw_id,dl_id,this);
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(activity, "关注请求失败!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Success(Object object, int flag) {
//            Toast.makeText(activity, "关注请求成功!", Toast.LENGTH_SHORT).show();
            Log.d("FWGZ",object.toString());
            ServeDetail serveDetail = new Gson().fromJson(object.toString(), ServeDetail.class);
            if (serveDetail.isSuccess()){
                List<ServeDetail.RowsBean> guanzhuList = serveDetail.getRows();
                serve_details_adapter = new Serve_Details_Adapter(activity, guanzhuList);
                serveDetials_guanzhu_Rcy.setAdapter(serve_details_adapter);
                setServeDetails_GuanZhuRecyCliclListener(guanzhuList);
            }
        }

    private void setServeDetails_GuanZhuRecyCliclListener(final List<ServeDetail.RowsBean> tuijianList) {
        serve_details_adapter.setOnItemClickListener(new Serve_Details_Adapter.OnItemClickListener() {
            @Override
            public void onitemclicklistener(View view, int pos) {
//                Toast.makeText(activity, "服务详情之关注", Toast.LENGTH_SHORT).show();
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
