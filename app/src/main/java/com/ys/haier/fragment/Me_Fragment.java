package com.ys.haier.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.squareup.picasso.Picasso;
import com.ys.haier.AttationActivity;
import com.ys.haier.DeviceActivity;
import com.ys.haier.HealthActivity;
import com.ys.haier.InformationActivity;
import com.ys.haier.OrderActivity;
import com.ys.haier.R;
import com.ys.haier.util.CircleTransform;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by wz on 2017-08-08.
 */

public class Me_Fragment extends Fragment {

    @InjectView(R.id.imageView)
    ImageView imageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.me_fragment,container,false);
        ButterKnife.inject(this, v);
        Picasso.with(getActivity())
                .load("http://img4.imgtn.bdimg.com/it/u=3929251423,454148251&fm=27&gp=0.jpg")
                .transform(new CircleTransform())
                .error(R.drawable.default_binner_pic)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);

        return v;
    }

    @OnClick({ R.id.ll_information, R.id.ll_order,R.id.ll_health,R.id.ll_device,R.id.ll_attation})
    public void onClick(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.ll_information:
                intent = new Intent(getActivity(), InformationActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.ll_order:
                intent = new Intent(getActivity(), OrderActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.ll_health:
                intent = new Intent(getActivity(), HealthActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.ll_device:
                intent = new Intent(getActivity(), DeviceActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.ll_attation:
                intent = new Intent(getActivity(), AttationActivity.class);
                getActivity().startActivity(intent);
                break;
            default:
                break;
        }
    }
}
