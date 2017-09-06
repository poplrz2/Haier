package com.ys.haier;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.viewpagerindicator.TabPageIndicator;
import com.ys.haier.adapter.MoreServe_ViewPagerAdapter;
import com.ys.haier.fragment.serve_Fragment_ChineseMedicineHealth;
import com.ys.haier.fragment.serve_Fragment_ChronicTreatment;
import com.ys.haier.fragment.serve_Fragment_CommenDisease;
import com.ys.haier.fragment.serve_Fragment_HealthTechnology;
import com.ys.haier.fragment.serve_Fragment_PregnancyKnowledge;
import com.ys.haier.fragment.serve_Fragment_Recommend;
import com.ys.haier.util.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by lzc on 2017-09-03.
 */

public class MoreServe extends FragmentActivity {

    private static final String TITLE[] = {"推  荐", "中医养生", "健康科技", "常见病", "孕期小知识", "慢性治疗"};

    @InjectView(R.id.back_arrow)
    ImageView backArrow;
    @InjectView(R.id.titleBarText)
    TextView titleBarText;
    @InjectView(R.id.serve_indicator)
    TabPageIndicator serveIndicator;
    @InjectView(R.id.serve_pager)
    ViewPager servePager;

    private List<Fragment> fmList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setWindowStatusBarColor(this,R.color.default_color);
        setContentView(R.layout.activity_more_serve);
        ButterKnife.inject(this);

        titleBarText.setText("服务");

        initFragments();
        MoreServe_ViewPagerAdapter adapter = new MoreServe_ViewPagerAdapter(getSupportFragmentManager(), fmList, TITLE);
        servePager.setAdapter(adapter);
        serveIndicator.setViewPager(servePager);
    }

    private void initFragments() {
        fmList = new ArrayList<>();
        fmList.add(new serve_Fragment_Recommend());
        fmList.add(new serve_Fragment_ChineseMedicineHealth());
        fmList.add(new serve_Fragment_HealthTechnology());
        fmList.add(new serve_Fragment_CommenDisease());
        fmList.add(new serve_Fragment_PregnancyKnowledge());
        fmList.add(new serve_Fragment_ChronicTreatment());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (fmList != null){
            fmList = null;
        }
    }

    @OnClick({R.id.back_arrow})
    public void OnClick(View view){
        switch(view.getId()){
            case R.id.back_arrow:
                this.finish();
                break;
        }
    }
}
