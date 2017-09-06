package com.ys.haier.interfaces;

/**
 * Created by wz on 2017-08-08.
 */

public interface ObserverListener {
    void onError( Throwable e);
    void Success(Object object,int flag);
    void onComplete();
}
