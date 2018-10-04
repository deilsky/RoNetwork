package com.deilsky.network.listener;

/**
 * Created by 帷幕 on 2017/11/29.
 */

public interface RoResultListener<T> extends RoBaseCallBack {
    void onSuccess(T result);
}
