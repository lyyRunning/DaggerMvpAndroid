package com.function.luo.base;



import com.function.luo.base.di.ApiServiceModule;
import com.function.luo.base.di.HttpIntercepterModel;
import com.function.luo.base.di.RetrofitModule;
import com.function.luo.base.di.SingleMouble;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 *
 * @author luo
 * @date 2019/8/7
 * 整个 APP统一的注入器
 * AndroidSupportInjectionModule.class必须包含
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,AppModule.class,SingleMouble.class,
        HttpIntercepterModel.class,RetrofitModule.class, ApiServiceModule.class})
public interface AppComponent extends AndroidInjector<MyApplication>{
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(MyApplication application);
        AppComponent build();
    }

}
