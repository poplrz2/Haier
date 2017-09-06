package com.ys.haier.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ys.haier.R;
import com.ys.haier.model.Report_Fragment_Model;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by wz on 2017-08-08.
 */

public class Report_Fragment extends Fragment {
    @InjectView(R.id.report_title)
    TextView reportTitle;
    @InjectView(R.id.reprot_tab)
    TabLayout reprotTab;
    @InjectView(R.id.reprot_vp)
    ViewPager reprotVp;
    Report_Fragment_Model report_fragment_model;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.report_fragment, container, false);
        ButterKnife.inject(this, v);
        init();
        return v;
    }

    private void init() {
        report_fragment_model = new Report_Fragment_Model(getActivity());
        report_fragment_model.initView(reprotTab, reprotVp);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
        report_fragment_model = null;
    }
}
