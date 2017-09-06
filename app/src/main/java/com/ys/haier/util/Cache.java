package com.ys.haier.util;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by lzc on 2017-08-25.
 */

public class Cache {

    private LruCache<String,Bitmap> mMemoryCache;

    //初始化LruCache
    public void initCache(){
        int maxMemory = (int) (Runtime.getRuntime().maxMemory()/1024);
        int cacheSize = maxMemory/8;
        mMemoryCache = new LruCache<String,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
    }

    /**
     * Fun : 把图片存到缓存中
     * 2017/08/25
     * LZC
     * @param url
     * @param bitmap
     */
    public void putBitmap(String url,Bitmap bitmap){
        if (getBitmap(url) == null){

            mMemoryCache.put(url,bitmap);
        }
    }

    /**
     * Fun : 从缓存中取出Bitmap
     * 2017/08/25
     * LZC
     * @param url
     * @return
     */
    public Bitmap getBitmap(String url){
        Bitmap bitmap = mMemoryCache.get("url");
        return bitmap;
    }

}
