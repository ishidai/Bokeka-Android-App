package com.bokeka.hub.loadstate;

import android.content.Context;
import android.view.View;

/**
 * @author daixin 2019/1/7
 * @website bokeka.com
 */
public class SuccessState extends BaseStateControl {

    public SuccessState(View view, Context context, OnRefreshListener onRefreshListener) {
        super(view, context, onRefreshListener);
    }

    @Override
    protected int onCreateView() {
        return 0;
    }

    public void show() {
        getRootView().setVisibility(View.VISIBLE);
    }

    public void showWithStateView(boolean successVisible) {
        getRootView().setVisibility(successVisible ? View.VISIBLE : View.INVISIBLE);
    }

}
