package com.personal.revenant.revenant.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.github.nukc.stateview.StateView;
import com.gyf.barlibrary.ImmersionBar;
import com.personal.revenant.revenant.R;
import com.personal.revenant.revenant.bean.BaseBean.MessageEvent;
import com.personal.revenant.revenant.utils.ActivityUtils;
import com.personal.revenant.revenant.utils.EventBusUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Field;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements StateView.OnRetryClickListener, View.OnClickListener {
    private final String TAG = this.getClass().getSimpleName();
    private ImmersionBar mImmersionBar;
    private ImageView leftBaseBar;
    private TextView centerBaseBarTitle;
    private TextView rightBaseBar;
    private View view;
    private LinearLayout linearLayoutbarshoworhide;
    private StateView networkStateView;
    public static BaseActivity mCurrentActivity = null;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(getContentViewResId());

        if (isImmersionBarEnabled()) {
            initImmersionBar();
        }

        LogUtils.d(TAG, "onCreate()");
        mUnbinder = ButterKnife.bind(this);
        ActivityUtils.addActivity(this);
        initView();
        initData();
        if (isRegisterEventBus()) {
            LogUtils.d("EBBaseActivity", "register");
            EventBusUtil.register(this);
        }
    }


    protected boolean isImmersionBarEnabled() {
        return true;
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        int height = getStatusBarHeight(BaseActivity.this);
        LogUtils.d("高度是:" + height);
        view = getLayoutInflater().inflate(R.layout.activity_base, null);

        linearLayoutbarshoworhide = view.findViewById(R.id.basetitle_show_or_hide);

//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(linearLayoutbarshoworhide.getLayoutParams());
//        lp.setMargins(0, height, 0, 0);
//        linearLayoutbarshoworhide.setLayoutParams(lp);

        leftBaseBar = view.findViewById(R.id.left_base_bar);
        centerBaseBarTitle = view.findViewById(R.id.center_base_bar_title);
        rightBaseBar = view.findViewById(R.id.right_base_bar);

        if (!isshowtitlebar()) {
            linearLayoutbarshoworhide.setVisibility(View.GONE);
        }
        leftBaseBar.setOnClickListener(this);
        rightBaseBar.setOnClickListener(this);

        //设置填充activity_base布局
        super.setContentView(view);

        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            view.setFitsSystemWindows(true);
        }

        //加载子类Activity的布局
        initDefaultView(layoutResID);
    }

    /*
    * 初始化布局
    * */
    public abstract int getContentViewResId();

    /*
    * 设置布局
    * */
    public abstract void initView();

    /**
     * 设置数据
     */
    public abstract void initData();

    /*
    * 标题栏的点击事件
    * */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.right_base_bar:
                rightbarclick();
                break;
            case R.id.left_base_bar:
                leftbarclick();
                break;
            default:
        }

    }


    public void leftbarclick() {

    }

    public void rightbarclick() {

    }

    protected boolean isshowtitlebar() {
        return true;
    }

    public void setcenterTitle(String title) {
        centerBaseBarTitle.setText(title);
    }

    public void setrightTitle(String title) {
        rightBaseBar.setText(title);
    }

    public void showright(boolean showrightbar) {
        if (showrightbar == true) {
            rightBaseBar.setVisibility(View.VISIBLE);
        } else {
            rightBaseBar.setVisibility(View.GONE);
        }
    }

    private void initDefaultView(int layoutResID) {
        networkStateView = (StateView) findViewById(R.id.stateview);
        FrameLayout container = (FrameLayout) findViewById(R.id.fl_activity_child_container);
        View childView = LayoutInflater.from(this).inflate(layoutResID, null);
        container.addView(childView, 0);
    }

    /*diaglog
    * */
/*
* 操作状态栏
* */


    protected void initImmersionBar() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.
//                 transparentStatusBar().
//                transparentBar()
        statusBarColor(R.color.o2oman).
//                transparentBar().
//        titleBar(linearLayoutbarshoworhide).
        init();
        LogUtils.d("高度数据是");
    }

    public void showLoadingView() {
        networkStateView.showLoading();
    }

    public void showErrorView() {
        networkStateView.showRetry();
        networkStateView.setOnRetryClickListener(this);
    }

    public void showEmptyView() {
        networkStateView.showEmpty();
        networkStateView.setOnRetryClickListener(this);
    }

    public void showContentView() {
        networkStateView.showContent();
    }

    /*
     * 再次点击的显示
     * */
    @Override
    public void onRetryClick() {
        onNetworkViewRefresh();
    }

    public void onNetworkViewRefresh() {
    }


    /*Eventbus的使用*/
    protected boolean isRegisterEventBus() {
        return false;
    }

    /**
     * [页面跳转]
     *
     * @param clz
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(BaseActivity.this, clz));
    }

    /**
     * [携带数据的页面跳转]
     *
     * @param clz
     * @param bundle
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * [含有Bundle通过Class打开编辑界面]
     *
     * @param cls
     * @param bundle
     * @param requestCode
     */
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mCurrentActivity = this;
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        if (isRegisterEventBus()) {
            EventBusUtil.unregister(this);
        }
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
        mUnbinder.unbind();
        ActivityUtils.removeActivity(this);
    }

    protected void exitall() {
        ActivityUtils.removeAllActivity();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(MessageEvent event) {
        if (event != null) {
            receiveEvent(event);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBusCome(MessageEvent event) {
        if (event != null) {
            receiveStickyEvent(event);
        }
    }

    /**
     * 接收到分发到事件
     *
     * @param event 事件
     */
    protected void receiveEvent(MessageEvent event) {

    }

    /**
     * 接受到分发的粘性事件
     *
     * @param event 粘性事件
     */
    protected void receiveStickyEvent(MessageEvent event) {

    }

    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


}
