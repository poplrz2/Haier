package com.ys.haier.model;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.ys.haier.R;
import com.ys.haier.adapter.Main_PagerAdapter;
import com.ys.haier.fragment.Find_Fragment;
import com.ys.haier.fragment.Home_Fragment;
import com.ys.haier.fragment.Me_Fragment;
import com.ys.haier.fragment.Report_Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wz on 2017-08-09.
 */

public class Main_Model implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {
    ViewPager viewPager;
    List<Fragment> fragmentList;
    BottomNavigationView bottomNavigationView;
    AppCompatActivity context;

    public Main_Model(ViewPager viewPager, BottomNavigationView bottomNavigationView, AppCompatActivity context) {
        this.viewPager = viewPager;
        this.bottomNavigationView = bottomNavigationView;
        this.context = context;
        fragmentList = new ArrayList<>();
    }

    public void addFragment() {
        fragmentList.add(new Home_Fragment());
        fragmentList.add(new Find_Fragment());
        fragmentList.add(new Report_Fragment());
        fragmentList.add(new Me_Fragment());
        viewPager.setAdapter(new Main_PagerAdapter(context.getSupportFragmentManager(), fragmentList));
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bottom_home:
                viewPager.setCurrentItem(0);
                break;
            case R.id.bottom_find:
                viewPager.setCurrentItem(1);
                break;
            case R.id.bottom_report:
                viewPager.setCurrentItem(2);
                break;
            case R.id.bottom_me:
                viewPager.setCurrentItem(3);
                break;
        }
        return false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bottomNavigationView.getMenu().getItem(position).setChecked(true);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}


