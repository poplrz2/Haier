package com.ys.haier.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lzc on 2017-08-22.FragmentPagerAdapter
 */

public class MoreNews_ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private String TITLE[];

    public MoreNews_ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }


    public MoreNews_ViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList,String [] TITLE) {
        super(fm);
        this.fragmentList = fragmentList;
        this.TITLE = TITLE;
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
        return TITLE[position];
    }
}
