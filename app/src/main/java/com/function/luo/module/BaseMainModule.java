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
     * TwoActivityModule类提供的对象的注入
     * TwoActivityModule2接口，提供TwoPresenter和TwoActivity和对象的注入
     * 将 Present 的关联可以放在TwoActivityModule类下面,也可以放在TwoActivityModuleInterface.class接口中
     * （我喜欢放在TwoActivityModule下，一个类）
     */
    @ActivityScope
    @ContributesAndroidInjector(modules = {TwoActivityModule.class,TwoActivityModuleInterface.class})
    abstract TwoActivity contributeTwoActivityInject();
}
