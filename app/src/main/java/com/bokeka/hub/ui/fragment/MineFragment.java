package com.bokeka.hub.ui.fragment;

import androidx.fragment.app.Fragment;

/**
 * @author daixin 2019/1/7
 * @website bokeka.com
 */
public class MineFragment extends Fragment {

    public static MineFragment INSTANCE;
    public static MineFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MineFragment();
        }
        return INSTANCE;
    }
}
