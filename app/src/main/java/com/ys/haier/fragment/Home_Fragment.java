package com.ys.haier.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.ys.haier.MyApp;
import com.ys.haier.R;
import com.ys.haier.data.Fl;
import com.ys.haier.interfaces.ObserverListener;
import com.ys.haier.model.Home_Fragment_Model;
import com.ys.haier.util.DividerItemDecoration;
import com.ys.haier.util.HttpUtil;
import com.ys.haier.util.SPUtils;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by lzc on 2017-08-08.
 */

public class Home_Fragment extends Fragment implements ObserverListener {
    @InjectView(R.id.home_banner)
    Banner homeBanner;
    @InjectView(R.id.hom_serve_rly)
    RecyclerView hom_serve_Rly;
    @InjectView(R.id.home_sleep)
    LinearLayout homeSleep;
    @InjectView(R.id.home_breath)
    LinearLayout homeBreath;
    @InjectView(R.id.home_muying)
    LinearLayout homeMuying;
    @InjectView(R.id.home_kangju)
    LinearLayout homeKangju;
    @InjectView(R.id.icon_sleep)
    ImageView iconSleep;
    @InjectView(R.id.icon_breath)
    ImageView iconBreath;
    @InjectView(R.id.icon_muying)
    ImageView iconMuying;
    @InjectView(R.id.icon_kangju)
    ImageView iconKangju;
    @InjectView(R.id.hom_news_rly)
    RecyclerView hom_news_Rly;

    private String sleep_img_h, sleep_img_q;
    private String breath_img_h, breath_img_q;
    private String my_img_h, my_img_q;
    private String kangju_img_h, kangju_img_q;

    Home_Fragment_Model home_fragment_model;
    private List<Fl.RowsBean> flList;
    private int type = 1;
    private boolean isFirstIn = true;
    private int press_flag = 1;

    private SPUtils spUtils;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        ButterKnife.inject(this, view);
        spUtils = new SPUtils(getActivity());
        initRcyView();
        init();
        return view;
    }

    /**
     * Fun : 给RecyclerView添加布局管理器和分割线
     */
    private void initRcyView() {
//        hom_news_Rly.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        hom_news_Rly.setLayoutManager(new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        hom_news_Rly.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
//        hom_serve_Rly.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        hom_serve_Rly.setLayoutManager(new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        hom_serve_Rly.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        init(type);
        Toast.makeText(getActivity(), "onViewCreated", Toast.LENGTH_SHORT).show();
    }

    /**
     * 选择首页的睡眠、呼吸、母婴、康居更新数据
     * LZC
     * 2017/08/31
     * @param type
     */
    private void init(int type) {
        hom_news_Rly.getRecycledViewPool().clear();
        hom_serve_Rly.getRecycledViewPool().clear();
        home_fragment_model = new Home_Fragment_Model(getActivity()
                , homeBanner
                , hom_news_Rly
                , hom_serve_Rly
        );
        home_fragment_model.initBanner();
        home_fragment_model.initNewsRecyclerView(type);
        home_fragment_model.initServeRecyclerView(type);
    }

    /**
     * Fun ：初始化数据，默认是首页->睡眠的数据
     * LZC
     * 2017/08/31
     */
    private void init() {
//        hom_news_Rly.getRecycledViewPool().clear();
//        hom_serve_Rly.getRecycledViewPool().clear();
        new HttpUtil().getFl(this);
        home_fragment_model = new Home_Fragment_Model(getActivity()
                , homeBanner
                , hom_news_Rly
                , hom_serve_Rly
        );
        Picasso.with(getActivity()).load(MyApp.URL_SERVER + sleep_img_h).into(iconSleep);
        home_fragment_model.initBanner();
        home_fragment_model.initNewsRecyclerView(1);
        home_fragment_model.initServeRecyclerView(1);
    }

    /**
     * Fun ：给首页的睡眠、呼吸、母婴、康居添加点击事件
     * LZC
     * 2017/08/31
     *
     * @param view
     */
    @OnClick({R.id.icon_sleep, R.id.icon_breath, R.id.icon_muying, R.id.icon_kangju})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.icon_sleep:
                press_flag = 1;
                new HttpUtil().getFl(this);
                break;

            case R.id.icon_breath:
                press_flag = 2;
                new HttpUtil().getFl(this);
                break;

            case R.id.icon_muying:
                press_flag = 3;
                new HttpUtil().getFl(this);
                break;

            case R.id.icon_kangju:
                press_flag = 4;
                new HttpUtil().getFl(this);
                break;

        }
    }

    @Override
    public void Success(Object object, int flag) {
        Log.d("fl", object.toString());
        Fl fl = new Gson().fromJson(object.toString(), Fl.class);
        if (fl.isSuccess()) {
            if (isFirstIn) {
                flList = fl.getRows();
                type = flList.get(0).getID();

                spUtils.StorageInt("type",type);

                Log.d("ID", type + "");
                isFirstIn = false;
                sleep_img_h = MyApp.URL_SERVER + flList.get(0).getImgh();
                Picasso.with(getActivity()).load(sleep_img_h).into(iconSleep);

                breath_img_q = MyApp.URL_SERVER + flList.get(1).getImgq();
                Picasso.with(getActivity()).load(breath_img_q).into(iconBreath);
                Log.d("breath_img_q", breath_img_q);

                my_img_q = MyApp.URL_SERVER + flList.get(2).getImgq();
                Picasso.with(getActivity()).load(my_img_q).into(iconMuying);
                Log.d("my_img_q", my_img_q);

                kangju_img_q = MyApp.URL_SERVER + flList.get(3).getImgq();
                Picasso.with(getActivity()).load(kangju_img_q).into(iconKangju);
                Log.d("kangju_img_q", kangju_img_q);
            } else {
                if (press_flag == 1) {
                    flList = fl.getRows();
                    type = flList.get(0).getID();

                    spUtils.StorageInt("type",type);

                    Log.d("ID", type + "");
                    init(type);

                    isFirstIn = false;
                    sleep_img_h = MyApp.URL_SERVER + flList.get(0).getImgh();
                    Picasso.with(getActivity()).load(sleep_img_h).into(iconSleep);

                    breath_img_q = MyApp.URL_SERVER + flList.get(1).getImgq();
                    Picasso.with(getActivity()).load(breath_img_q).into(iconBreath);
                    Log.d("breath_img_q", breath_img_q);

                    my_img_q = MyApp.URL_SERVER + flList.get(2).getImgq();
                    Picasso.with(getActivity()).load(my_img_q).into(iconMuying);
                    Log.d("my_img_q", my_img_q);

                    kangju_img_q = MyApp.URL_SERVER + flList.get(3).getImgq();
                    Picasso.with(getActivity()).load(kangju_img_q).into(iconKangju);
                    Log.d("kangju_img_q", kangju_img_q);
                } else if (press_flag == 2) {
                    flList = fl.getRows();
                    type = flList.get(1).getID();

                    spUtils.StorageInt("type",type);

                    Log.d("ID", type + "");
                    init(type);

                    sleep_img_q = MyApp.URL_SERVER + flList.get(0).getImgq();
                    Picasso.with(getActivity()).load(sleep_img_q).into(iconSleep);

                    breath_img_h = MyApp.URL_SERVER + flList.get(1).getImgh();
                    Picasso.with(getActivity()).load(breath_img_h).into(iconBreath);
                    Log.d("breath_img_h", breath_img_h);

                    my_img_q = MyApp.URL_SERVER + flList.get(2).getImgq();
                    Picasso.with(getActivity()).load(my_img_q).into(iconMuying);
                    Log.d("my_img_q", my_img_q);

                    kangju_img_q = MyApp.URL_SERVER + flList.get(3).getImgq();
                    Picasso.with(getActivity()).load(kangju_img_q).into(iconKangju);
                    Log.d("kangju_img_q", kangju_img_q);
                } else if (press_flag == 3) {
                    flList = fl.getRows();
                    type = flList.get(2).getID();

                    spUtils.StorageInt("type",type);

                    Log.d("ID", type + "");
                    init(type);

                    sleep_img_q = MyApp.URL_SERVER + flList.get(0).getImgq();
                    Picasso.with(getActivity()).load(sleep_img_q).into(iconSleep);

                    breath_img_q = MyApp.URL_SERVER + flList.get(1).getImgq();
                    Picasso.with(getActivity()).load(breath_img_q).into(iconBreath);
                    Log.d("breath_img_q", breath_img_q);

                    my_img_h = MyApp.URL_SERVER + flList.get(2).getImgh();
                    Picasso.with(getActivity()).load(my_img_h).into(iconMuying);
                    Log.d("my_img_h", my_img_h);

                    kangju_img_q = MyApp.URL_SERVER + flList.get(3).getImgq();
                    Picasso.with(getActivity()).load(kangju_img_q).into(iconKangju);
                    Log.d("kangju_img_q", kangju_img_q);
                } else if (press_flag == 4) {
                    flList = fl.getRows();
                    type = flList.get(3).getID();

                    spUtils.StorageInt("type",type);

                    Log.d("ID", type + "");
                    init(type);

                    sleep_img_q = MyApp.URL_SERVER + flList.get(0).getImgq();
                    Picasso.with(getActivity()).load(sleep_img_q).into(iconSleep);

                    breath_img_q = MyApp.URL_SERVER + flList.get(1).getImgq();
                    Picasso.with(getActivity()).load(breath_img_q).into(iconBreath);
                    Log.d("breath_img_q", breath_img_q);

                    my_img_q = MyApp.URL_SERVER + flList.get(2).getImgq();
                    Picasso.with(getActivity()).load(my_img_q).into(iconMuying);
                    Log.d("my_img_q", my_img_q);

                    kangju_img_h = MyApp.URL_SERVER + flList.get(3).getImgh();
                    Picasso.with(getActivity()).load(kangju_img_h).into(iconKangju);
                    Log.d("kangju_img_h", kangju_img_h);
                }
            }
        }
    }


    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
        getActivity().finish();
    }

//    @OnClick(R.id.tv_add_device)
//    public void onViewClicked() {
//        startActivity(new Intent(getContext(), Connecting_DeviceActivity.class));
//    }

}
