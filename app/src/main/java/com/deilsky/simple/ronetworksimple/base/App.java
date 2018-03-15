package com.deilsky.simple.ronetworksimple.base;

import android.app.Application;
import android.content.Context;

import com.deilsky.network.Contract;
import com.deilsky.network.RoContract;

/**
 * Created by 帷幕 on 2017/10/9.
 */
public class App extends Application {
    private static App instance;
    public Context appContext;
    private static final String TAG = "App";


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appContext = this;
        //331a3b67df15f476e8a0b41e00765ef2
        //http://125.211.222.141:9006/api/
        /*Contract contract = Contract.create().
                service("http://10.242.193.17:8000/api/").sources("http://10.242.193.17:8000/").print(true);*/
        Contract contract = Contract.create().
                service("http://125.211.222.141:9006/api/").sources("http://125.211.222.141:9006/").print(true);
        /*Contract contract = Contract.create().
                service("http://192.168.1.129/api/").sources("http://192.168.1.129/").print(true);*/
        RoContract.create(contract);
        //Logger.addLogAdapter(new AndroidLogAdapter());


    }


}


