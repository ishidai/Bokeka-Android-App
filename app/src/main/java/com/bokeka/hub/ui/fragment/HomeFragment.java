package com.bokeka.hub.ui.fragment;


import com.bokeka.hub.ui.base.BaseViewPagerFragment;
import com.bokeka.hub.viewmodels.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;

/**
 * @author daixin 2019/1/7
 * @website bokeka.com
 */
public class HomeFragment extends BaseViewPagerFragment<HomeViewModel> {

    private static HomeFragment INSTANCE;
    private String[] mTitleTabs;

    public static HomeFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HomeFragment();
        }
        return INSTANCE;
    }

    @Override
    protected String[] createPageTitle() {
        mTitleTabs = new String[]{"aaaa", "aas"};
        return mTitleTabs;
    }

    @Override
    protected List<Fragment> createFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new MineFragment());
        fragments.add(new MineFragment());
        return fragments;
    }

    @Override
    protected Object getStateEventKey() {
        return null;
    }
}
