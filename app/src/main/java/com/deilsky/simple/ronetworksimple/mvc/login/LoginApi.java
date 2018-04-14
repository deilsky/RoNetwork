package com.deilsky.simple.ronetworksimple.mvc.login;

import android.util.Log;

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
    static LoginApi instance;

    private LoginApi() {
        service = RoRetrofit.getInstance().create(LoginService.class);
    }

    public static LoginApi create() {
        instance = new LoginApi();
        return instance;
    }

    @Override
    public void post(LoginModel loginModel, final RoResultListener<Integer> listener) {
        Call<RoResult<Integer>> call = service.post(loginModel);
        listener.onLoading();
        call.enqueue(new Callback<RoResult<Integer>>() {
            @Override
            public void onResponse(Call<RoResult<Integer>> call, Response<RoResult<Integer>> response) {
                new RoResponse<Integer>().formatter(response, listener);
            }
            @Override
            public void onFailure(Call<RoResult<Integer>> call, Throwable t) {
                Log.d("onFailure",t.getMessage());
                Log.d("onFailure",t.getLocalizedMessage());
                //t.printStackTrace();

                t.getCause().printStackTrace();
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
                //listener.onError(t.getMessage());

            }
        });
    }
}
