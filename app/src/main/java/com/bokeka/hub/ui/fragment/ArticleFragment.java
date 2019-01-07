package com.bokeka.hub.ui.fragment;

import androidx.fragment.app.Fragment;

/**
 * @author daixin 2019/1/7
 * @website bokeka.com
 */
public class ArticleFragment extends Fragment {

    public static ArticleFragment INSTANCE;

    public static ArticleFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ArticleFragment();
        }
        return INSTANCE;
    }

    public void onDoubleClick() {

    }
}
