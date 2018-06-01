package com.deilsky.network;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by 帷幕 on 2017/10/9.
 */
public enum RoOkHttp {
    INSTANCE;
    OkHttpClient instance;

    public OkHttpClient getInstance() {
        return instance;
    }

    RoOkHttp() {
        OkHttpClient.Builder build = new OkHttpClient.Builder();
        if (RoContract.PRINT) {
            if (RoContract.PRINT_HEADER) {
                build.addInterceptor(new HttpLoggingInterceptor(new RoLogger(RoLevel.HEADER)).setLevel(HttpLoggingInterceptor.Level.HEADERS));
            }
            if (RoContract.PRINT_BODY) {
                build.addInterceptor(new HttpLoggingInterceptor(new RoLogger(RoLevel.BODY)).setLevel(HttpLoggingInterceptor.Level.BODY));
            }
        }
        this.instance = build.build();
    }

    class RoLogger implements HttpLoggingInterceptor.Logger {
        private RoOkHttp.RoLevel level;
        RoLogger(RoOkHttp.RoLevel level) {
            this.level = level;
        }

        @Override
        public void log(String message) {
            switch (level) {
                case HEADER:
                    Log.d(RoContract.HEADER, message);
                    break;
                case BODY:
                    Log.d(RoContract.BODY, message);
                    break;
                default:
                    Log.d(RoContract.TAG, message);
                    break;
            }

        }
    }
    public enum RoLevel {
        HEADER, BODY
    }
}
