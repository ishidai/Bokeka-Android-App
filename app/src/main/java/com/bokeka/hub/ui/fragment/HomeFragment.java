package com.bokeka.hub.ui.fragment;


import com.bokeka.hub.ui.base.BaseViewPagerFragment;
import com.bokeka.hub.viewmodels.HomeViewModel;
import java.util.List;

/**
 * @author daixin 2019/1/7
 * @website bokeka.com
 */
public class HomeFragment extends BaseViewPagerFragment<HomeViewModel> {

    private static HomeFragment INSTANCE = null;

    public static HomeFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HomeFragment();
        }
        return INSTANCE;
    }

    @Override
    protected String[] createPageTitle() {
        return new String[0];
    }

    @Override
    protected List<BaseFragment> createFragments() {
        return null;
    }

    @Override
    protected Object getStateEventKey() {
        return null;
    }
}
