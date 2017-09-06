package com.ys.haier;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ys.haier.interfaces.CountDownTimerListener;
import com.ys.haier.interfaces.VerificationServer;
import com.ys.haier.listener.MyCountDownTimer;
import com.ys.haier.model.User_Register_Model;
import com.ys.haier.util.CommonUtils;
import com.ys.haier.util.SPUtils;
import com.ys.haier.util.TelNumMatch;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity implements CountDownTimerListener {

    @InjectView(R.id.btn_getCode)
    Button btnGetCode;
    @InjectView(R.id.btn_isRegister)
    Button btnIsRegister;
    @InjectView(R.id.btn_back)
    Button btnBack;

    @InjectView(R.id.et_username)
    EditText etUsername;
    @InjectView(R.id.et_phone)
    EditText etPhone;
    @InjectView(R.id.et_vercode)
    EditText etVerCode;
    @InjectView(R.id.et_pwd)
    EditText etPwd;
    @InjectView(R.id.et_pwd_ok)
    EditText etPwdOk;
    User_Register_Model user_registerModel;

    private String name;
    private String phone;
    private String vercode;
    private String pwd;
    private String pwdok;


    private Retrofit retrofit;
    private VerificationServer verificationServer;

    public String TempVerCode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.inject(this);

        retrofit = new Retrofit.Builder().baseUrl("http://118.89.162.197:28001")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        verificationServer = retrofit.create(VerificationServer.class);
    }

    /**
     * Fun : 获取用户输入的信息
     * 2017/08/25
     * LZC
     */
    private void getEditData() {
        name = etUsername.getText().toString().trim();
        phone = etPhone.getText().toString().trim();
        vercode = etVerCode.getText().toString().trim();
        pwd = etPwd.getText().toString().trim();
        pwdok = etPwdOk.getText().toString().trim();
    }

    /**
     * Fun : 获取验证码，注册，返回三个监听事件
     * 2017/08/24
     * LZC
     * @param view
     */
    @OnClick({R.id.btn_getCode, R.id.btn_isRegister, R.id.btn_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_getCode:
                getVerCode();
                break;
            case R.id.btn_isRegister:
                user_registerModel = null;
                getEditData();
                user_registerModel = new User_Register_Model(RegisterActivity.this,
                        name,
                        phone,
                        vercode,
                        pwd,
                        pwdok
                );
                user_registerModel.register();
                break;
            case R.id.btn_back:
                RegisterActivity.this.finish();
                break;
        }
    }

    /**
     * Fun:获取验证码
     * 2017/08/25
     * LZC
     */
    private void getVerCode() {
            getEditData();
            int verCode = (int) ((Math.random() * 9 + 1) * 100000);
            TempVerCode = String.valueOf(verCode);//临时保存本地验证码
            new SPUtils(this).StorageString("vercode",TempVerCode);
            String userName = "heyl";
            String pwd = CommonUtils.md5sum("heyl0817");

            if ("".equals(name)){
                Toast.makeText(this, "请输入用户名！", Toast.LENGTH_SHORT).show();
            }else
                if ("".equals(phone)){
                Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            }else
                if (!TelNumMatch.isValidPhoneNumber(phone)){
                Toast.makeText(this, "手机号格式不正确，请重新输入！", Toast.LENGTH_SHORT).show();
            }else{
                    new MyCountDownTimer(60 * 1000, 1000, this).start();
                    btnGetCode.setEnabled(false);
                String message = "您申请的验证码是："+verCode+"，请输入后进行验证。";
                Call<String> sendSms = verificationServer.SendSms("SendSms", userName, pwd,phone, message,0+"");
                sendSms.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(RegisterActivity.this, "验证码发送成功！", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "验证码发送失败，请检查网络!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }

    @Override
    public void onTick(long l) {
        btnGetCode.setText(l / 1000 + "s");
    }

    @Override
    public void CountDownTimerFinish() {
        btnGetCode.setText("重新获取");
        btnGetCode.setEnabled(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        user_registerModel = null;
    }
}
