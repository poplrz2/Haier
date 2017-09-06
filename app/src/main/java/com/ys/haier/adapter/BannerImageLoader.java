package com.ys.haier.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.youth.banner.loader.ImageLoader;
import com.ys.haier.R;

/**
 * Created by wz on 2017-08-09.
 */

public class BannerImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        Picasso.with(context)
                .load(path.toString())
                .placeholder(R.drawable.default_binner_pic)
                .placeholder(R.drawable.default_binner_pic)
                .into(imageView);
    }
}
