package com.deilsky.network;

/**
 * Created by 帷幕 on 2017/10/30.
 */

public class RoDefine {
    private static String service;
    private static String sources;
    private static boolean print = false;
    private static RoDefine contract = null;


    private RoDefine() {
    }

    public static RoDefine create() {
        contract = new RoDefine();
        return contract;
    }

    public RoDefine(String service, String sources) {
        RoDefine.service = service;
        RoDefine.sources = sources;
    }

    public RoDefine(String service, String sources, boolean print) {
        RoDefine.service = service;
        RoDefine.sources = sources;
        RoDefine.print = print;
    }

    public RoDefine service(String service) {
        RoDefine.service = service;
        return this;
    }

    public RoDefine sources(String sources) {
        RoDefine.sources = sources;
        return this;
    }

    public RoDefine print(boolean print) {
        RoDefine.print = print;
        return this;
    }


    String service() {
        return service;
    }

    String sources() {
        return sources;
    }

    boolean print() {
        return print;
    }
}
