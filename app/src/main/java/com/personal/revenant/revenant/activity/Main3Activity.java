package com.personal.revenant.revenant.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.personal.revenant.revenant.R;
import com.personal.revenant.revenant.base.BaseActivity;
import com.personal.revenant.revenant.base.BottomBarActivity;
import com.personal.revenant.revenant.bean.BaseBean.MessageEvent;
import com.personal.revenant.revenant.bean.BaseBean.MyEventCode;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main3Activity extends BaseActivity {
    @BindView(R.id.a)
    TextView a;
    @BindView(R.id.b)
    TextView b;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    @Override
    public int getContentViewResId() {
        return R.layout.activity_main3;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {
        refreshLayout.autoRefresh();
        refreshLayout.setEnableAutoLoadMore(true);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });
    }

    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

    protected void receiveStickyEvent(MessageEvent event) {
        super.receiveStickyEvent(event);
        switch (event.getCode()) {
            case MyEventCode.CODE_B:
                if (event.getData().toString().equals("MomentPublish")) {
                    LogUtils.d("数据是" + "55555555555555555");
                    a.setText("3333333333333333");
                }
                break;
            default:
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.a, R.id.b})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.a:
                startActivity(Main4Activity.class);
                break;
            case R.id.b:
                startActivity(BottomBarActivity.class);
                break;
        }
    }
}
