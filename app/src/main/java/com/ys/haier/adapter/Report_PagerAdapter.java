package com.ys.haier.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by wz on 2017-08-09.
 */

public class Report_PagerAdapter extends FragmentPagerAdapter {
    String[] title;
    List<Fragment> fragmentList;
    public Report_PagerAdapter(FragmentManager fm, String[] title, List<Fragment> fragmentList) {
        super(fm);
        this.title=title;
        this.fragmentList=fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
