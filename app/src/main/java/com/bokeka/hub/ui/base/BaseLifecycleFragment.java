package com.bokeka.hub.ui.base;

import android.os.Bundle;
import com.bokeka.hub.ui.fragment.BaseFragment;
import com.bokeka.hub.utils.TUtil;
import com.bokeka.hub.viewmodels.base.BaseViewModel;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

/**
 * @author daixin 2019/1/7
 * @website bokeka.com
 */
public abstract class BaseLifecycleFragment<T extends BaseViewModel> extends BaseFragment {

    protected T mViewModel;

    @Override
    public void initView(Bundle state) {
        mViewModel = VMProviders(this, TUtil.getInstance(this, 0));
        if (null != mViewModel) {
            dataObserver();
        }
    }

    /**
     * create ViewModelProviders
     *
     * @return ViewModel
     */
    protected <T extends ViewModel> T VMProviders(BaseFragment fragment, @NonNull Class<T> modelClass) {
        return ViewModelProviders.of(fragment).get(modelClass);

    }

    protected void dataObserver() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
