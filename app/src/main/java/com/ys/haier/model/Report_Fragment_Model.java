package com.ys.haier.model;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.TableLayout;

import com.ys.haier.adapter.Report_PagerAdapter;
import com.ys.haier.fragment.Body_Fragment;
import com.ys.haier.fragment.Breathing_Fragment;
import com.ys.haier.fragment.Find_Fragment;
import com.ys.haier.fragment.Home_Fragment;
import com.ys.haier.fragment.Me_Fragment;
import com.ys.haier.fragment.Report_Fragment;
import com.ys.haier.fragment.Sleep_Fragment;
import com.ys.haier.fragment.Sogdiana_Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wz on 2017-08-09.
 */

public class Report_Fragment_Model {
    List<Fragment> fragmentList;
    FragmentActivity context;
    String[] titles = {"睡眠", "呼吸", "母婴", "家居"};

    public Report_Fragment_Model(FragmentActivity context) {
        this.context = context;
        fragmentList = new ArrayList<>();
    }

    public void initView(TabLayout tabLayout, ViewPager viewPager) {
        fragmentList.add(new Sleep_Fragment());
        fragmentList.add(new Breathing_Fragment());
        fragmentList.add(new Body_Fragment());
        fragmentList.add(new Sogdiana_Fragment());

        viewPager.setAdapter(new Report_PagerAdapter(context.getSupportFragmentManager(), titles, fragmentList));
        tabLayout.setupWithViewPager(viewPager);
    }
}
