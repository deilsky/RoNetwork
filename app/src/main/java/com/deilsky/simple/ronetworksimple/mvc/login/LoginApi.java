package com.deilsky.simple.ronetworksimple.mvc.login;

import com.deilsky.network.RoResponse;
import com.deilsky.network.RoResult;
import com.deilsky.network.RoRetrofit;
import com.deilsky.network.listener.RoResultListener;
import com.deilsky.simple.ronetworksimple.mvc.model.LoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 帷幕 on 2017/10/30.
 */

public class LoginApi implements LoginContract {
    private LoginService service = null;
    public static LoginApi instance;

    private LoginApi() {
        service = RoRetrofit.getInstance().create(LoginService.class);
    }

    public static LoginApi create() {
        instance = new LoginApi();
        return instance;
    }

    @Override
    public void post(LoginModel loginModel, final RoResultListener<String> listener) {
        Call<RoResult<String>> call = service.post(loginModel);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<String>>() {
            @Override
            public void onResponse(Call<RoResult<String>> call, Response<RoResult<String>> response) {
                new RoResponse<String>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<String>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void get(final RoResultListener<String> listener) {
        Call<RoResult<String>> call = service.get();
        listener.onLoading();
        call.enqueue(new Callback<RoResult<String>>() {
            @Override
            public void onResponse(Call<RoResult<String>> call, Response<RoResult<String>> response) {
                new RoResponse<String>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<String>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }
}
