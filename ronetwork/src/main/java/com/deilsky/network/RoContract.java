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
    private static RoContract instance = new RoContract();
    static final String TAG = "DEILSKY RONETWORK";
    static final String HEADER = "DEILSKY HEADER";
    static final String BODY = "DEILSKY BODY";

    private RoContract() {
    }

    public static RoContract create(RoDefine contract) {
        SERVICE = contract.service();
        SOURCES = contract.sources();
        PRINT = contract.print();
        PRINT_HEADER = contract.header();
        PRINT_BODY = contract.body();
        return instance;
    }
}
