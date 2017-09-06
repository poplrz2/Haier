package com.ys.haier;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.ys.haier.util.HtmlFormat;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by wz on 2017-08-18.
 */

public class NewsDetailsActivity extends Activity {

    @InjectView(R.id.back_arrow)
    ImageView backArrow;
    @InjectView(R.id.news_detials)
    WebView newsDetials;

    private String news_describle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.inject(this);

        WebViewSettings();

        news_describle = getIntent().getStringExtra("newsDescrible");
        Log.d("newsDescrible",news_describle);
        newsDetials.loadDataWithBaseURL(null, HtmlFormat.getNews(news_describle),"text/html","utf-8",null);
    }

    //WebView设置属性 2017/08/21 LZC
    private void WebViewSettings() {
        //WebView自动适配页面 2017/08/21 LZC
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int scale = dm.densityDpi;
        if(scale == 240){
            newsDetials.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        }else if (scale == 160){
            newsDetials.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        }else {
            newsDetials.getSettings().setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
        }
        //设置WebView的缩放功能点
        newsDetials.getSettings().setJavaScriptEnabled(true);
    }

    @OnClick({R.id.back_arrow,R.id.news_detials})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.back_arrow:
                this.finish();
                break;
        }
    }

    /**
     * 在 Activity 销毁（ WebView ）的时候，先让 WebView 加载null内容，
     * 然后移除 WebView，再销毁 WebView，最后置空。
     * 2017/08/21
     * LZC
     */
    @Override
    protected void onDestroy() {
        if (newsDetials != null){
            newsDetials.loadDataWithBaseURL("","","text/html","UTF-8",null);
            newsDetials.clearHistory();
            ((ViewGroup) newsDetials.getParent()).removeView(newsDetials);
            newsDetials = null;
            this.finish();
        }
        super.onDestroy();

    }
}
