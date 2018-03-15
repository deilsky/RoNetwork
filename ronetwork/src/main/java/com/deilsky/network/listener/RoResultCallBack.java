package com.deilsky.network.listener;

import com.deilsky.network.RoResult;

/**
 * Created by 帷幕 on 2017/11/29.
 */

public interface RoResultCallBack<T> extends RoBaseCallBack {
    void onSuccess(RoResult<T> result);
}
