package com.deilsky.simple.ronetworksimple.mvc.login;

import com.deilsky.network.RoObservable;
import com.deilsky.network.RoResponse;
import com.deilsky.network.RoResult;
import com.deilsky.network.RoRetrofit;
import com.deilsky.network.listener.RoResultListener;
import com.deilsky.simple.ronetworksimple.mvc.model.Banner;
import com.deilsky.simple.ronetworksimple.mvc.model.Users;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 帷幕 on 2017/10/30.
 */

public class TestApi implements TestContract {
    private TestService service = null;
    static TestApi instance;

    private TestApi() {
        service = RoRetrofit.getInstance().create(TestService.class);
    }

    public static TestApi create() {
        instance = new TestApi();
        return instance;
    }

    @Override
    public void banners(final RoResultListener<RoResult<Banner>> listener) {
        service.banners().enqueue(new Callback<RoResult<Banner>>() {
            @Override
            public void onResponse(Call<RoResult<Banner>> call, Response<RoResult<Banner>> response) {
                new RoResponse<RoResult<Banner>>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<Banner>> call, Throwable t) {
                t.printStackTrace();
                listener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void login(Users model, final RoResultListener<RoResult<Users>> listener) {
        service.login(model).enqueue(new Callback<RoResult<Users>>() {
            @Override
            public void onResponse(Call<RoResult<Users>> call, Response<RoResult<Users>> response) {
                new RoResponse<RoResult<Users>>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<Users>> call, Throwable t) {
                t.printStackTrace();
                listener.onError(t.getMessage());
            }
        });
    }

    @Override
    public Disposable rxDisposableBanners(Consumer<RoResult<Banner>> listener) {

        return service.rxBanners().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(listener);

    }

    @Override
    public void rxObservableBanners(Observer<RoResult<Banner>> listener) {
        new RoObservable<RoResult<Banner>>().formatter(service.rxBanners()).subscribe(listener);
        /*service.rxBanners()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener);*/
    }
}
