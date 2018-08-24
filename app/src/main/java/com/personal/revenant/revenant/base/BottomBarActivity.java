package com.personal.revenant.revenant.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.personal.revenant.revenant.R;
import com.personal.revenant.revenant.fragment.Blank1Fragment;
import com.personal.revenant.revenant.fragment.Blank2Fragment;
import com.personal.revenant.revenant.fragment.Blank3Fragment;
import com.personal.revenant.revenant.fragment.BlankFragment;
import com.yinglan.alphatabs.AlphaTabsIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BottomBarActivity extends BaseActivity {
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.alphaIndicator)
    AlphaTabsIndicator alphaTabsIndicator;

    @Override
    public int getContentViewResId() {
        return R.layout.activity_bottom_bar;
    }

    @Override
    public void initView() {
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager());
        viewpager.setAdapter(mainAdapter);
        viewpager.setOffscreenPageLimit(3);
        alphaTabsIndicator.setViewPager(viewpager);
        viewpager.addOnPageChangeListener(mainAdapter);
        alphaTabsIndicator.getTabView(0).removeShow();
        alphaTabsIndicator.getTabView(1).removeShow();
        alphaTabsIndicator.getTabView(2).removeShow();
        alphaTabsIndicator.getTabView(3).removeShow();
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
    private class MainAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

        private List<Fragment> fragments = new ArrayList<>();
        private String[] titles = {"微信", "通讯录", "发现", "我"};

        public MainAdapter(FragmentManager fm) {
            super(fm);
            fragments.add(new BlankFragment());
            fragments.add(new Blank1Fragment());
            fragments.add(new Blank2Fragment());
            fragments.add(new Blank3Fragment());
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
//            if (0 == position) {
//                alphaTabsIndicator.getTabView(0).showNumber(alphaTabsIndicator.getTabView(0).getBadgeNumber() - 1);
//            } else if (2 == position) {
//                alphaTabsIndicator.getCurrentItemView().removeShow();
//            } else if (3 == position) {
//                alphaTabsIndicator.removeAllBadge();
//            }

            if (0 == position) {
                alphaTabsIndicator.getCurrentItemView().removeShow();
            } else if (1 == position) {
                alphaTabsIndicator.getCurrentItemView().removeShow();
            } else if (2 == position) {
                alphaTabsIndicator.getCurrentItemView().removeShow();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
