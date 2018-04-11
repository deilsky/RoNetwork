package com.deilsky.simple.ronetworksimple.mvc.net;

import com.deilsky.network.RoResult;
import com.deilsky.network.listener.RoBaseListener;
import com.deilsky.network.listener.RoResultListener;
import com.deilsky.network.listener.RoUpLoadProgressListener;

import java.util.ArrayList;

import okhttp3.ResponseBody;

/**
 * Created by 帷幕 on 2017/11/29.
 */

public interface NetContract {
    interface UploadContract {
        void upload(ArrayList<String> paths, RoUpLoadProgressListener<String> listener);

        void upload(ArrayList<String> paths, RoResultListener<String> listener);
    }

    interface DownLoadContract {
        void download(String path, RoBaseListener<ResponseBody> listener);
    }
}
