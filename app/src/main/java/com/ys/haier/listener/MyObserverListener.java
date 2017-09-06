package com.ys.haier.listener;

import com.ys.haier.interfaces.ObserverListener;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by wz on 2017-08-08.
 */

public class MyObserverListener implements Observer<Object> {
    ObserverListener observerListener;
    int flag;
    public MyObserverListener(ObserverListener observerListener) {
        this.observerListener = observerListener;
        flag=-1;
    }

    public MyObserverListener(ObserverListener observerListener, int flag) {
        this.observerListener = observerListener;
        this.flag = flag;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull Object o) {
        observerListener.Success(o,flag);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        observerListener.onError(e);
    }

    @Override
    public void onComplete() {
        observerListener.onComplete();
    }
}
