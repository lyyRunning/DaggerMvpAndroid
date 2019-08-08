package com.function.luo.presenter;




import android.util.Log;

import com.function.luo.base.di.ApiService;
import com.function.luo.base.di.DaMaiHttpService;
import com.function.luo.base.di.RxSchedulers;

import com.function.luo.bean.LoginBean;
import com.function.luo.contract.TwoContract;


import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * @author lyy
 */
public  class TwoPresenter extends  TwoContract.Presenter {

    @Inject
    public TwoPresenter() {
    }


    @Inject
    DaMaiHttpService daMaiHttpService;




    @Override
    public void login(String username, String password) {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }
       // mView.showLoading();
        LoginBean loginBean = new LoginBean();
        loginBean.setId(111);
        loginBean.setPassword(password);
        loginBean.setUsername(username);
        mView.onSuccess(loginBean);




    }

    @Override
    public void requestNetWork() {
        daMaiHttpService.login().compose(RxSchedulers.compose()).subscribe(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                mView.onNetSuccess(o.toString());
                Log.d("LUO","========"+o.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
