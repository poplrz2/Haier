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
        init();
    }

    private void init() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.relationship);
        w = bitmap.getWidth();
        h = bitmap.getHeight();
        mDrawable = new BitmapDrawable(getResources(),bitmap);
        mDrawable.setBounds(0,0,bitmap.getWidth(),bitmap.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        t = t+5;
        canvas.rotate(t,w/2,h/2);
        mDrawable.draw(canvas);
        invalidate();
    }
}
