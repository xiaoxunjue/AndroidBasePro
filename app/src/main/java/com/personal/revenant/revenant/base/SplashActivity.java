package com.personal.revenant.revenant.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.personal.revenant.revenant.R;
import com.personal.revenant.revenant.activity.Main3Activity;

public class SplashActivity extends BaseActivity {

    @Override
    public int getContentViewResId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {

    }

    @Override
    protected boolean isshowtitlebar() {
        return false;
    }

    @Override
    public void initData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(Main3Activity.class);
                finish();
            }
        }, 2000);
    }
}
