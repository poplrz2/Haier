package com.ys.haier.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ys.haier.R;
import com.ys.haier.model.Recommend_Fragment_Model;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by wz on 2017-08-22.
 */

public class Fragment_Recommend extends Fragment {

    @InjectView(R.id.more_news_xrecycle)
    XRecyclerView moreNewsXRecycle;
    @InjectView(R.id.xprogress)
    ProgressBar xprogressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend2, container, false);
        ButterKnife.inject(this, view);
        init();
        return view;
    }

    private void init() {
        Recommend_Fragment_Model recommend_fragment_model = new Recommend_Fragment_Model(getActivity(),moreNewsXRecycle,xprogressBar);
        recommend_fragment_model.initXRecyclerView();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
