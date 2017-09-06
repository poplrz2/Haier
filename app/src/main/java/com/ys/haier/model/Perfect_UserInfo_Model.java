package com.ys.haier.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.ys.haier.MainActivity;
import com.ys.haier.data.City;
import com.ys.haier.data.Provinces;
import com.ys.haier.interfaces.ObserverListener;
import com.ys.haier.interfaces.PickerView_OptionsSelectListener;
import com.ys.haier.listener.MyOnOptionsSelectListener;
import com.ys.haier.util.HttpUtil;
import com.ys.haier.util.SnackbarUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wz on 2017-08-10.
 */

public class Perfect_UserInfo_Model implements TimePickerView.OnTimeSelectListener, ObserverListener, PickerView_OptionsSelectListener {
    Activity context;
    TextView tvPerfectBirthday;
    TextView tvPerfectSex;
    TextView tvPerfectProvinces;
    TextView tvPerfectsCities;
    EditText etperfectName;
    EditText etPerfectAddress;
    EditText etPerfectHeight;
    EditText etPerfectWeight;
    EditText etPerfectFamilyHistory;
    EditText etFamilyName;
    EditText etRelationship;
    EditText etContactNumber;
    EditText etPerfectUserPhone;
    private List<String> list;
    private List<Provinces.RowsBean> rowsBeanList;
    private List<City.RowsBean> rowsBeanList_city;
    String provinces_id = "1";
    int user_id;
    //Map<String, String> map;
    JSONObject jsonObject;
    private OptionsPickerView rowsBeanOptionsPickerView_Provinces, rowsBeanOptionsPickerView_city;


    public Perfect_UserInfo_Model(Activity context,
                                  int user_id,
                                  TextView tvPerfectBirthday, TextView tvPerfectSex,
                                  EditText etPerfectUserPhone,
                                  TextView tvPerfectProvinces, TextView tvPerfectsCities,
                                  EditText etperfectName, EditText etPerfectAddress,
                                  EditText etPerfectHeight, EditText etPerfectWeight,
                                  EditText etPerfectFamilyHistory, EditText etFamilyName,
                                  EditText etRelationship, EditText etContactNumber) {
        this.user_id = user_id;
        this.context = context;
        this.tvPerfectBirthday = tvPerfectBirthday;
        this.tvPerfectSex = tvPerfectSex;
        this.etPerfectUserPhone = etPerfectUserPhone;
        this.tvPerfectProvinces = tvPerfectProvinces;
        this.tvPerfectsCities = tvPerfectsCities;
        this.etperfectName = etperfectName;
        this.etPerfectAddress = etPerfectAddress;
        this.etPerfectHeight = etPerfectHeight;
        this.etPerfectWeight = etPerfectWeight;
        this.etPerfectFamilyHistory = etPerfectFamilyHistory;
        this.etFamilyName = etFamilyName;
        this.etRelationship = etRelationship;
        this.etContactNumber = etContactNumber;
        new HttpUtil().getProvinces(this);


    }

    public void select_Date() {
        hintKbTwo();
        GregorianCalendar startDate = new GregorianCalendar();
        GregorianCalendar endDate = new GregorianCalendar();
        GregorianCalendar setDate = new GregorianCalendar();
        setDate.set(1980, 0, 1);
        startDate.set(1900, 0, 1);
        TimePickerView timePickerView = new TimePickerView
                .Builder(context, this)
                .setType(new boolean[]{true, true, true, false, false, false})
                .setRangDate(startDate, endDate)
                .setDate(setDate)
                .build();
        timePickerView.show();

    }

    public void perfectRegister() {
        String name = etperfectName.getText().toString();
        String sex = tvPerfectSex.getText().toString();
        String birthday = tvPerfectBirthday.getText().toString();
        String phone = etPerfectUserPhone.getText().toString();
        StringBuilder address = new StringBuilder();
        address.append(tvPerfectProvinces.getText().toString());
        address.append(tvPerfectsCities.getText().toString());
        address.append(etPerfectAddress.getText().toString());
        String height = etPerfectHeight.getText().toString();
        String weight = etPerfectWeight.getText().toString();
        String Medical_History = etPerfectFamilyHistory.getText().toString();
        String familyName = etFamilyName.getText().toString();
        String relationship = etRelationship.getText().toString();
        String contactNumber = etContactNumber.getText().toString();
        if ("".equals(name)) {
            SnackbarUtil.showFail(context, "请输入姓名");
        } else if ("".equals(sex)) {
            SnackbarUtil.showFail(context, "请选择性别");
        } else if ("".equals(birthday)) {
            SnackbarUtil.showFail(context, "请选择出生年月");
        } else if ("".equals(phone)) {
            SnackbarUtil.showFail(context, "请输入电话号码");

        } else if ("".equals(height)) {
            SnackbarUtil.showFail(context, "请输入身高");

        } else if ("".equals(weight)) {
            SnackbarUtil.showFail(context, "请输入体重");

        } else if ("".equals(Medical_History)) {
            SnackbarUtil.showFail(context, "请填写是否有家族遗传病史");
        } else if ("".equals(familyName)) {
            SnackbarUtil.showFail(context, "请输入家属姓名");
        } else if ("".equals(relationship)) {
            SnackbarUtil.showFail(context, "请输入和你本人的关系");
        } else if ("".equals(contactNumber)) {
            SnackbarUtil.showFail(context, "请输入他/她的联系方式");
        } else {
            jsonObject = new JSONObject();
            try {
                jsonObject.put("User_Name", name);
                jsonObject.put("User_Sex", sex.equals("男") ? 0 : 1);
                jsonObject.put("User_Birthday", birthday);
                jsonObject.put("User_Phone", phone);
                jsonObject.put("User_Height", height);
                jsonObject.put("User_Weight", weight);
                jsonObject.put("User_Address", address.toString());
                jsonObject.put("User_YCBS", Medical_History);
                jsonObject.put("User_Guardian", familyName);
                jsonObject.put("User_Relation", relationship);
                jsonObject.put("User_GuardianPhone", contactNumber);
                jsonObject.put("ID", user_id + "");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            startRegister(jsonObject);

        }

    }

    private void startRegister(JSONObject jsonObject) {
        new HttpUtil().getPerfect_Register(jsonObject, this);
    }

    public void select_Sex() {

        list = null;
        list = new ArrayList<>();
        list.add("男");
        list.add("女");
        OptionsPickerView<String> optionsPickerView = new OptionsPickerView.Builder(context, new MyOnOptionsSelectListener(this, 0)).build();
        optionsPickerView.setPicker(list);
        hintKbTwo();
        optionsPickerView.show();

    }

    @Override
    public void onTimeSelect(Date date, View v) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder();
        sb.append(gregorianCalendar.get(GregorianCalendar.YEAR));
        sb.append("-");
        sb.append(gregorianCalendar.get(GregorianCalendar.MONTH) + 1);
        sb.append("-");
        sb.append(gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH));
        //sb.append("日");
        tvPerfectBirthday.setText(sb);
    }


    public void select_Provinces() {
        hintKbTwo();
        rowsBeanOptionsPickerView_Provinces.show();
    }

    @Override
    public void onError(Throwable e) {
        Logger.i(e.getMessage());
    }

    /*
      flag  0省份请求 1 城市请求 2 注册请求
     */
    @Override
    public void Success(Object object, int flag) {
        if (flag == 0) {
            Logger.i(object.toString());
            Provinces provinces = new Gson().fromJson(object.toString(), Provinces.class);
            if (provinces.isSuccess()) {
                rowsBeanList = provinces.getRows();
                setProvincesData(rowsBeanList);
            }
        } else if (flag == 1) {
            Logger.i(object.toString());
            City city = new Gson().fromJson(object.toString(), City.class);
            if (city.isSuccess()) {
                rowsBeanList_city = city.getRows();
                setCityData(rowsBeanList_city);
            }
        } else if (flag == 2) {
            Logger.i(object.toString());
            try {
                JSONObject jsonObject=new JSONObject(object.toString());
              boolean b=  jsonObject.getBoolean("success");
                if(b){
                    SnackbarUtil.show(context,jsonObject.getString("message"));
                    context.startActivity(new Intent(context, MainActivity.class));
                    context.finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    private void setCityData(List<City.RowsBean> rowsBeanList_city) {
        list = null;
        list = new ArrayList<>();
        for (City.RowsBean r : rowsBeanList_city
                ) {
            list.add(r.getShi_Name());
        }
        rowsBeanOptionsPickerView_city = new OptionsPickerView.Builder(context, new MyOnOptionsSelectListener(this, 2)).build();
        rowsBeanOptionsPickerView_city.setPicker(list);
        tvPerfectsCities.setText(list.get(0));

    }

    @Override
    public void onComplete() {

    }

    public void setProvincesData(List<Provinces.RowsBean> rowsBeanList) {
        list = null;
        list = new ArrayList<>();
        for (Provinces.RowsBean r : rowsBeanList
                ) {
            list.add(r.getSheng_Name());
        }
        rowsBeanOptionsPickerView_Provinces = new OptionsPickerView.Builder(context, new MyOnOptionsSelectListener(this, 1)).build();
        rowsBeanOptionsPickerView_Provinces.setPicker(list);
        tvPerfectProvinces.setText(list.get(0));
        new HttpUtil().getCity(provinces_id, this);

    }

    /*
         flag   0 性别选择 1 省份选择 2 城市选择
            */
    @Override
    public void onOptionsSelect(int options1, int options2, int options3, View v, int flag) {

        if (flag == 0) {
            tvPerfectSex.setText(list.get(options1));
        } else if (flag == 1) {
            String provinces = rowsBeanList.get(options1).getSheng_Name();
            provinces_id = rowsBeanList.get(options1).getID() + "";
            tvPerfectProvinces.setText(provinces);
        } else if (flag == 2) {
            String city = rowsBeanList_city.get(options1).getShi_Name();
            tvPerfectsCities.setText(city);
        }
    }

    public void select_Cities() {
        hintKbTwo();
        rowsBeanOptionsPickerView_city.show();
    }

    //此方法只是关闭软键盘
    private void hintKbTwo() {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive() && context.getCurrentFocus() != null) {
            if (context.getCurrentFocus().getWindowToken() != null) {
                imm.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }
}
