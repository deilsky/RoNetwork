package com.deilsky.network.listener;

/**
 * Created by 帷幕 on 2017/11/27.
 */

public interface RoProgressUpLoadListener<T> extends RoResultListener<T> {
    void onProgress(long progress, long size, boolean hasFinish);
}
