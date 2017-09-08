package com.ys.haier;

import android.content.Intent;
import android.graphics.Bitmap;
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
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.squareup.picasso.Picasso;
import com.ys.haier.R;
import com.ys.haier.model.HeadPortrait_Model;
import com.ys.haier.util.CircleTransform;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by chen on 2017/9/7.
 * 头像
 */

public class HeadPortraitActivity extends AppCompatActivity {

    @InjectView(R.id.iv_head_portrait)
    ImageView iv_head_portrait;

    private PopupWindow popup;

    private String file_name = "";

    private HeadPortrait_Model model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_portrait);
        ButterKnife.inject(this);

        model = new HeadPortrait_Model(this);

        initPopupwindow();

        Picasso.with(this)
                .load("http://img4.imgtn.bdimg.com/it/u=3929251423,454148251&fm=27&gp=0.jpg")
                .transform(new CircleTransform())
                .error(R.drawable.default_binner_pic)
                .placeholder(R.mipmap.ic_launcher)
                .into(iv_head_portrait);

        iv_head_portrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup.showAtLocation(getWindow().getDecorView(),Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 0.5f;
                getWindow().setAttributes(lp);
            }
        });

    }

    private void initPopupwindow() {
        popup = new PopupWindow(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.popupwindow_choose,null);
        popup.setContentView(v);
        popup.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popup.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popup.setOutsideTouchable(false);
        popup.setBackgroundDrawable(null);
        popup.setAnimationStyle(R.style.popwindow_anim_style);
        View tv_take_photo = v.findViewById(R.id.tv_take_photo);
        View tv_pick_photo = v.findViewById(R.id.tv_pick_photo);
        View tv_cancle = v.findViewById(R.id.tv_cancle);

        file_name = getRandomName();

        tv_take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //判断是否有足够存储空间
//                if(isUsing()) {
                //设置存储位置
                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(new File(Environment.getExternalStorageDirectory(), file_name)));
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
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1.0f;
                getWindow().setAttributes(lp);
            }
        });
    }

    @OnClick({R.id.iv_head_portrait})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_head_portrait:
                popup.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        popup.dismiss();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 1.0f;
        getWindow().setAttributes(lp);

        if(requestCode == 0 || requestCode == 1){
            Uri uri = null;
            if(requestCode == 0){//相机
                //Environment.getExternalStorageDirectory() + file_name
                File tmpFile = new File(Environment.getExternalStorageDirectory(), file_name);
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
            startActivityForResult(intent, 2);//同样的在onActivityResult中处理剪裁好的图片
        }else if(requestCode == 2){
            Bundle extras = data.getExtras();
            if (extras != null) {
                Bitmap bitmap = extras.getParcelable("data");
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                model.uploadHeadPortrait(out.toByteArray());
            }
        }
    }

    public String getRandomName(){

        StringBuilder sb = new StringBuilder("");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        sb.append(sdf.format(new java.util.Date()));
        for(int i = 0;i<8;i++){
            sb.append(String.valueOf((int)(Math.random() * 10)));
        }
        return sb.toString();
    }
}
