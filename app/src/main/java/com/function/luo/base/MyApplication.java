package com.function.luo.base;


import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 *
 * @author luo
 * @date 2019/8/7
 * 全局的
 */

public class MyApplication extends DaggerApplication {

    @Override
    public void onCreate() {

        super.onCreate();
    }



    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        //初始化注入
        AppComponent  appComponent = DaggerAppComponent.builder().application(this).build();
        return appComponent;
    }
}
