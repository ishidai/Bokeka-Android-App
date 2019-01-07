package com.bokeka.hub.viewmodel.base;

import android.app.Application;

import com.bokeka.hub.repository.base.BaseRepository;
import com.bokeka.hub.utils.TUtil;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

/**
 * @author daixin 2019/1/7
 * @website bokeka.com
 */
public class BaseViewModel<T extends BaseRepository> extends AndroidViewModel {

    public T mRepository;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        mRepository = TUtil.getNewInstance(this, 0);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (mRepository != null) {
            mRepository.unDisposable();
        }
    }

}
