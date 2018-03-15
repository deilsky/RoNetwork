package com.deilsky.network;

/**
 * Created by 帷幕 on 2017/10/9.
 */

public class RoContract {
    public static String SERVICE;
    public static String SOURCES;
    public static boolean PRINT = true;
    public static RoContract instance = new RoContract();

    public static RoContract create() {
        instance = new RoContract();
        return instance;
    }

    private RoContract() {
    }

    public static RoContract create(Contract contract) {
        SERVICE = contract.service();
        SOURCES = contract.sources();
        PRINT = contract.print();
        return instance;
    }

    public static RoContract printLog(boolean print) {
        PRINT = print;
        return instance;
    }
}
