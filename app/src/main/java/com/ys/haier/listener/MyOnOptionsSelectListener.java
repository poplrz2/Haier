package com.ys.haier.listener;

import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.ys.haier.interfaces.PickerView_OptionsSelectListener;

/**
 * Created by wz on 2017-08-10.
 */

public class MyOnOptionsSelectListener implements OptionsPickerView.OnOptionsSelectListener{
  PickerView_OptionsSelectListener pickerView_optionsSelectListener;
    int flag;

    public MyOnOptionsSelectListener(PickerView_OptionsSelectListener pickerView_optionsSelectListener, int flag) {
        this.pickerView_optionsSelectListener = pickerView_optionsSelectListener;
        this.flag = flag;
    }

    @Override
    public void onOptionsSelect(int options1, int options2, int options3, View v) {
        pickerView_optionsSelectListener.onOptionsSelect(options1,options2,options3,v,flag);
    }
}
