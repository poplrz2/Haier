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
import com.ys.haier.adapter.MoreNews_ViewPagerAdapter;
import com.ys.haier.fragment.Fragment_ChineseMedicineHealth;
import com.ys.haier.fragment.Fragment_ChronicTreatment;
import com.ys.haier.fragment.Fragment_CommenDisease;
import com.ys.haier.fragment.Fragment_HealthTechnology;
import com.ys.haier.fragment.Fragment_PregnancyKnowledge;
import com.ys.haier.fragment.Fragment_Recommend;
import com.ys.haier.util.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by lzc on 2017-08-21.
 */

public class MoreNews extends FragmentActivity {

    private static final String TITLE[] = {"推  荐", "中医养生", "健康科技", "常见病", "孕期小知识", "慢性治疗"};
    @InjectView(R.id.back_arrow)
    ImageView backArrow;
    @InjectView(R.id.titleBarText)
    TextView titleBarText;
    @InjectView(R.id.news_indicator)
    TabPageIndicator newsIndicator;
    @InjectView(R.id.news_pager)
    ViewPager newsPager;


    private List<Fragment> newsfmlist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setWindowStatusBarColor(this,R.color.default_color);
        setContentView(R.layout.activity_more_news);
        ButterKnife.inject(this);

        initFragments();

        MoreNews_ViewPagerAdapter adapter = new MoreNews_ViewPagerAdapter(getSupportFragmentManager(), newsfmlist, TITLE);
        newsPager.setAdapter(adapter);

        newsIndicator.setViewPager(newsPager);
//        initPagerScrollListener();

    }

    @OnClick({R.id.back_arrow})
    public void OnClickListener(View view){
        switch (view.getId()){
            case R.id.back_arrow:
                finish();
                break;
        }

    }

    /**
     *  FUN:设置ViewPager的滑动监听事件，每滑动一次，TITLE跟着改变 
     *  2017/08/22
     *  LZC
      */
    private void initPagerScrollListener() {
        newsIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Toast.makeText(MoreNews.this, TITLE[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     *  FUN:初始化咨讯页面的Fragment  
     *  2017/08/22 LZC
     */
    private void initFragments() {
        newsfmlist = new ArrayList<>();
        newsfmlist.add(new Fragment_Recommend());
        newsfmlist.add(new Fragment_ChineseMedicineHealth());
        newsfmlist.add(new Fragment_HealthTechnology());
        newsfmlist.add(new Fragment_CommenDisease());
        newsfmlist.add(new Fragment_PregnancyKnowledge());
        newsfmlist.add(new Fragment_ChronicTreatment());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (newsfmlist != null){
            newsfmlist = null;
        }
    }
}
