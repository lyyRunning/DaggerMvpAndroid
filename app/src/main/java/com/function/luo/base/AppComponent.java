package com.function.luo.base;



import com.function.luo.scope.ActivityScope;


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
@Component(modules = {AndroidSupportInjectionModule.class,AppModule.class,SingleMouble.class})
public interface AppComponent extends AndroidInjector<MyApplication>{
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(MyApplication application);
        AppComponent build();
    }

}
