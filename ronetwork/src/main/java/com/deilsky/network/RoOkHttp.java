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
                build.addInterceptor((new HttpLoggingInterceptor(new RoOkHttp.RoLogger(RoOkHttp.RoLevel.HEADER))).setLevel(HttpLoggingInterceptor.Level.HEADERS));
            }
            if (RoContract.PRINT_BODY) {
                build.addInterceptor((new HttpLoggingInterceptor(new RoOkHttp.RoLogger(RoOkHttp.RoLevel.BODY))).setLevel(HttpLoggingInterceptor.Level.BODY));
            }
        }
        this.instance = build.build();
    }

    public enum RoLevel {
        HEADER,
        BODY;

        private RoLevel() {
        }
    }

    class RoLogger implements HttpLoggingInterceptor.Logger {
        private RoOkHttp.RoLevel level;

        RoLogger(RoOkHttp.RoLevel level) {
            this.level = level;
        }

        public void log(String message) {
            switch (this.level) {
                case HEADER:
                    Log.d("DEILSKY HEADER", message);
                    break;
                case BODY:
                    Log.d("DEILSKY BODY", message);
                    break;
                default:
                    Log.d("DEILSKY RONETWORK", message);
            }
        }
    }
}
