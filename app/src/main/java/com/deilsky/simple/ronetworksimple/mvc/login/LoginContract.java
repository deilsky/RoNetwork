package com.deilsky.simple.ronetworksimple.mvc.login;


import com.deilsky.network.listener.RoResultListener;
import com.deilsky.simple.ronetworksimple.mvc.model.LoginModel;
import com.deilsky.simple.ronetworksimple.mvc.model.GetModel;

/**
 * Created by 帷幕 on 2017/10/30.
 */

public interface LoginContract {
    void post(LoginModel loginModel, RoResultListener<Integer> listener);
    void get(int id,RoResultListener<GetModel> listener);
}
