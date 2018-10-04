package com.deilsky.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.deilsky.network.listener.RoProgressDownLoadListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.ResponseBody;

/**
 * Created by 帷幕 on 2017/11/29.
 */

public class RoDownLoad {
    private static final String TAG = "【 DEILSKY RODOWNLOAD 】";
    private static String fileSuffix = "";

    public static boolean writeResponseBodyToDisk(Context context, ResponseBody body, String name, RoProgressDownLoadListener listener) {
        Log.d(TAG, "contentType:>>>>" + body.contentType().toString());
        MediaType mediaType = body.contentType();
        StringBuffer _type = new StringBuffer();
        _type.append(mediaType.type()).append("/").append(mediaType.subtype());
        String type = _type.toString();
        Log.d(TAG,type);
        if (type.equals(RoMediaType.APK)) {
            fileSuffix = RoMediaType.APK_SUFFIX;
        } else if (type.equals(RoMediaType.PNG)) {
            fileSuffix = RoMediaType.PNG_SUFFIX;
        } else if (type.equals(RoMediaType.JPG)) {
            fileSuffix = RoMediaType.JPG_SUFFIX;
        } else if (type.equals(RoMediaType.JPEG)) {
            fileSuffix = RoMediaType.JPEG_SUFFIX;
        } else if (type.equals(RoMediaType.BMP)) {
            fileSuffix = RoMediaType.BMP_SUFFIX;
        } else if (type.equals(RoMediaType.ZIP)) {
            fileSuffix = RoMediaType.ZIP_SUFFIX;
        }
        if (TextUtils.isEmpty(name)) {
            name = "DEILSKY_RODOWNLOAD_".toLowerCase() + new Date().getTime() + fileSuffix;
        } else {
            name += fileSuffix;
        }
        String path = context.getExternalFilesDir(null) + File.separator + name;
        Log.d(TAG, "path:>>>>" + path);
        try {
            File futureStudioIconFile = new File(path);
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                byte[] fileReader = new byte[4096];
                long fileSize = body.contentLength();
                listener.onReady(fileSize);
                long fileSizeDownloaded = 0;
                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);
                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);
                    fileSizeDownloaded += read;
                    //Log.d(TAG, "file download: " + fileSizeDownloaded + " of " + fileSize);
                    listener.onProgress(fileSizeDownloaded, fileSize);
                    if(fileSizeDownloaded == fileSize){
                        listener.onFinashed(path);
                    }
                }
                outputStream.flush();

                return true;
            } catch (IOException e) {
                listener.onError();
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            listener.onError();
            return false;
        }
    }
}
