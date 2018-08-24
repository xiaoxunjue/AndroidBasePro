package com.personal.revenant.revenant.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.github.nukc.stateview.StateView;
import com.personal.revenant.revenant.R;
import com.personal.revenant.revenant.base.BaseFragment;
import com.personal.revenant.revenant.bean.BaseBean.MessageEvent;
import com.personal.revenant.revenant.bean.BaseBean.MyEventCode;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Blank3Fragment extends BaseFragment {
    @BindView(R.id.loadLayout)
    LinearLayout loadLayout;
    Unbinder unbinder;
    @BindView(R.id.ab)
    TextView ab;
    public static final String BUNDLE_TITLE = "title";
    @Override
    protected int setLayoutId() {
        return R.layout.fragment_blank;
    }

    @Override
    protected void initView() {

        mStateView = StateView.inject(loadLayout);
        mStateView.showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mStateView.showContent();
            }
        }, 2000);
    }


    @Override
    public void initData() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public static Blank3Fragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        Blank3Fragment fragment = new Blank3Fragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
