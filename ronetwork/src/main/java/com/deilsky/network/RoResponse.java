package com.deilsky.network;

import com.deilsky.network.listener.RoBaseListener;
import com.deilsky.network.listener.RoResultListener;

import retrofit2.Response;


/**
 * Created by 帷幕 on 2017/10/24.
 */

public class RoResponse<T> {

    public void formatter(Response<RoResult<T>> response,RoBaseListener<T> listener) {
        if (response.isSuccessful() && 200 == response.code()) {
            listener.onSuccess(response.body());
        } else {
            listener.onError(response.code() + ":" + response.message());
        }
    }

    public void formatter(Response<RoResult<T>> response, RoResultListener<T> listener) {
        if (response.isSuccessful()) {
            listener.onSuccess(response.body());
        } else {
            listener.onError(response.code() + ":" + response.message());
        }
    }
}
