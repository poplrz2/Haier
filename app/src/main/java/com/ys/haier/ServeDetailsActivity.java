package com.ys.haier;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ys.haier.model.ServeDetails_Guanzhu_Model;
import com.ys.haier.model.ServeDetails_Tuijian_Model;
import com.ys.haier.util.CircleTransform;
import com.ys.haier.util.CollapsibleTextView;
import com.ys.haier.util.SPUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by lzc on 2017-08-27.
 */

public class ServeDetailsActivity extends Activity {

    @InjectView(R.id.back_arrow)
    ImageView backArrow;
    @InjectView(R.id.serve_Icon)
    ImageView serveIcon;
    @InjectView(R.id.serve_Title)
    TextView serveTitle;

    @InjectView(R.id.serve_include_product)
    TextView serveIncludeProduct;
    @InjectView(R.id.serve_details_tuijian_rcyl)
    RecyclerView serveDetailsTuiJianeRcyl;
    @InjectView(R.id.serve_detials_guanzhu_recyl)
    RecyclerView serveDetialsGuanzhuRecyl;
    @InjectView(R.id.serve_Name)
    CollapsibleTextView serveName;
    private SpannableString msp;

    private String fw_id;
    private String dl_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_serve_details);
        ButterKnife.inject(this);
        intView();
        init();
    }

    /**
     * Fun : 设置服务详情
     * LZC
     * 2017/08/29
     */
    private void intView() {
        Intent intent = getIntent();
        fw_id = intent.getStringExtra("fw_id");
        dl_id = new SPUtils(this).getStorageInt("userid") + "";
        String serveicon = MyApp.URL_SERVER + intent.getStringExtra("serveIcon");
        Picasso.with(this).load(serveicon).transform(new CircleTransform()).into(serveIcon);
        String servetitle = intent.getStringExtra("serveTitle");
        serveTitle.setText(servetitle);
        String servename = intent.getStringExtra("serveName");
        String introduction = "服务简介：" + servename;
        msp = setTextAppearance(this, introduction, R.style.textBoldStyle, 0, 4);
        msp.setSpan(new TextAppearanceSpan(this, R.style.textNormalStyle), 5, introduction.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        serveName.setText(msp, TextView.BufferType.SPANNABLE);
        String serveproducts = intent.getStringExtra("serveProducts");
        String include_product = "包含产品：" + serveproducts;
        msp = setTextAppearance(this, include_product, R.style.textBoldStyle, 0, 4);
        msp.setSpan(new TextAppearanceSpan(this, R.style.textNormalStyle), 5, include_product.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        serveIncludeProduct.setText(msp, TextView.BufferType.SPANNABLE);
    }

    /**
     * 设置部分字符串字体
     *
     * @param context 上下文
     * @param str     字符串
     * @param style   自定义的样式
     * @param start   起始位置
     * @param end     结束位置
     * @return
     */
    public SpannableString setTextAppearance(Context context, String str, int style, int start, int end) {
        SpannableString msp = new SpannableString(str);
        msp.setSpan(new TextAppearanceSpan(context, style), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return msp;
    }

    /**
     * Fun : 初始化点滴服务
     * 2017/08/27
     * LZC
     */
    private void init() {
        ServeDetails_Tuijian_Model serveDetails_Tuijian_model = new ServeDetails_Tuijian_Model(this, serveDetailsTuiJianeRcyl, fw_id, dl_id);
        serveDetails_Tuijian_model.initServeDetialsTuiJianRcy();
        ServeDetails_Guanzhu_Model serveDetails_GuanZhu_model = new ServeDetails_Guanzhu_Model(this, serveDetialsGuanzhuRecyl, fw_id, dl_id);
        serveDetails_GuanZhu_model.initServeGuanZhuRcy();
    }

    @OnClick({R.id.back_arrow})
    public void onClick(View view) {
        this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.finish();
    }

}
