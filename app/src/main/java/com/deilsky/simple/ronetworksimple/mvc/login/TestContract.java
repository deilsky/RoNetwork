package com.deilsky.simple.ronetworksimple.mvc.login;


import com.deilsky.network.RoResult;
import com.deilsky.network.listener.RoResultListener;
import com.deilsky.simple.ronetworksimple.mvc.model.Banner;
import com.deilsky.simple.ronetworksimple.mvc.model.Users;

import retrofit2.http.Query;

/**
 * Created by 帷幕 on 2017/10/30.
 */

public interface TestContract {
    void banners(RoResultListener<RoResult<Banner>> listener);

    void login(Users model, RoResultListener<RoResult<Users>> listener);
}
