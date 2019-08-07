package com.function.luo.module;

import com.function.luo.bean.LoginBean;
import com.function.luo.presenter.MainPresenter;
import com.function.luo.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by luo on 2019/8/7.
 * 最底层的 module
 */
@Module
public class MainActivityModule {

    @Provides
    @ActivityScope
    LoginBean provideLoginBean() {
        return new LoginBean();
    }
    @Provides
    @ActivityScope
    MainPresenter getPresenter() {
        return new MainPresenter();
    }
}
