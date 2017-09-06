package com.ys.haier.util;

import android.app.Activity;

import com.androidadvance.topsnackbar.TSnackbar;
import com.ys.haier.R;

/**
 * Created by wz on 2017-08-08.
 */

public class SnackbarUtil {
    private static TSnackbar snackbar;
    public static void show(Activity context, String msg) {
        snackbar = TSnackbar.make(context.findViewById(android.R.id.content), msg, TSnackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(context.getResources().getColor(R.color.default_color));
        snackbar.show();
}
    public static void showFail(Activity context, String msg) {
        snackbar = TSnackbar.make(context.findViewById(android.R.id.content), msg, TSnackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(context.getResources().getColor(android.R.color.holo_red_dark));
        snackbar.show();

    }
}
