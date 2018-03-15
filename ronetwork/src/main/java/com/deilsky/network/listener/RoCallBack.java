package com.deilsky.network.listener;

/**
 * Created by 帷幕 on 2017/10/23.
 */

public interface RoCallBack<T> extends RoBaseCallBack{
    void onSuccess(T result);
}
