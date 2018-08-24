package com.personal.revenant.revenant.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;
import com.personal.revenant.revenant.MainActivity;
import com.personal.revenant.revenant.R;
import com.personal.revenant.revenant.base.BaseActivity;
import com.personal.revenant.revenant.base.BottomBarActivity;
import com.personal.revenant.revenant.base.GuideActivity;
import com.personal.revenant.revenant.base.SplashActivity;
import com.personal.revenant.revenant.bean.BaseBean.MessageEvent;
import com.personal.revenant.revenant.bean.BaseBean.MyEventCode;
import com.personal.revenant.revenant.bean.GoodsDetails;
import com.personal.revenant.revenant.bean.NetApiUrl;
import com.personal.revenant.revenant.utils.EventBusUtil;
import com.personal.revenant.revenant.utils.GsonUtil;
import com.personal.revenant.revenant.utils.SPUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends BaseActivity {
    @BindView(R.id.a)
    TextView a;
    @BindView(R.id.b)
    TextView b;
    private Context context;

    @Override
    public int getContentViewResId() {
        context = this;
        return R.layout.activity_main2;
    }

    @Override
    public void initView() {
        setcenterTitle("firts");
        showright(true);
        setrightTitle("right");

    }

    @Override
    public void leftbarclick() {
        super.leftbarclick();
        showToast("1111");
    }

    @Override
    public void rightbarclick() {
        super.rightbarclick();
//        showLoadingView();
        showErrorView();

    }

    @Override
    public void onNetworkViewRefresh() {
        super.onNetworkViewRefresh();
        showToast("333333333333333");
        showContentView();
    }

    private void gethtml() {
        OkGo.<String>post(NetApiUrl.Test_URL)
                .params("goodsid", 13)
                .params("userid", 0)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        GoodsDetails s = GsonUtil.parseJsonWithGson(response.body(), GoodsDetails.class);
                        LogUtils.d("数据是:" + s.getMsg() + s.getGoods());
                    }
                });
    }

    @Override
    public void initData() {
        SPUtils.setUserId(context, 3);
        LogUtils.d("数据是" + SPUtils.getUserId(context));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        setPerssion();
    }

    @OnClick({R.id.a, R.id.b})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.a:
                EventBusUtil.sendStickyEvent(new MessageEvent(MyEventCode.CODE_B, "MomentPublish"));
                startActivity(Main3Activity.class);
                gethtml();
                break;
            case R.id.b:
                startActivity(Main4Activity.class);
                EventBusUtil.sendStickyEvent(new MessageEvent(MyEventCode.CODE_B, "aaa"));

                break;
        }
    }

    private void setPerssion() {
        Acp.getInstance(this).request(new AcpOptions.Builder()
                        .setPermissions(
                                Manifest.permission.CAMERA,
                                Manifest.permission.READ_EXTERNAL_STORAGE
//                        //存储空间
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                        Manifest.permission.WRITE_SETTINGS
//                                Manifest.permission.WRITE_SETTINGS,
//                                Manifest.permission.ACCESS_FINE_LOCATION,
//                                Manifest.permission.READ_PHONE_STATE,
//                                Manifest.permission.ACCESS_COARSE_LOCATION
                        )
                /*以下为自定义提示语、按钮文字
                .setDeniedMessage()
                .setDeniedCloseBtn()
                .setDeniedSettingBtn()
                .setRationalMessage()
                .setRationalBtn()*/
                        .build(),
                new AcpListener() {
                    @Override
                    public void onGranted() {
                        LogUtils.d("111111111111111111");
                    }

                    @Override
                    public void onDenied(List<String> permissions) {
                        LogUtils.d("22222222222222222222");
                    }
                });
    }
}
