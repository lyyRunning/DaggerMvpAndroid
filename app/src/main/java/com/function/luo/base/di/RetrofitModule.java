package com.function.luo.base.di;




import com.function.luo.utils.HttpInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


/**
 * Created by cyb on 2018/11/21.
 */
@Module
public class RetrofitModule {
    private int CONNECT_TIMEOUT = 30;
    private int READ_TIMEOUT = 30;
    private int WRITE_TIMEOUT = 30;
    private String url = "http://www.jianshu.com";

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(HttpInterceptor interceptor){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
       httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().
                connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS).
                readTimeout(READ_TIMEOUT, TimeUnit.SECONDS).
                writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS).
                //addInterceptor(interceptor).
                retryOnConnectionFailure(true).
                build();
    }
    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient){
       return new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                 //添加数据解析
               // .addConverterFactory(GsonConverterFactory.create())
                 //支持RXJava返回
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
