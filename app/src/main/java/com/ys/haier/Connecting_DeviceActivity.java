package com.ys.haier;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ys.haier.interfaces.Custom_ArrowListener;
import com.ys.haier.views.Custom_ActionBar;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Connecting_DeviceActivity extends AppCompatActivity implements Custom_ArrowListener {

    @InjectView(R.id.cab)
    Custom_ActionBar cab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connecting__device);
        ButterKnife.inject(this);
        cab.setarrow_click(this);
    }


    @Override
    public void Arrow_click(View view) {
        finish();
    }
}
