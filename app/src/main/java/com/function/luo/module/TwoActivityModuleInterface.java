package com.function.luo.module;

import com.function.luo.contract.TwoContract;
import com.function.luo.presenter.TwoPresenter;
import com.function.luo.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 *
 * @author luo
 * @date 2019/8/7
 * 最底层的 ModuleInterface，把TwoPresenter和 Activity 关联到一起
 */
@Module
public interface TwoActivityModuleInterface {

    /**
     * 获取到TwoPresenter，准备和 Activity 关联，在 Presenter 中可以使用注入的对象
     * @param twoPresenter
     * @return
     */
    @ActivityScope
    @Binds
    TwoContract.Presenter getPresenter(TwoPresenter twoPresenter);
}
