package com.deilsky.simple.ronetworksimple.mvc.net;


import com.deilsky.network.RoRequestBody;
import com.deilsky.network.RoResponse;
import com.deilsky.network.RoResult;
import com.deilsky.network.RoRetrofit;
import com.deilsky.network.listener.RoProgressUpLoadListener;
import com.deilsky.network.listener.RoResultListener;

import java.io.File;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 帷幕 on 2017/11/29.
 */

public class UploadApi implements NetContract.UploadContract {
    private NetService service = null;
    public static UploadApi instance;

    private UploadApi() {
        service = RoRetrofit.getInstance().create(NetService.class);
    }

    public static UploadApi create() {
        instance = new UploadApi();
        return instance;
    }

    @Override
    public void upload(ArrayList<String> paths, final RoProgressUpLoadListener<RoResult<String>> listener) {
        MultipartBody.Builder build = new MultipartBody.Builder();
        build.setType(MultipartBody.FORM);
        for (String path : paths) {
            File file = new File(path);
            RequestBody body = new RoRequestBody(RequestBody.create(MediaType.parse("application/zip"), file), listener);
            build.addFormDataPart("upload", file.getPath(), body);
            build.build();
        }
        Call<RoResult<String>> call = service.upload(build.build().parts());
        call.enqueue(new Callback<RoResult<String>>() {
            @Override
            public void onResponse(Call<RoResult<String>> call, Response<RoResult<String>> response) {
                new RoResponse<RoResult<String>>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<String>> call, Throwable t) {
                t.printStackTrace();
                listener.onError(t.getMessage());
            }
        });
    }

    @Override
    public void upload(ArrayList<String> paths, final RoResultListener<RoResult<String>> listener) {
        MultipartBody.Builder build = new MultipartBody.Builder();
        build.setType(MultipartBody.FORM);
        for (String path : paths) {
            File file = new File(path);
            build.addFormDataPart("upload", file.getPath(), RequestBody.create(MediaType.parse("application/zip"), file));
            build.build();
        }
        Call<RoResult<String>> call = service.upload(build.build().parts());
        call.enqueue(new Callback<RoResult<String>>() {
            @Override
            public void onResponse(Call<RoResult<String>> call, Response<RoResult<String>> response) {
                new RoResponse<RoResult<String>>().formatter(response, listener);
            }

            @Override
            public void onFailure(Call<RoResult<String>> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }
}
