package com.ys.haier.listener;

import android.os.CountDownTimer;

import com.ys.haier.interfaces.CountDownTimerListener;

/**
 * Created by wz on 2017-08-04.
 */

public class MyCountDownTimer extends CountDownTimer {
    CountDownTimerListener countDownTimer;
    public MyCountDownTimer(long millisInFuture, long countDownInterval,CountDownTimerListener countDownTimer) {
        super(millisInFuture, countDownInterval);
        this.countDownTimer=countDownTimer;
    }

    @Override
    public void onTick(long l) {
     countDownTimer.onTick(l);
    }

    @Override
    public void onFinish() {
        countDownTimer.CountDownTimerFinish();
    }
}
