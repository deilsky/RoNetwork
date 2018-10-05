package com.deilsky.simple.ronetworksimple.mvc.login;


import com.deilsky.network.RoResult;
import com.deilsky.network.listener.RoResultListener;
import com.deilsky.simple.ronetworksimple.mvc.model.Banner;
import com.deilsky.simple.ronetworksimple.mvc.model.Users;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import retrofit2.http.Query;

/**
 * Created by 帷幕 on 2017/10/30.
 */

public interface TestContract {
    void banners(RoResultListener<RoResult<Banner>> listener);

    void login(Users model, RoResultListener<RoResult<Users>> listener);

    Disposable rxDisposableBanners(Consumer<RoResult<Banner>> listener);

    void rxObservableBanners(Observer<RoResult<Banner>> listener);
}
