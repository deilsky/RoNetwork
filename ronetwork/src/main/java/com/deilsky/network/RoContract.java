package com.deilsky.network;

/**
 * Created by 帷幕 on 2017/10/9.
 */

public class RoContract {
    static String SERVICE;
    static String SOURCES;
    static boolean PRINT = true;
    private static RoContract instance = new RoContract();
    static final String TAG = "DEILSKY RONETWORK";

    static final String BASE = "【 DEILSKY RONETWORK START 】" + "\n" +
            "【 url : %1$s 】" + "\n" +
            "【 port : %2$s 】" + "\n" +
            "【 method : %3$s 】" + "\n" +
            "【 code : %5$d 】" + "\n" +
            "【 success : %4$s 】" + "\n";
    static final String PARAMTER = "【 %1$s : %2$s 】";
    static final String END = "【 DEILSKY RONETWORK END 】";

    private RoContract() {
    }

    public static RoContract create(RoDefine contract) {
        SERVICE = contract.service();
        SOURCES = contract.sources();
        PRINT = contract.print();
        return instance;
    }
}
