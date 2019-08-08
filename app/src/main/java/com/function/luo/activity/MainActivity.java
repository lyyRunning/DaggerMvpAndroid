package com.function.luo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.function.luo.base.di.BaseMvpActivity;
import com.function.luo.bean.LoginBean;
import com.function.luo.contract.MainContract;
import com.function.luo.daggermvpandroid.R;
import com.function.luo.presenter.MainPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {

    @Inject
    MainPresenter mainPresenter;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private void init() {

        tv1.setText("loginBean========" + loginBean.toString());
        Log.d("LUO", "loginBean========" + loginBean.toString());
    }

    @Override
    public MainPresenter createPresent() {
        return mainPresenter;
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

    @Override
    public void onSuccess(LoginBean bean) {
        tv2.setText(bean.getId() + "==========" + bean.getUsername() + "========" + bean.getPassword());
    }



    @OnClick({R.id.btn1, R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                mainPresenter.login("小明", "123456");
                break;
            case R.id.btn2:
                TwoActivity.launch(MainActivity.this);
                break;
            default:
        }
    }
}
