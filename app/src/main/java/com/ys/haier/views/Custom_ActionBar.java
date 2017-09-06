package com.ys.haier.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ys.haier.R;
import com.ys.haier.interfaces.Custom_ArrowListener;
import com.ys.haier.interfaces.Custom_Right_TextListener;
import com.ys.haier.util.Pixel_Conversion_Util;

/**
 * Created by wz on 2017-08-10.
 */

public class Custom_ActionBar extends LinearLayout {
    Custom_ArrowListener custom_arrowListener;
    public static final int ARROW_ICO = 2333;
    public static final int RIGHT_TEXT = 6666;
    Custom_Right_TextListener custom_right_textListener;

    public Custom_ActionBar(Context context) {
        super(context, null, 0);
    }

    public Custom_ActionBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.custom_actionBar);
        String title = typedArray.getString(R.styleable.custom_actionBar_title);
        int height = (int) typedArray.getDimension(R.styleable.custom_actionBar_height, Pixel_Conversion_Util.DP2PX(context, 40));
        int color = typedArray.getColor(R.styleable.custom_actionBar_background_color, context.getResources().getColor(R.color.default_color));
        boolean b = typedArray.getBoolean(R.styleable.custom_actionBar_right_text, false);
        setOrientation(LinearLayout.HORIZONTAL);
        LayoutParams layoutParams = new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height);
        setBackgroundColor(color);
        setLayoutParams(layoutParams);

        ImageView imageView = new ImageView(context);

        LayoutParams iv_layoutParams = new LayoutParams(40, height);
        iv_layoutParams.leftMargin = Pixel_Conversion_Util.DP2PX(context, 16);
        iv_layoutParams.gravity = Gravity.CENTER;
        imageView.setLayoutParams(iv_layoutParams);


        imageView.setImageResource(R.drawable.arrow);
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                custom_arrowListener.Arrow_click(view);
            }
        });

        TextView textView = new TextView(context);

        LayoutParams tv_layoutParams = new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height);
        tv_layoutParams.rightMargin = Pixel_Conversion_Util.DP2PX(context, 16);
        tv_layoutParams.weight = 1;
        tv_layoutParams.gravity = Gravity.CENTER;
        textView.setLayoutParams(tv_layoutParams);

        textView.setTextColor(context.getResources().getColor(android.R.color.white));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        textView.setText(title);
        textView.setGravity(Gravity.CENTER);

        TextView textView1 = new TextView(context);

        LayoutParams tv1_layoutParams = new LayoutParams(80, height);
        tv1_layoutParams.rightMargin = Pixel_Conversion_Util.DP2PX(context, 16);
        tv1_layoutParams.gravity = Gravity.CENTER;
        textView1.setLayoutParams(tv1_layoutParams);

        textView1.setTextColor(context.getResources().getColor(android.R.color.white));
        textView1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        textView1.setText("跳过");
        textView1.setGravity(Gravity.CENTER);

        addView(imageView);
        addView(textView);
        if (b) {
            textView1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    custom_right_textListener.Right_Text_click(view);
                }
            });
            addView(textView1);
        }
    }

    public Custom_ActionBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setarrow_click(Custom_ArrowListener custom_arrowListener) {
        this.custom_arrowListener = custom_arrowListener;

    }

    public void setRightText_Click(Custom_Right_TextListener custom_right_textListener) {
        this.custom_right_textListener = custom_right_textListener;

    }
}
