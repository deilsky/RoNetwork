package com.deilsky.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 帷幕 on 2017/10/9.
 */
public class RoRetrofit {
    public RoRetrofit() {
    }

    public static Retrofit getInstance() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(RoContract.SERVICE).addConverterFactory(GsonConverterFactory.create()).client(RoOkHttp.INSTANCE.getInstance());
        if (RoContract.USE_RXJAVA) {
            builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        }
        return builder.build();
    }

    public static Retrofit getOtherInstance() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(RoContract.SOURCES);
        builder.addConverterFactory(GsonConverterFactory.create()).client(RoOkHttp.INSTANCE.getInstance());
        if (RoContract.USE_RXJAVA) {
            builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        }
        return builder.build();
    }
}
