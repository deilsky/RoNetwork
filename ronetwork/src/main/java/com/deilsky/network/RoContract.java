package com.deilsky.network;

/**
 * Created by 帷幕 on 2017/10/9.
 */

public class RoContract {
    static String SERVICE;
    static String SOURCES;
    static boolean PRINT = true;
    static boolean PRINT_HEADER = false;
    static boolean PRINT_BODY = true;
    static boolean USE_RXJAVA = false;
    private static RoContract instance = new RoContract();
    static final String TAG = "DEILSKY RONETWORK";
    static final String HEADER = "DEILSKY HEADER";
    static final String BODY = "DEILSKY BODY";

    private RoContract() {
    }

    public static RoContract create(RoDefine contract) {
        SERVICE = RoDefine.service();
        SOURCES = RoDefine.sources();
        PRINT = contract.print();
        PRINT_HEADER = contract.header();
        PRINT_BODY = contract.body();
        return instance;
    }
    public static RoContract create(RoDefine contract,boolean useRxJava) {
        SERVICE = RoDefine.service();
        SOURCES = RoDefine.sources();
        PRINT = contract.print();
        PRINT_HEADER = contract.header();
        PRINT_BODY = contract.body();
        USE_RXJAVA = useRxJava;
        return instance;
    }
}
