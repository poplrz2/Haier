package com.ys.haier.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lzc on 2017-09-03.
 */

public class MoreServe_ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fmList;
    private String[] title;

    public MoreServe_ViewPagerAdapter(FragmentManager fm, List<Fragment> fmList, String[] title) {
        super(fm);
        this.fmList = fmList;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return fmList.get(position);
    }

    @Override
    public int getCount() {
        return fmList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
