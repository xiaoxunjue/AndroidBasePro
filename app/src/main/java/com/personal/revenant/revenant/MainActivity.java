package com.personal.revenant.revenant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.view.CropImageView;
import com.personal.revenant.revenant.activity.Main2Activity;
import com.personal.revenant.revenant.utils.CommonUtils;
import com.personal.revenant.revenant.utils.GlideImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.a)
    TextView a;
    @BindView(R.id.b)
    TextView b;
    private static final int IMAGE_PICKER = 300;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWight();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void initWight() {
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new GlideImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setCrop(true);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(false); //是否按矩形区域保存
        imagePicker.setSelectLimit(1);    //选中数量限制
        imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
        imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(1000);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(1000);//保存文件的高度。单位像素
        imagePicker.setMultiMode(false);   //允许剪切
    }


    @OnClick({R.id.a, R.id.b})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.a:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.b:
                Intent intenta = new Intent(this, ImageGridActivity.class);
                startActivityForResult(intenta, IMAGE_PICKER);
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == IMAGE_PICKER) {
                ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);


                for (ImageItem datae : images) {
                    String   headImage = datae.path;
                    String imagename = headImage.substring(headImage.lastIndexOf("/") + 1);
                    LogUtils.d("数据是:" + headImage);

//                    bmp = BitmapFactory.decodeFile(headImage);
//                    file = new File(headImage);
//
//                    LogUtils.d("AAAAAAAAAAAAAAAAAAAAAA" + file);
//
//                    filinformation.setImageBitmap(bmp);


                }


            } else {
                Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
