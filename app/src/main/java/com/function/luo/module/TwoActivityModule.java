package com.function.luo.module;

import com.function.luo.bean.LoginBean;
import com.function.luo.contract.TwoContract;
import com.function.luo.presenter.MainPresenter;
import com.function.luo.presenter.TwoPresenter;
import com.function.luo.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by luo on 2019/8/7.
 * 最底层的 module
 */
@Module
public class TwoActivityModule {

    /**
     * 提供一个对象
     * @return
     */
    @Provides
    @ActivityScope
    LoginBean provideLoginBean() {
        return new LoginBean();
    }

    /**
     * 获取到TwoPresenter，准备和 Activity 关联，在Presenter中可以直接注入对象
     * @param twoPresenter
     * @return
     */
    @ActivityScope
    @Provides
    public TwoContract.Presenter getPresenter(TwoPresenter twoPresenter){
        return twoPresenter;
    }
}
