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
import android.widget.PopupWindow;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by chen on 2017/9/6.
 * 我的资料
 */

public class InformationActivity extends AppCompatActivity {

    private PopupWindow popup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        ButterKnife.inject(this);

        initPopupwindow();
    }

    private void initPopupwindow() {
        popup = new PopupWindow(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.popupwindow_choose,null);
        popup.setContentView(v);
        popup.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popup.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popup.setOutsideTouchable(true);
        popup.setBackgroundDrawable(null);
        View tv_take_photo = v.findViewById(R.id.tv_take_photo);
        View tv_pick_photo = v.findViewById(R.id.tv_pick_photo);
        View tv_cancle = v.findViewById(R.id.tv_cancle);

        tv_take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //判断是否有足够存储空间
//                if(isUsing()) {
                    //设置存储位置
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "")));
//                }
                startActivityForResult(intent, 0);
            }
        });

        tv_pick_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });

        tv_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup.dismiss();
            }
        });
    }

    @OnClick({R.id.iv_head_portrait})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_head_portrait:
                popup.showAtLocation(getWindow().getDecorView(),Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 3){//裁剪

        }else{
            Uri uri = null;
            if(requestCode == 0){//相机
                File tmpFile = new File(Environment.getExternalStorageDirectory(), "");
                uri = Uri.fromFile(tmpFile);
            }else if(requestCode == 1){//相册
                uri = data.getData();
            }
            Intent intent = new Intent("com.android.camera.action.CROP");
            intent.setDataAndType(uri, "image/*");
            intent.putExtra("crop", "true");
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("outputX", 250);
            intent.putExtra("outputY", 250);
            intent.putExtra("outputFormat", "PNG");
            intent.putExtra("return-data", true);// true:不返回uri，false：返回uri
            startActivityForResult(intent, 3);//同样的在onActivityResult中处理剪裁好的图片
        }
    }
}
