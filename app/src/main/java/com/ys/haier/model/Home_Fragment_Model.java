package com.ys.haier.model;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.ys.haier.MoreNews;
import com.ys.haier.MoreServe;
import com.ys.haier.MyApp;
import com.ys.haier.NewsDetailsActivity;
import com.ys.haier.R;
import com.ys.haier.ServeDetailsActivity;
import com.ys.haier.adapter.BannerImageLoader;
import com.ys.haier.adapter.Home_NewsRecycler_Adapter;
import com.ys.haier.adapter.Home_ServeRecycler_Adapter;
import com.ys.haier.data.Banner_Pic;
import com.ys.haier.data.News;
import com.ys.haier.data.Serve;
import com.ys.haier.interfaces.ObserverListener;
import com.ys.haier.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzc on 2017-08-11.
 */

public class Home_Fragment_Model implements ObserverListener {
    List<String> imgList;
    Activity activity;
    Banner banner;
    RecyclerView home_news_recyclerView;
    RecyclerView home_serve_recycleView;
    Home_NewsRecycler_Adapter adapter;
    Home_ServeRecycler_Adapter serve_adapter;

    public Home_Fragment_Model(Activity activity, Banner banner, RecyclerView home_news_recyclerView,RecyclerView home_serve_recycleView) {
        this.activity = activity;
        this.banner = banner;
        this.home_news_recyclerView = home_news_recyclerView;
        this.home_serve_recycleView = home_serve_recycleView;
    }

    /**
     * Fun ： 初始化广告栏
     * LZC
     * 2017/08/08
     */
    public void initBanner() {
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImageLoader(new BannerImageLoader());
        new HttpUtil().getBinner_pic(0, this);
    }

    /**
     * Fun ： 初始化首页资讯RecyclerView
     * LZC
     * 2017/08/08
     */
    public void initNewsRecyclerView(int type) {
        new HttpUtil().getNews(type + "", this);//type = 1;
    }

    /**
     * Fun ： 初始化首页服务RecyclerView
     * LZC
     * 2017/08/08
     */
    public void initServeRecyclerView(int type) {
        new HttpUtil().getService(type + "",this);//type = 2;
    }

    @Override
    public void onError(Throwable e) {
        Logger.i(e.getMessage());
        imgList = new ArrayList<>();
        fail_show_banner();
        banner.setImages(imgList);
        banner.start();
    }

    @Override
    public void Success(Object object, int flag) {
        if (flag == 3) {
            Log.d("newsfl",object.toString());
            News news = new Gson().fromJson(object.toString(), News.class);
            if (news.isSuccess()) {
                List<News.RowsBean> newsList = news.getRows();
                adapter =new Home_NewsRecycler_Adapter(activity,newsList);
                home_news_recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                setFooterView(home_news_recyclerView);
                //设置点击事件
                setRecyclerViewLClickListener(newsList);
            }
        }else if (flag == 5){
            Log.d("FW", object.toString());
            Serve serve = new Gson().fromJson(object.toString(), Serve.class);
            if (serve.isSuccess()){
                List<Serve.RowsBean> serveList = serve.getRows();
                serve_adapter = new Home_ServeRecycler_Adapter(activity,serveList);
                home_serve_recycleView.setAdapter(serve_adapter);
                serve_adapter.notifyDataSetChanged();
                setServeFooterView(home_serve_recycleView);
                setServeRecyclerViewLClickListener(serveList);
            }
        }
        else {
            Logger.i(object.toString());
            imgList = new ArrayList<>();
            Banner_Pic binner_pic = new Gson().fromJson(object.toString(), Banner_Pic.class);
            if (binner_pic.isSuccess()) {
                success_show_banner(binner_pic);
            } else {
                fail_show_banner();
            }
            banner.setImages(imgList);
            banner.start();
        }
    }

    /**
     * 给首页->服务设置监听器
     * LZC
     * 2017/09/01
     * @param serveList
     */
    private void setServeRecyclerViewLClickListener(final List<Serve.RowsBean> serveList) {
        serve_adapter.setOnItemClickListenr(new Home_ServeRecycler_Adapter.OnItemClickListener() {
            @Override
            public void onitemclicklistenr(View view, int pos) {
                if (pos <serveList.size() ){
                    Intent intent = new Intent(activity, ServeDetailsActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Log.d("serveIcon",serveList.get(pos).getImage_Url());
                    Log.d("fw_id",serveList.get(pos).getID()+"");
                    intent.putExtra("fw_id",serveList.get(pos).getID()+"");
                    intent.putExtra("serveIcon",serveList.get(pos).getImage_Url());
                    intent.putExtra("serveTitle",serveList.get(pos).getServe_Name());
                    intent.putExtra("serveName",serveList.get(pos).getServe_Describe());
                    intent.putExtra("serveProducts",serveList.get(pos).getServe_Product());
                    activity.startActivity(intent);
                }

                if (pos == serveList.size()){
//                    Toast.makeText(activity, "更多服务", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity, MoreServe.class);
                    activity.startActivity(intent);
                }
            }

            @Override
            public void onlongitemclicklistener(View view, int position) {

            }
        });

    }

    /**
     * Home页RecyclerView点击事件
     * 2017/8/18，
     * LZC
     */
    private void setRecyclerViewLClickListener(final List<News.RowsBean> newsList) {
        adapter.setOnItemClickListenr(new Home_NewsRecycler_Adapter.OnItemClickListener() {
            @Override
            public void onitemclicklistenr(View view, int pos) {
                if (pos <newsList.size()){
                    String news_describle = newsList.get(pos).getNews_Describe();
                    Intent intent =new Intent(activity, NewsDetailsActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("newsDescrible",news_describle);
                    Log.d("xx",news_describle);
                    activity.startActivity(intent);
                }

                if (pos == newsList.size()){
//                    Toast.makeText(activity, "更多资讯", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity, MoreNews.class);
                    activity.startActivity(intent);
                }

            }

            @Override
            public void onlongitemclicklistener(View view, int position) {

            }
        });
    }

    private void setFooterView(RecyclerView recyclerView) {
        View FooterView = LayoutInflater.from(activity).inflate(R.layout.recycler_footerview,recyclerView,false);
        adapter.setmFooterView(FooterView);
    }

    private void setServeFooterView(RecyclerView home_serve_recycleView) {
        View FooterView = LayoutInflater.from(activity).inflate(R.layout.recycler_serve_footerview,home_serve_recycleView,false);
        serve_adapter.setmFooterView(FooterView);
    }


    private void success_show_banner(Banner_Pic binner_pic) {
        List<Banner_Pic.RowsBean> rowsBeanList = binner_pic.getRows();
        for (Banner_Pic.RowsBean rowsBean : rowsBeanList) {
            imgList.add(MyApp.URL_SERVER + rowsBean.getAd_ImageUrl());
        }
    }

    private void fail_show_banner() {
        Logger.i("获取轮播图失败");
        for (int i = 0; i < 4; i++) {
            imgList.add("https://fakeimg.pl/1280x480/?text=Winsoft&font=lobster");
        }
    }

    @Override
    public void onComplete() {

    }
}
