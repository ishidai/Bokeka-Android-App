package com.bokeka.hub.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.bokeka.hub.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * @author daixin 2019/1/5
 * @website bokeka.com
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_activity_main);
        setSupportActionBar(toolbar);
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
    }
}
