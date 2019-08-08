package com.function.luo.contract;



import com.function.luo.base.di.BasePresenter;
import com.function.luo.base.di.BaseView;
import com.function.luo.bean.LoginBean;


/**
 *
 * 在Contract类中定义3 个接口，分别是 Model，View，Presenter。
 * 在接口内部定义方法，方便查看三者之间的关系，方法，使用起来更加简洁。
 */
public class TwoContract {
    /**
     * 这个是 MVP 中的 M
     */
    interface Model {

    }

    /**
     * 这个是 MVP 中的 V
     */
    public interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();


        void onSuccess(LoginBean bean);

        void onNetSuccess(String msg);
    }


    /**
     * 这个是 MVP 中的 P
     */
     public static abstract class Presenter extends BasePresenter<View> {
        /**
         * 登陆
         *
         * @param username
         * @param password
         */
       public abstract  void login(String username, String password);


        /**
         * 网络请求
         */
        public abstract  void requestNetWork();
    }
}
