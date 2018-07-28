package com.utte.main.home.activity;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.utte.common.base.BaseActivity;
import com.utte.main.R;

public class LoginActivity extends BaseActivity {

    private RelativeLayout mBtLoginId;
    private RelativeLayout mBtLoginWechat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mBtLoginId = findViewById(R.id.bt_login_id);
        mBtLoginWechat = findViewById(R.id.bt_login_wechat);

    }
}
