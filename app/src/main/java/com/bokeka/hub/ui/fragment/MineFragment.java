package com.bokeka.hub.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bokeka.hub.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author daixin 2019/1/7
 * @website bokeka.com
 */
public class MineFragment extends Fragment {

    public static MineFragment INSTANCE = null;

    public static MineFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MineFragment();
        }
        return INSTANCE;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        return view;
    }
}
