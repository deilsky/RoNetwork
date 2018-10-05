package com.deilsky.simple.ronetworksimple.mvc.login;

import com.deilsky.network.RoResult;
import com.deilsky.simple.ronetworksimple.mvc.model.Banner;
import com.deilsky.simple.ronetworksimple.mvc.model.Users;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by 帷幕 on 2017/10/30.
 */

public interface TestService {
    @GET("banner/banners")
    Call<RoResult<ArrayList<Banner>>> banners();

    @POST("users/login")
    Call<RoResult<Users>> login(@Body Users users);

    @GET("banner/banners")
    Observable<RoResult<ArrayList<Banner>>> rxBanners();
}
