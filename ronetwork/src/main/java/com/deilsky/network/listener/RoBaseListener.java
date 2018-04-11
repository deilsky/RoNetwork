package com.deilsky.network.listener;

import com.deilsky.network.RoResult;

/**
 * Created by 帷幕 on 2017/10/23.
 */

public interface RoBaseListener<T> extends RoBaseCallBack {
    void onSuccess(RoResult<T> result);
}
