package com.ys.haier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.ys.haier.interfaces.Custom_ArrowListener;
import com.ys.haier.interfaces.Custom_Right_TextListener;
import com.ys.haier.model.Perfect_UserInfo_Model;
import com.ys.haier.views.Custom_ActionBar;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class PerfectUserInfoActivity extends AppCompatActivity implements Custom_ArrowListener, Custom_Right_TextListener {


    @InjectView(R.id.cab)
    Custom_ActionBar cab;
    @InjectView(R.id.perfect_name)
    EditText etperfectName;
    @InjectView(R.id.tv_perfect_birthday)
    TextView tvPerfectBirthday;
    @InjectView(R.id.et_perfect_address)
    EditText etPerfectAddress;
    @InjectView(R.id.et_perfect_height)
    EditText etPerfectHeight;
    @InjectView(R.id.et_perfect_weight)
    EditText etPerfectWeight;
    @InjectView(R.id.et_perfect_family_history)
    EditText etPerfectFamilyHistory;
    @InjectView(R.id.et_family_name)
    EditText etFamilyName;
    @InjectView(R.id.et_relationship)
    EditText etRelationship;
    @InjectView(R.id.et_contact_number)
    EditText etContactNumber;
    @InjectView(R.id.btn_perfect_done)
    Button btnPerfectDone;
    @InjectView(R.id.tv_perfect_sex)
    TextView tvPerfectSex;
    @InjectView(R.id.tv_perfect_provinces)
    TextView tvPerfectProvinces;
    @InjectView(R.id.tv_perfect_cities)
    TextView tvPerfectCities;
    @InjectView(R.id.et_perfect_user_phone)
    EditText etPerfectUserPhone;

    private Perfect_UserInfo_Model perfect_userInfo_model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfect_user_info);
        ButterKnife.inject(this);
        cab.setarrow_click(this);
        cab.setRightText_Click(this);
        init();
    }

    private void init() {
        Intent it = getIntent();
        int id = it.getIntExtra("userid", -1);
        perfect_userInfo_model = new Perfect_UserInfo_Model(this,
                id,
                tvPerfectBirthday,
                tvPerfectSex,
                etPerfectUserPhone,
                tvPerfectProvinces,
                tvPerfectCities,
                etperfectName,
                etPerfectAddress,
                etPerfectHeight,
                etPerfectWeight,
                etPerfectFamilyHistory,
                etFamilyName,
                etRelationship,
                etContactNumber
        );


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        perfect_userInfo_model = null;
    }
    @OnClick({R.id.tv_perfect_sex, R.id.tv_perfect_birthday, R.id.tv_perfect_provinces, R.id.tv_perfect_cities, R.id.btn_perfect_done})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_perfect_sex:
                perfect_userInfo_model.select_Sex();
                break;
            case R.id.tv_perfect_birthday:
                perfect_userInfo_model.select_Date();
                break;

            case R.id.tv_perfect_provinces:
                perfect_userInfo_model.select_Provinces();
                break;
            case R.id.tv_perfect_cities:
                perfect_userInfo_model.select_Cities();

                break;
            case R.id.btn_perfect_done:
                perfect_userInfo_model.perfectRegister();
                break;
        }
    }

    @Override
    public void Arrow_click(View view) {
        finish();
    }
    @Override
    public void Right_Text_click(View view) {
        startActivity(new Intent(PerfectUserInfoActivity.this,MainActivity.class));
    }
}
