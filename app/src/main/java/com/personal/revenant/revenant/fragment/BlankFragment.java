package com.personal.revenant.revenant.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
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
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends BaseFragment {
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
    protected boolean isRegisterEventBus() {
        return true;
    }

    protected void receiveStickyEvent(MessageEvent event) {
        super.receiveStickyEvent(event);
        switch (event.getCode()) {
            case MyEventCode.CODE_B:
                if (event.getData().toString().equals("aaa")) {
                    LogUtils.d("数据是"+ "55555555555555555");
                    ab.setText("3333333333333333");
                }
                break;
            default:
        }
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

    public static BlankFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        BlankFragment fragment = new BlankFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
