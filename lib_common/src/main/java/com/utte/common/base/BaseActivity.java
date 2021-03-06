package com.utte.common.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.utte.common.R;
import com.utte.common.utils.Utils;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Activity基类
 *
 * @author 江婷婷
 * @name BaseActivity
 */
public class BaseActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 处理actionbar返回点击事件
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /**
     * 设置 toolbar，使用方式：
     * mToolBar = (Toolbar) findViewById(R.id.tool_bar);
     * mToolBar.setTitle("TITLE");
     * setupToolBar(mToolBar, false);
     *
     * @param toolbar   toolbar
     * @param hideTitle 是否隐藏Title
     */
    protected void setupToolBar(Toolbar toolbar, boolean hideTitle) {
        //看源码可以发现setSupportActionBar实际上会将toolBar转换为一个ToolBarActionBar，
        // 这个类继承了ActionBar，最终也是存储在类型为ActionBar的对象中的
        setSupportActionBar(toolbar);
        //所以这里虽然用ActionBar接收，实际上是上面传入的toolBar的封装
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            if (hideTitle) {
                actionBar.setDisplayShowTitleEnabled(false);
            }
        }
    }

    //封装fragment的操作 fragment需要继承BaseFragment
    protected void addFragment(@NonNull BaseFragment fragment, @IdRes int frameId) {
        Utils.checkNotNull(fragment);
        getSupportFragmentManager().beginTransaction()
                .add(frameId, fragment, fragment.getClass().getSimpleName())
                .commitAllowingStateLoss();
    }

    protected void replaceFragment(@NonNull BaseFragment fragment, @IdRes int frameId) {
        Utils.checkNotNull(fragment);
        getSupportFragmentManager().beginTransaction()
                .replace(frameId, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commitAllowingStateLoss();
    }

    protected void hideFragment(@NonNull BaseFragment fragment) {
        Utils.checkNotNull(fragment);
        getSupportFragmentManager().beginTransaction()
                .hide(fragment)
                .commitAllowingStateLoss();
    }

    protected void showFragment(@NonNull BaseFragment fragment) {
        Utils.checkNotNull(fragment);
        getSupportFragmentManager().beginTransaction()
                .show(fragment)
                .commitAllowingStateLoss();
    }

    protected void removeFragment(@NonNull BaseFragment fragment) {
        Utils.checkNotNull(fragment);
        getSupportFragmentManager().beginTransaction()
                .remove(fragment)
                .commitAllowingStateLoss();
    }

}
