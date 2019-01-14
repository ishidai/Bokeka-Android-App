package com.bokeka.hub.ui.base;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bokeka.hub.R;
import com.bokeka.hub.loadstate.LoadingState;
import com.bokeka.hub.ui.adapter.ViewPagerAdapter;
import com.bokeka.hub.ui.fragment.BaseFragment;
import com.bokeka.hub.viewmodels.base.BaseViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

/**
 * @author daixin 2019/1/13
 * @website bokeka.com
 */
public abstract class BaseViewPagerFragment<T extends BaseViewModel> extends BaseLifecycleFragment<T> {

    protected TabLayout mTabLayout;

    protected ViewPager mViewPager;

    protected RelativeLayout mTitleBar;

    protected TextView mTitle;

    protected ViewPagerAdapter adapter;

    protected List<BaseFragment> mFragments;

    protected List<String> mTitles;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_main;
    }

    @Override
    public int getContentResId(){
        return R.id.ll_fragment_home_root;
    }

    @Override
    public void initView(Bundle state) {
        super.initView(state);
        loadManager.showStateView(LoadingState.class);
        mTabLayout = getViewById(R.id.home_tab_layout);
        mViewPager = getViewById(R.id.home_view_pager);
        mTitles = new ArrayList<>();
        mFragments = new ArrayList<>();
    }

    /**
     * init adapter
     */
    protected void setAdapter() {
        mTitles.addAll(Arrays.asList(createPageTitle()));
        adapter = new ViewPagerAdapter(getChildFragmentManager(), createFragments(), mTitles);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(mTitles.size());
    }

    /**
     * create ViewPager title
     *
     * @return String[]
     */
    protected abstract String[] createPageTitle();

    /**
     * create Fragment
     *
     * @return List<Fragment>
     */
    protected abstract List<Fragment> createFragments();


    /**
     * set title
     * @param titleName
     */
    protected void setTitle(String titleName) {
        mTitleBar.setVisibility(View.VISIBLE);
        mTitle.setText(titleName);
    }
}
