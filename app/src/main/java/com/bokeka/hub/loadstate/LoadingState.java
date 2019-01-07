package com.bokeka.hub.loadstate;

import com.bokeka.hub.R;

/**
 * @author daixin 2019/1/7
 * @website bokeka.com
 */
public class LoadingState extends BaseStateControl {

    @Override
    protected int onCreateView() {
        return R.layout.loading_view;
    }

    @Override
    public boolean isVisible() {
        return super.isVisible();
    }

}
