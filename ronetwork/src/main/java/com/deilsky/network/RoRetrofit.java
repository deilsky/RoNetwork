package com.deilsky.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 帷幕 on 2017/10/9.
 */
public class RoRetrofit {
    public static Retrofit getInstance() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(RoContract.SERVICE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(RoOkHttp.INSTANCE.getInstance());
        Retrofit retrofit = builder.build();
        return retrofit;
    }
    public static Retrofit getOtherInstance() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(RoContract.SOURCES);
        builder.addConverterFactory(GsonConverterFactory.create())
                .client(RoOkHttp.INSTANCE.getInstance());
        Retrofit retrofit = builder.build();
        return retrofit;
    }
}
