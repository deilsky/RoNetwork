package com.deilsky.simple.ronetworksimple.mvc.login;

import com.deilsky.network.RoResult;
import com.deilsky.simple.ronetworksimple.mvc.model.LoginModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by 帷幕 on 2017/10/30.
 */

public interface LoginService {
    @POST("post")
    Call<RoResult<Integer>> post(@Body LoginModel loginModel);
    @POST("get")
    Call<RoResult<String>> get();
}
