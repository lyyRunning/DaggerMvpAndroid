package com.function.luo.base.di;

import com.google.gson.Gson;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * @author by cyb on 2019/1/3.
 */

public class DaMaiHttpService {
    /**
     * ApiService Api接口每一个接口
     */
    ApiService apiService;

    public DaMaiHttpService(ApiService apiService) {
        this.apiService = apiService;
    }

    /**
     * 类转化请求体
     * @param requestBean 所有请求参数封装的类
     * @return Okhttp需要的请求体
     */
    public static RequestBody creatRequestBody(BaseRequestBean requestBean) {
        final String params = new Gson().toJson(requestBean);
        String jsonstr = new Gson().toJson(requestBean).replace("\\", "");
        String json = "{\"param\":" + jsonstr + "}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        return requestBody;
    }


//    /**
//     * 登陆接口
//     */
//    public Observable<BaseHttpResponse<LoginResponse>> login(LoginRequest loginRequest) {
//        return apiService.login(createParams(loginRequest));
//    }
//
//
//    /**
//     * 用户退出接口
//     */
//    public Observable<BaseHttpResponse> logOut() {
//        return apiService.logOut();
//    }

    /**
     * 刷新客户端连接时间接口
     */
    public Observable<ResponseBody> login() {
        return apiService.login();
    }


}
