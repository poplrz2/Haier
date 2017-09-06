package com.ys.haier;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ys.haier.interfaces.CountDownTimerListener;
import com.ys.haier.listener.MyCountDownTimer;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ForgetPwdActivity extends AppCompatActivity implements CountDownTimerListener{

    @InjectView(R.id.et_forget_phone)
    EditText etForgetPhone;
    @InjectView(R.id.et_forget_code)
    EditText etForgetCode;
    @InjectView(R.id.btn_forget_getCode)
    Button btnForgetGetCode;
    @InjectView(R.id.et_forget_pwd)
    EditText etForgetPwd;
    @InjectView(R.id.et_forget_pwd_ok)
    EditText etForgetPwdOk;
    @InjectView(R.id.btn_forget_isRegister)
    Button btnForgetIsRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.btn_forget_getCode, R.id.btn_forget_isRegister})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_forget_getCode:
                new MyCountDownTimer(60*1000,1000,this).start();
                btnForgetGetCode.setEnabled(false);
                break;
            case R.id.btn_forget_isRegister:
                //
                break;
        }
    }

    @Override
    public void CountDownTimerFinish() {
        btnForgetGetCode.setText("重新获取");
        btnForgetGetCode.setEnabled(true);
    }

    @Override
    public void onTick(long l) {
        btnForgetGetCode.setText(l/1000+"s");

    }
}
