package com.deilsky.simple.ronetworksimple.mvc.net;


import com.deilsky.network.RoResponse;
import com.deilsky.network.RoResult;
import com.deilsky.network.RoRetrofit;
import com.deilsky.network.listener.RoBaseListener;

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
    public void download(String path, final RoBaseListener<ResponseBody> listener) {
        Call<RoResult<ResponseBody>> call = service.download(path);
        call.enqueue(new Callback<RoResult<ResponseBody>>() {
            @Override
            public void onResponse(Call<RoResult<ResponseBody>> call, Response<RoResult<ResponseBody>> response) {
                new RoResponse<ResponseBody>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<ResponseBody>> call, Throwable t) {
                for (StackTraceElement stackTraceElement : t.getStackTrace()) {
                    listener.onError(stackTraceElement.toString());
                }
            }
        });
    }
}
