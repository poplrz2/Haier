package com.ys.haier.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ys.haier.R;
import com.ys.haier.util.Pixel_Conversion_Util;

/**
 * Created by chen on 2017/9/6.
 */

public class RouteView extends View {

    private BitmapDrawable mDrawable;
    private int t = 0;
    private int w;
    private int h;

    public RouteView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        String width = attrs.getAttributeValue(0);
        String height = attrs.getAttributeValue(1);
        w = Pixel_Conversion_Util.DP2PX(context,(int)Float.parseFloat(width.substring(0,width.length()-3)));
        h = Pixel_Conversion_Util.DP2PX(context,(int)Float.parseFloat(height.substring(0,width.length()-3)));
        init();

    }

    private void init() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.loading);
        mDrawable = new BitmapDrawable(getResources(),bitmap);
        mDrawable.setBounds(0,0,w,h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        t = t+15;
        canvas.rotate(t,w/2,h/2);
        mDrawable.draw(canvas);
        invalidate();
    }
}
