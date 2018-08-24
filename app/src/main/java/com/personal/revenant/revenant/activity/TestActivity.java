package com.personal.revenant.revenant.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RelativeLayout;

import com.personal.revenant.revenant.R;
import com.personal.revenant.revenant.base.BaseActivity;
import com.personal.revenant.revenant.fragment.Blank1Fragment;
import com.personal.revenant.revenant.fragment.Blank2Fragment;
import com.personal.revenant.revenant.fragment.Blank3Fragment;
import com.personal.revenant.revenant.fragment.BlankFragment;
import com.yinglan.alphatabs.AlphaTabsIndicator;
import com.yinglan.alphatabs.OnTabChangedListner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends BaseActivity {


    @BindView(R.id.fragment_container)
    RelativeLayout fragmentContainer;
    @BindView(R.id.alphaIndicator)
    AlphaTabsIndicator alphaIndicator;
    private static final String FRAGMENT_TAG_HOME = "home";
    private static final String FRAGMENT_TAG_TASK = "task";
    private static final String FRAGMENT_TAG_PUBLISH = "publish";
    private static final String FRAGMENT_TAG_MY = "my";
    private static final String[] fragmentTags = new String[]{FRAGMENT_TAG_HOME, FRAGMENT_TAG_TASK,
            FRAGMENT_TAG_PUBLISH, FRAGMENT_TAG_MY};

    private BlankFragment homeFragment;
    private Blank1Fragment taskFragment;
    private Blank2Fragment publishFragment;
    private Blank3Fragment myFragment;
    @Override
    public int getContentViewResId() {
        return R.layout.activity_test;
    }

    @Override
    public void initView() {
        alphaIndicator.setOnTabChangedListner(new OnTabChangedListner() {
            @Override
            public void onTabSelected(int tabNum) {
                onTabSelect(tabNum);
            }
        });

        alphaIndicator.setTabCurrenItem(0);
    }

    @Override
    protected boolean isshowtitlebar() {
        return false;
    }

    @Override
    public void initData() {

    }
    public void onTabSelect(int position) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hideFragments(manager, transaction);

        if (0 == position) {
            if (homeFragment == null) {
                homeFragment = new BlankFragment();
                transaction.add(R.id.fragment_container, homeFragment, FRAGMENT_TAG_HOME);
            }
            transaction.show(homeFragment);
        } else if (1 == position) {
            if (taskFragment == null) {
                taskFragment = new Blank1Fragment();
                transaction.add(R.id.fragment_container, taskFragment, FRAGMENT_TAG_TASK);
            }
            transaction.show(taskFragment);
        } else if (2 == position) {
            if (publishFragment == null) {
                publishFragment = new Blank2Fragment();
                transaction.add(R.id.fragment_container, publishFragment, FRAGMENT_TAG_PUBLISH);
            }
            transaction.show(publishFragment);
        } else if (3 == position) {
            if (myFragment == null) {
                myFragment = new Blank3Fragment();
                transaction.add(R.id.fragment_container, myFragment, FRAGMENT_TAG_MY);
            }
            transaction.show(myFragment);
        }

        transaction.commit();
    }

    private void hideFragments(FragmentManager fragmentManager,
                               FragmentTransaction transaction) {
        for (int i = 0; i < fragmentTags.length; i++) {
            Fragment fragment = fragmentManager.findFragmentByTag(fragmentTags[i]);
            if (fragment != null && fragment.isVisible()) {
                transaction.hide(fragment);
            }
        }
    }


    @Override
    public void onBackPressed() {
        doubleExit();
    }

    private long exitTime = 0;

    public void doubleExit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
//            To.showShortToast("再按一次退出程序");
            exitTime = System.currentTimeMillis();
        } else {
//            AppManager.getAppManager().finishAllActivityAndExit(mContext);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
