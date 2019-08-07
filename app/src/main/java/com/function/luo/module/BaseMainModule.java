package com.function.luo.module;

import android.app.Activity;

import com.function.luo.activity.MainActivity;
import com.function.luo.activity.TwoActivity;
import com.function.luo.scope.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by luo on 2019/8/8.
 * 第二层 Module
 */
@Module
public abstract  class BaseMainModule {

    /**
     * MainActivity
     * @return
     */
    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivityInject();

    /**
     * TwoActivity
     * @return
     */
    @ActivityScope
    @ContributesAndroidInjector(modules = TwoActivityModule.class)
    abstract TwoActivity contributeTwoActivityInject();
}
