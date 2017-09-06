package com.ys.haier.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;
import com.ys.haier.R;
import com.ys.haier.model.Find_Fragment_Model;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by wz on 2017-08-08.
 */

public class Find_Fragment extends Fragment {
    @InjectView(R.id.banner)
    Banner banner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.find_fragment, container, false);
        ButterKnife.inject(this, v);
        init();
        return v;
    }

    private void init() {
        Find_Fragment_Model find_fragment__model =new Find_Fragment_Model(getActivity(),banner);
        find_fragment__model.initBanner();

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
