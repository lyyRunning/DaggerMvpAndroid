package com.function.luo.base;

import android.content.Context;

import com.function.luo.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by luo on 2019/8/7.
 */
@Module
public abstract class SingleMouble {

    @Provides
    @ActivityScope
    static Context provideContext(MyApplication application) {
        return application.getApplicationContext();
    }
}
