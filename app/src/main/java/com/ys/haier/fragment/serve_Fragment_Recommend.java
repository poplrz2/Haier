package com.ys.haier.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ys.haier.R;
import com.ys.haier.model.serve_Recommend_Fragment_Model;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by lzc on 2017-09-03.
 */

public class serve_Fragment_Recommend extends Fragment {

    @InjectView(R.id.xprogress)
    ProgressBar xprogress;
    @InjectView(R.id.more_serve_xrecyl)
    XRecyclerView moreServeXrecyl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.serve_fragment_recommend, container, false);
        ButterKnife.inject(this, view);
        init();
        return view;
    }

    private void init() {
        serve_Recommend_Fragment_Model serve_recommend_fragment_model = new serve_Recommend_Fragment_Model(getActivity(), moreServeXrecyl, xprogress);
        serve_recommend_fragment_model.initMoreServeXRecyclerView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

}
