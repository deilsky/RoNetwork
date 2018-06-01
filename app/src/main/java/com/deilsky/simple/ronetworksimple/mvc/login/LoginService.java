package com.deilsky.simple.ronetworksimple.mvc.login;

import com.deilsky.network.RoResult;
import com.deilsky.simple.ronetworksimple.mvc.model.LoginModel;
import com.deilsky.simple.ronetworksimple.mvc.model.GetModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 帷幕 on 2017/10/30.
 */

public interface LoginService {
    @POST("post")
    Call<RoResult<Integer>> post(@Body LoginModel loginModel);
    @GET("Customer/GetAllFamilyList")
    Call<RoResult<GetModel>> get(@Query("id") int id);
}
