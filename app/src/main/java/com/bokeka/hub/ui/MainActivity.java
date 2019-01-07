package com.bokeka.hub.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.bokeka.hub.R;
import com.bokeka.hub.ui.fragment.ArticleFragment;
import com.bokeka.hub.ui.fragment.DiscoveryFragment;
import com.bokeka.hub.ui.fragment.MineFragment;
import com.bokeka.hub.ui.fragment.RecommendFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * @author daixin 2019/1/5
 * @website bokeka.com
 */
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    private static final int FRAGMENT_RECOMMEND = 0;
    private static final int FRAGMENT_ARTICLE = 1;
    private static final int FRAGMENT_FOUND = 2;
    private static final int FRAGMENT_MINE = 3;

    private Toolbar toolbar;
    private RecommendFragment recommendTabFragment;
    private ArticleFragment articleTabFragment;
    private DiscoveryFragment discoveryTabFragment;
    private MineFragment mineTabFragment;
    private long firstClickTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_activity_main);
        setSupportActionBar(toolbar);
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(this);
    }

    private void showFragment(int index) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        hideFragment(ft);
        switch (index) {
            case FRAGMENT_RECOMMEND:
                toolbar.setTitle(R.string.app_name);
                if (recommendTabFragment == null) {
                    recommendTabFragment = RecommendFragment.getInstance();
                    ft.add(R.id.container, recommendTabFragment, RecommendFragment.class.getName());
                } else {
                    ft.show(recommendTabFragment);
                }
                break;
            case FRAGMENT_ARTICLE:
                toolbar.setTitle(R.string.title_acticle);
                if (articleTabFragment == null) {
                    articleTabFragment = ArticleFragment.getInstance();
                    ft.add(R.id.container, articleTabFragment, ArticleFragment.class.getName());
                } else {
                    ft.show(articleTabFragment);
                }
                break;
            case FRAGMENT_FOUND:
                toolbar.setTitle(getString(R.string.title_find));
                if (discoveryTabFragment == null) {
                    discoveryTabFragment = DiscoveryFragment.getInstance();
                    ft.add(R.id.container, discoveryTabFragment, DiscoveryFragment.class.getName());
                } else {
                    ft.show(discoveryTabFragment);
                }
                break;
            case FRAGMENT_MINE:
                toolbar.setTitle(getString(R.string.title_mine));
                if (mineTabFragment == null) {
                    mineTabFragment = MineFragment.getInstance();
                    ft.add(R.id.container, mineTabFragment, MineFragment.class.getName());
                } else {
                    ft.show(mineTabFragment);
                }
                break;
            default:
                break;
        }
        ft.commit();
    }

    private void hideFragment(FragmentTransaction ft) {
        if (recommendTabFragment != null) {
            ft.hide(recommendTabFragment);
        }
        if (articleTabFragment != null) {
            ft.hide(articleTabFragment);
        }
        if (discoveryTabFragment != null) {
            ft.hide(discoveryTabFragment);
        }
        if (mineTabFragment != null) {
            ft.hide(mineTabFragment);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_recommend:
                showFragment(FRAGMENT_RECOMMEND);
                doubleClick(FRAGMENT_RECOMMEND);
                break;
            case R.id.action_article:
                showFragment(FRAGMENT_ARTICLE);
                doubleClick(FRAGMENT_ARTICLE);
                break;
            case R.id.action_find:
                showFragment(FRAGMENT_FOUND);
                doubleClick(FRAGMENT_FOUND);
                break;
            case R.id.action_mine:
                showFragment(FRAGMENT_MINE);
                break;
            default:
                break;
        }
        return true;
    }

    public void doubleClick(int index) {
        long secondClickTime = System.currentTimeMillis();
        if ((secondClickTime - firstClickTime < 500)) {
            switch (index) {
                case FRAGMENT_RECOMMEND:
                    recommendTabFragment.onDoubleClick();
                    break;
                case FRAGMENT_ARTICLE:
                    articleTabFragment.onDoubleClick();
                    break;
                case FRAGMENT_FOUND:
                    discoveryTabFragment.onDoubleClick();
                    break;
                default:
                    break;
            }
        } else {
            firstClickTime = secondClickTime;
        }
    }
}
