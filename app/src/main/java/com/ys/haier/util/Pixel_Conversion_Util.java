package com.ys.haier.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;

/**
 * Created by wz on 2017-08-10.
 */

public class Pixel_Conversion_Util {

   public static int DP2PX(Context context, int px){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,px,context.getResources().getDisplayMetrics());
    }
}
