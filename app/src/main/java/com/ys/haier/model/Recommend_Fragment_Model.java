package com.ys.haier.model;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ys.haier.NewsDetailsActivity;
import com.ys.haier.adapter.Home_NewsXRecycler_Adapter;
import com.ys.haier.data.News;
import com.ys.haier.interfaces.ObserverListener;
import com.ys.haier.util.DividerItemDecoration;
import com.ys.haier.util.HttpUtil;
import com.ys.haier.util.SPUtils;

import java.util.List;

/**
 * Created by lzc on 2017-08-22.
 */

public class Recommend_Fragment_Model implements ObserverListener {
    List<News.RowsBean> newsList_GD;
    Home_NewsXRecycler_Adapter xadapter;
    Activity activity;
    ProgressBar xprogressBar;
    XRecyclerView xRecyclerView;

    private  int type;
    private SPUtils spUtils;

    public Recommend_Fragment_Model(Activity activity, XRecyclerView moreNewsxRecycle, ProgressBar xprogressBar) {
        this.xRecyclerView = moreNewsxRecycle;
        this.activity = activity;
        this.xprogressBar = xprogressBar;
    }


    public void initXRecyclerView(){
        spUtils = new SPUtils(activity);
        type = spUtils.getStorageInt("type");
        xRecyclerView.addItemDecoration(new DividerItemDecoration(activity,LinearLayoutManager.VERTICAL));
        xRecyclerView.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false));
        xRecyclerView.setPullRefreshEnabled(true);
        new HttpUtil().getNewsGD(type+"",this);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void Success(Object object, int flag) {
        if (flag == 4){
            final News news = new Gson().fromJson(object.toString(), News.class);
            if (news.isSuccess()){
                xprogressBar.setVisibility(View.GONE);
                newsList_GD = news.getRows();
                xadapter = new Home_NewsXRecycler_Adapter(activity,newsList_GD);
                xRecyclerView.setAdapter(xadapter);
                XRecyclerViewListener();
            }
        }
    }

    /**
     * Fun : 设置XRecyclerView的item监听事件
     * LZC
     * 2017/09/01
     */
    private void XRecyclerViewListener() {
        xadapter.setOnItemClickListenr(new Home_NewsXRecycler_Adapter.OnItemClickListener()
        {

            @Override
            public void onitemclicklistenr(View view, int pos) {
                Toast.makeText(activity, "item"+ pos+"被点击了", Toast.LENGTH_SHORT).show();
                if (pos <=newsList_GD.size()){
                    String news_describle = newsList_GD.get(pos -1).getNews_Describe();
                    Intent intent =new Intent(activity, NewsDetailsActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("newsDescrible",news_describle);
                    activity.startActivity(intent);
                }
            }

            @Override
            public void onlongitemclicklistener(View view, int position) {

            }
        });

        //设置XRecyclerView的上拉刷新下拉加载监听器
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(activity, "下拉刷新", Toast.LENGTH_SHORT).show();
                xRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(activity, "上拉加载更多", Toast.LENGTH_SHORT).show();
                xRecyclerView.loadMoreComplete();
            }
        });
    }

    @Override
    public void onComplete() {

    }
}
