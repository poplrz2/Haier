package com.ys.haier.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ys.haier.R;
import com.ys.haier.adapter.HealthAdapter;
import com.ys.haier.adapter.OrderAdapter;
import com.ys.haier.util.DividerItemDecoration;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by chen on 2017/9/8.
 */

public class HealthFragment extends Fragment {

    public static final int TAG_SLEEP = 0x001; //睡眠报告
    public static final int TAG_BREATH = 0x002; //呼吸报告
    public static final int TAG_PREGNANT = 0x003; //母婴报告
    public static final int TAG_LIVE = 0x004; //康居报告

    @InjectView(R.id.rv_health)
    public RecyclerView recyclerView;

    public HealthAdapter adapter;

    public int getTYPE() {
        return TYPE;
    }

    public void setTYPE(int TYPE) {
        this.TYPE = TYPE;
    }

    public int TYPE;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_health, container, false);
        ButterKnife.inject(this, view);
        initRcyView();
        return view;
    }


    private void initRcyView() {
        adapter = new HealthAdapter(getActivity(),TYPE);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


    }
}
