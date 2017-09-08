package com.ys.haier.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ys.haier.R;
import com.ys.haier.adapter.OrderAdapter;
import com.ys.haier.model.Home_Fragment_Model;
import com.ys.haier.util.DividerItemDecoration;
import com.ys.haier.util.SPUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by chen on 2017/9/7.
 */

public class OrderFragment extends Fragment {

    public static final int TAG_WHOLE = 0x001; //全部订单
    public static final int TAG_WAITING_PAY = 0x002; //等待支付订单
    public static final int TAG_RUNING = 0x003; //正在支付订单
    public static final int TAG_FINISH = 0x004; //已完成订单

    @InjectView(R.id.rv_order)
    public RecyclerView recyclerView;

    public OrderAdapter adapter;

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
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        ButterKnife.inject(this, view);
        initRcyView();
        return view;
    }


    private void initRcyView() {
        adapter = new OrderAdapter(getActivity());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


    }


}
