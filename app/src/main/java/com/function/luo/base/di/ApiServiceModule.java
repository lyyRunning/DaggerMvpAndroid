package com.function.luo.base.di;



import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by cyb on 2018/11/21.
 */
@Module
public class ApiServiceModule {
    /**
     *
     * @param retrofit
     * @return
     */
    @Singleton
    @Provides
    ApiService provideApiService(Retrofit retrofit) {

        return retrofit.create(ApiService.class);
    }


    /**
     * 传入ApiService接口，ApiService必须先进行初始化，在 Dagger2内部进行自动生成
     * @param apiService
     * @return
     */
    @Singleton
    @Provides
    DaMaiHttpService provideService(ApiService apiService){
        return new DaMaiHttpService(apiService);
    }
}
