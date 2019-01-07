package com.bokeka.hub.ui.fragment;

import androidx.fragment.app.Fragment;

/**
 * @author daixin 2019/1/7
 * @website bokeka.com
 */
public class RecommendFragment extends Fragment {

    private static RecommendFragment INSTANCE;

    public static RecommendFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RecommendFragment();
        }
        return INSTANCE;
    }

    public void onDoubleClick() {

    }
}
