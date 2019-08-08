package com.function.luo.base.di;


import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

/**
 * Created by cyb on 2018/11/5.
 */

public class RxSchedulers {

    public static ObservableTransformer compose() {
        return new ObservableTransformer(){
            @Override
            public ObservableSource apply(io.reactivex.Observable upstream) {
                return upstream.subscribeOn(io.reactivex.schedulers.Schedulers.io()).observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread());
            }
        };
    }
}
