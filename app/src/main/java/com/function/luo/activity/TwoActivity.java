package com.function.luo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.function.luo.base.di.ApiService;
import com.function.luo.base.di.BaseMvpActivity;
import com.function.luo.base.di.DaMaiHttpService;
import com.function.luo.base.di.RxSchedulers;
import com.function.luo.bean.LoginBean;
import com.function.luo.contract.MainContract;
import com.function.luo.contract.TwoContract;
import com.function.luo.daggermvpandroid.R;
import com.function.luo.presenter.TwoPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TwoActivity extends BaseMvpActivity<TwoPresenter> implements TwoContract.View {

    @Inject
    TwoPresenter twoPresenter;

    @Inject
    LoginBean loginBean;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;

    @Inject
    DaMaiHttpService daMaiHttpService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btn2.setText("请求网络数据");
        init();
    }

    private void init() {

        tv1.setText("loginBean========" + loginBean.toString());
        Log.d("LUO", "loginBean========" + loginBean.toString());

    }

    @Override
    public TwoPresenter createPresent() {
        return twoPresenter;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    /**
     * 传递数据
     * @param bean
     */
    @Override
    public void onSuccess(LoginBean bean) {
        tv2.setText(bean.getId() + "==========" + bean.getUsername() + "========" + bean.getPassword());
    }

    /**
     * 网络请求返回
     * @param msg
     */
    @Override
    public void onNetSuccess(String msg) {
        Toast.makeText(TwoActivity.this,msg,Toast.LENGTH_LONG).show();
    }


    @OnClick({R.id.btn1, R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                twoPresenter.login("胜利", "6666666");
                break;
            case R.id.btn2:
                twoPresenter.requestNetWork();
                break;
            default:
        }
    }

    public static void launch(Context mContext) {
        Intent intent = new Intent(mContext,TwoActivity.class);
        mContext.startActivity(intent);
    }
}
