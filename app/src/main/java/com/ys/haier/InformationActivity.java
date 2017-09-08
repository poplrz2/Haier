package com.ys.haier;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.squareup.picasso.Picasso;
import com.ys.haier.util.CircleTransform;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by chen on 2017/9/6.
 * 我的资料
 */
public class InformationActivity extends AppCompatActivity {

    @InjectView(R.id.iv_head_portrait)
    ImageView iv_head_portrait;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        ButterKnife.inject(this);

        Picasso.with(this)
                .load("http://img4.imgtn.bdimg.com/it/u=3929251423,454148251&fm=27&gp=0.jpg")
                .transform(new CircleTransform())
                .error(R.drawable.default_binner_pic)
                .placeholder(R.mipmap.ic_launcher)
                .into(iv_head_portrait);
    }

    @OnClick({R.id.iv_head_portrait})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_head_portrait:
                Intent intent = new Intent(this,HeadPortraitActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
