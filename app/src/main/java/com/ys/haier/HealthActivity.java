package com.ys.haier;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.viewpagerindicator.TabPageIndicator;
import com.ys.haier.adapter.MoreNews_ViewPagerAdapter;
import com.ys.haier.fragment.HealthFragment;
import com.ys.haier.fragment.OrderFragment;
import com.ys.haier.util.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by chen on 2017/9/6.
 * 健康报告
 */

public class HealthActivity extends FragmentActivity {

    private static final String TITLE[] = {"睡眠", "呼吸", "母婴", "康居"};
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
        setContentView(R.layout.activity_order);
        ButterKnife.inject(this);

        initFragments();

        MoreNews_ViewPagerAdapter adapter = new MoreNews_ViewPagerAdapter(getSupportFragmentManager(), newsfmlist, TITLE);
        newsPager.setAdapter(adapter);
        newsIndicator.setViewPager(newsPager);
        initPagerScrollListener();

    }

    @OnClick({R.id.back_arrow})
    public void OnClickListener(View view){
        switch (view.getId()){
            case R.id.back_arrow:
                finish();
                break;
        }

    }

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

    private void initFragments() {
        newsfmlist = new ArrayList<>();
        HealthFragment fragment = new HealthFragment();
        fragment.setTYPE(HealthFragment.TAG_SLEEP);//睡眠
        HealthFragment fragment2 = new HealthFragment();
        fragment2.setTYPE(HealthFragment.TAG_BREATH);//呼吸
        HealthFragment fragment3 = new HealthFragment();
        fragment3.setTYPE(HealthFragment.TAG_PREGNANT);//母婴
        HealthFragment fragment4 = new HealthFragment();
        fragment4.setTYPE(HealthFragment.TAG_LIVE);//康居

        newsfmlist.add(fragment);
        newsfmlist.add(fragment2);
        newsfmlist.add(fragment3);
        newsfmlist.add(fragment4);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (newsfmlist != null){
            newsfmlist = null;
        }
    }
}
