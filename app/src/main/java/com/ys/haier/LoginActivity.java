package com.ys.haier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.ys.haier.model.Login_Model;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @InjectView(R.id.login_name)
    EditText loginName;
    @InjectView(R.id.login_pwd)
    EditText loginPwd;
    @InjectView(R.id.login)
    Button login;
    @InjectView(R.id.tv_forgotPwd)
    TextView tvForgotPwd;
    @InjectView(R.id.tv_register)
    TextView tvRegister;
    private Login_Model loginModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.login, R.id.tv_forgotPwd, R.id.tv_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login:
                loginModel =null;
                loginModel = new Login_Model(LoginActivity.this, loginName.getText().toString(), loginPwd.getText().toString());
                loginModel.login();
                break;
            case R.id.tv_forgotPwd:
                startActivity(new Intent(LoginActivity.this, ForgetPwdActivity.class));
                break;
            case R.id.tv_register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       loginModel =null;
    }
}
