package com.function.luo.base.di;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.POST;

/**
 * Created by luo on 2019/8/8.
 */

public interface ApiService {

    /**
     * 登陆接口
     *
     * @return 返回数据
     */
    @POST(com.function.luo.base.di.HttpUrl.PINGURL)
    Observable<ResponseBody> login();

}
