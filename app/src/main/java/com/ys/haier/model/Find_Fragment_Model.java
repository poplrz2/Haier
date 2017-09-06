package com.ys.haier.model;

import android.app.Activity;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.ys.haier.MyApp;
import com.ys.haier.adapter.BannerImageLoader;
import com.ys.haier.data.Banner_Pic;
import com.ys.haier.interfaces.ObserverListener;
import com.ys.haier.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wz on 2017-08-09.
 */

public class Find_Fragment_Model implements ObserverListener {
    List<String> imgList;
    Activity activity;
    Banner banner;

    public Find_Fragment_Model(Activity activity, Banner banner) {
        this.activity = activity;
        this.banner = banner;

    }

    public void initBanner() {
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImageLoader(new BannerImageLoader());
        new HttpUtil().getBinner_pic(2, this);

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
    public void Success(Object object,int flag) {
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
