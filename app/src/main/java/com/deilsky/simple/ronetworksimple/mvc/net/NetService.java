package com.deilsky.simple.ronetworksimple.mvc.net;

import com.deilsky.network.RoResult;
import com.deilsky.network.listener.RoProgressUpLoadListener;
import com.deilsky.network.listener.RoResultListener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

/**
 * Created by 帷幕 on 2017/11/29.
 */

public interface NetService {
    @Multipart
    @POST("users/upload")
    Call<RoResult<ArrayList<String>>> upload(@Part List<MultipartBody.Part> file);

    @Multipart
    @POST("users/upload")
    Observable<RoResult<ArrayList<String>>> upload1(@Part List<MultipartBody.Part> file);

    @GET
    Call<ResponseBody> download(@Url String path);

    @GET
    Observable<ResponseBody> download1(@Url String path);
}
