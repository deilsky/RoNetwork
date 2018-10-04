package com.deilsky.simple.ronetworksimple.mvc.net;


import com.deilsky.network.RoResponse;
import com.deilsky.network.RoRetrofit;
import com.deilsky.network.listener.RoResultListener;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 帷幕 on 2017/11/29.
 */

public class DownLoadApi implements NetContract.DownLoadContract {
    private NetService service = null;
    public static DownLoadApi instance;

    private DownLoadApi() {
        service = RoRetrofit.getOtherInstance().create(NetService.class);
    }

    public static DownLoadApi create() {
        instance = new DownLoadApi();
        return instance;
    }

    @Override
    public void download(String path, final RoResultListener<ResponseBody> listener) {

        Call<ResponseBody> call = service.download(path);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                new RoResponse<ResponseBody>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }
}
