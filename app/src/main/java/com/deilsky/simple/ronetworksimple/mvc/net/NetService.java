package com.deilsky.simple.ronetworksimple.mvc.net;

import com.deilsky.network.RoResult;

import java.util.List;

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
    @POST("upload")
    Call<RoResult<String>> upload(@Part List<MultipartBody.Part> file);
    @GET
    Call<RoResult<ResponseBody>> download(@Url String path);
}
