package com.bokeka.hub.ui.base;

import android.os.Bundle;
import android.text.TextUtils;

import com.bokeka.hub.LiveBus;
import com.bokeka.hub.loadstate.BaseStateControl;
import com.bokeka.hub.loadstate.LoadingState;
import com.bokeka.hub.ui.fragment.BaseFragment;
import com.bokeka.hub.utils.constans.ErrorState;
import com.bokeka.hub.utils.constans.StateConstants;
import com.bokeka.hub.utils.TUtil;
import com.bokeka.hub.viewmodels.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

/**
 * @author daixin 2019/1/7
 * @website bokeka.com
 */
public abstract class BaseLifecycleFragment<T extends BaseViewModel> extends BaseFragment {

    protected T mViewModel;

    protected Object mStateEventKey;

    protected String mStateEventTag;

    private List<Object> eventKeys = new ArrayList<>();

    @Override
    public void initView(Bundle state) {
        mViewModel = VMProviders(this, TUtil.getInstance(this, 0));
        if (null != mViewModel) {
            dataObserver();
            mStateEventKey = getStateEventKey();
            mStateEventTag = getStateEventTag();
//            eventKeys.add(new StringBuilder((String) mStateEventKey).append(mStateEventTag).toString());
//            LiveBus.getDefault().subscribe(mStateEventKey, mStateEventTag).observe(this, observer);
        }
    }

    /**
     * ViewPager + fragment tag
     *
     * @return
     */
    protected String getStateEventTag() {
        return "";
    }

    /**
     * get state page event key
     *
     * @return
     */
    protected abstract Object getStateEventKey();

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

    protected <T> MutableLiveData<T> registerObserver(Object eventKey, Class<T> tClass) {

        return registerObserver(eventKey, null, tClass);
    }

    protected <T> MutableLiveData<T> registerObserver(Object eventKey, String tag, Class<T> tClass) {
        String event;
        if (TextUtils.isEmpty(tag)) {
            event = (String) eventKey;
        } else {
            event = eventKey + tag;
        }
        eventKeys.add(event);
        return LiveBus.getDefault().subscribe(eventKey, tag, tClass);
    }


    @Override
    protected void onStateRefresh() {
        showLoading();
    }


    /**
     * 获取网络数据
     */
    protected void getRemoteData() {

    }

    protected void showError(Class<? extends BaseStateControl> stateView, Object tag) {
        loadManager.showStateView(stateView, tag);
    }

    protected void showError(Class<? extends BaseStateControl> stateView) {
        showError(stateView, null);
    }

    protected void showSuccess() {
        loadManager.showSuccess();
    }

    protected void showLoading() {
        loadManager.showStateView(LoadingState.class);
    }


    protected Observer observer = (Observer<String>) state -> {
        if (!TextUtils.isEmpty(state)) {
            if (StateConstants.ERROR_STATE.equals(state)) {
                showError(ErrorState.class, "2");
            } else if (StateConstants.NET_WORK_STATE.equals(state)) {
                showError(ErrorState.class, "1");
            } else if (StateConstants.LOADING_STATE.equals(state)) {
                showLoading();
            } else if (StateConstants.SUCCESS_STATE.equals(state)) {
                showSuccess();
            }
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (eventKeys != null && eventKeys.size() > 0) {
            for (int i = 0; i < eventKeys.size(); i++) {
                LiveBus.getDefault().clear(eventKeys.get(i));
            }
        }
    }
}
