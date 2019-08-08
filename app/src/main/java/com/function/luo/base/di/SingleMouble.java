package com.function.luo.base.di;

import android.content.Context;

import com.function.luo.base.MyApplication;
import com.function.luo.scope.ActivityScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by luo on 2019/8/7.
 */
@Module
public abstract class SingleMouble {

    @Provides
    @Singleton
    static Context provideContext(MyApplication application) {
        return application.getApplicationContext();
    }
}
