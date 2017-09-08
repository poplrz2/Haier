package com.ys.haier;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.ys.haier.util.CircleTransform;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by chen on 2017/9/8.
 */
public class HealthBreathActivity extends AppCompatActivity {

    @InjectView(R.id.iv_head_portrait)
    ImageView iv_head_portrait;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_breath);
        ButterKnife.inject(this);

        Picasso.with(this)
                .load("http://img4.imgtn.bdimg.com/it/u=3929251423,454148251&fm=27&gp=0.jpg")
                .transform(new CircleTransform())
                .error(R.drawable.default_binner_pic)
                .placeholder(R.mipmap.ic_launcher)
                .into(iv_head_portrait);
    }
}
