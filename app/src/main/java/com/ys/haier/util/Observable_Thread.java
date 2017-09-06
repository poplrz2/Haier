package com.ys.haier.util;

import com.ys.haier.interfaces.ObserverListener;
import com.ys.haier.listener.MyObserverListener;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wz on 2017-08-09.
 */

public class Observable_Thread implements ObservableTransformer {

    @Override
    public ObservableSource apply(@NonNull Observable upstream) {
        return upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
