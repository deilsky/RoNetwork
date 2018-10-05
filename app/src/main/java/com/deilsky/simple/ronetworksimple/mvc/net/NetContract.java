package com.deilsky.simple.ronetworksimple.mvc.net;

import com.deilsky.network.RoResult;
import com.deilsky.network.listener.RoResultListener;
import com.deilsky.network.listener.RoProgressUpLoadListener;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import okhttp3.ResponseBody;

/**
 * Created by 帷幕 on 2017/11/29.
 */

public interface NetContract {
    interface UploadContract {
        void upload(ArrayList<String> paths, RoProgressUpLoadListener<RoResult<String>> listener);
        void upload(ArrayList<String> paths, RoResultListener<RoResult<String>> listener);
        void upload(ArrayList<String> paths, Observer<RoResult<String>> listener);
    }
    interface DownLoadContract {
        void download(String path, RoResultListener<ResponseBody> listener);
    }
}
