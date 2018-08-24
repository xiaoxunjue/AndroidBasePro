package com.personal.revenant.revenant.activity;


import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentTransaction;

import com.apkfuns.logutils.LogUtils;
import com.personal.revenant.revenant.R;
import com.personal.revenant.revenant.base.BaseActivity;
import com.personal.revenant.revenant.bean.BaseBean.MessageEvent;
import com.personal.revenant.revenant.bean.BaseBean.MyEventCode;
import com.personal.revenant.revenant.fragment.BlankFragment;
import com.personal.revenant.revenant.utils.EventBusUtil;

public class Main4Activity extends BaseActivity {

    @Override
    public int getContentViewResId() {
        return R.layout.activity_main4;
    }

    @Override
    protected boolean isshowtitlebar() {
        return false;
    }


    @Override
    public void initView() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        BlankFragment blankFragment = new BlankFragment();
        transaction.add(R.id.container_a, blankFragment);
        transaction.commit();
    }

    @Override
    public void initData() {

    }


}
