package com.function.luo.presenter;




import com.function.luo.bean.LoginBean;
import com.function.luo.contract.MainContract;
import com.function.luo.contract.TwoContract;

import org.jetbrains.annotations.Contract;

import javax.inject.Inject;


/**
 * @author lyy
 */
public  class TwoPresenter extends  TwoContract.Presenter {

    @Inject
    public TwoPresenter() {
    }




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
}
