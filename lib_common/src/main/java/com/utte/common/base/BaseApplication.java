package com.utte.common.base;

import android.app.Application;

import com.utte.common.utils.Utils;

/**
 * Application基类 主Application和组件单独测试使用的Application都继承此基类。
 * 提供了全局的context，Utils.getContext()取得。
 * @author 江婷婷
 * @name BaseApplication
 */
public class BaseApplication extends Application {

    private static BaseApplication sInstance;

    public static BaseApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        //初始化工具类，传递context
        Utils.init(this);
    }

}
