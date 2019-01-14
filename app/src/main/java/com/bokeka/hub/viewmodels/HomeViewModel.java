package com.bokeka.hub.viewmodels;

import android.app.Application;

import com.bokeka.hub.data.BlogCategory;
import com.bokeka.hub.viewmodels.base.BaseViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

/**
 * @author daixin 2019/1/13
 * @website bokeka.com
 */
public class HomeViewModel extends BaseViewModel {

    private final MutableLiveData<BlogCategory> mBlogCategories = new MutableLiveData<>();

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<BlogCategory> getBlogCategories() {
        return mBlogCategories;
    }

    private void start() {
        loadBlogCategory();
    }

    private void loadBlogCategory() {
    }
}
