package com.function.luo.base.di;



import com.function.luo.utils.HttpInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author by cyb on 2019/1/2.
 */
@Module
public class HttpIntercepterModel {
    @Singleton
    @Provides
    public HttpInterceptor provideHttpInterceptor(){
        return new HttpInterceptor();
    }
}
