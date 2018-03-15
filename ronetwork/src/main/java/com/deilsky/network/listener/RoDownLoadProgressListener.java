package com.deilsky.network.listener;

/**
 * Created by 帷幕 on 2017/11/29.
 */

public interface RoDownLoadProgressListener {
    void onFinashed(String path);
    void onError();
    void onProgress(long progress, long size);
    void onReady(long max);
}
