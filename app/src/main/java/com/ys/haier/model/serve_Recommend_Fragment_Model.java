package com.ys.haier.model;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ys.haier.ServeDetailsActivity;
import com.ys.haier.adapter.Serve_more_Adapter;
import com.ys.haier.data.Serve;
import com.ys.haier.interfaces.ObserverListener;
import com.ys.haier.util.DividerItemDecoration;
import com.ys.haier.util.HttpUtil;
import com.ys.haier.util.SPUtils;

import java.util.List;

/**
 * Created by lzc on 2017-09-03.
 */

public class serve_Recommend_Fragment_Model implements ObserverListener {

    Activity activity;
    ProgressBar xprogressBar;
    XRecyclerView moreServeXrecyl;

    private  int type;
    private SPUtils spUtils;

    private Serve_more_Adapter serve_more_adapter;
    private List<Serve.RowsBean> serveList;

    public serve_Recommend_Fragment_Model(Activity activity, XRecyclerView moreServeXrecyl, ProgressBar xprogress) {
        this.activity = activity;
        this.moreServeXrecyl = moreServeXrecyl;
        this.xprogressBar = xprogress;
    }

    public void initMoreServeXRecyclerView(){
        spUtils = new SPUtils(activity);
        type = spUtils.getStorageInt("type");
        moreServeXrecyl.addItemDecoration(new DividerItemDecoration(activity, LinearLayoutManager.VERTICAL));
        moreServeXrecyl.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false));
        moreServeXrecyl.setPullRefreshEnabled(true);
        new HttpUtil().getService(type+"",this);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void Success(Object object, int flag) {
        Log.d("mores",object.toString());
        if (flag == 5){
            Serve serve = new Gson().fromJson(object.toString(), Serve.class);
            if (serve.isSuccess()){
                xprogressBar.setVisibility(View.GONE);
                serveList = serve.getRows();
                serve_more_adapter = new Serve_more_Adapter(activity, serveList);
                moreServeXrecyl.setAdapter(serve_more_adapter);
                XRecyclerViewListener();
            }

        }
    }

    /**
     * Fun : 给XRecyclerView设置监听事件（上拉加载，下拉刷新，item的点击事件）
     *
     */
    private void XRecyclerViewListener() {

        //设置上拉加载、下拉刷新监听事件
        moreServeXrecyl.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                moreServeXrecyl.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                moreServeXrecyl.loadMoreComplete();
            }
        });

        //回调item点击事件的接口
        serve_more_adapter.setOnitemclicklistener(new Serve_more_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (position <= serveList.size() ){
                    Intent intent = new Intent(activity, ServeDetailsActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Log.d("serveIcon",serveList.get(position - 1).getImage_Url());
                    Log.d("fw_id",serveList.get(position - 1).getID()+"");
                    intent.putExtra("fw_id",serveList.get(position - 1).getID()+"");
                    intent.putExtra("serveIcon",serveList.get(position - 1).getImage_Url());
                    intent.putExtra("serveTitle",serveList.get(position - 1).getServe_Name());
                    intent.putExtra("serveName",serveList.get(position - 1).getServe_Describe());
                    intent.putExtra("serveProducts",serveList.get(position - 1).getServe_Product());
                    activity.startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onComplete() {

    }
}
