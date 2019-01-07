package com.bokeka.hub.ui.fragment;

import androidx.fragment.app.Fragment;

/**
 * @author daixin 2019/1/7
 * @website bokeka.com
 */
public class DiscoveryFragment extends Fragment {

    public static DiscoveryFragment INSTANCE;
    public static DiscoveryFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DiscoveryFragment();
        }
        return INSTANCE;
    }

    public void onDoubleClick() {

    }
}
