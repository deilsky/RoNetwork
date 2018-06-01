package com.deilsky.network;

/**
 * Created by 帷幕 on 2017/10/30.
 */

public class RoDefine {
    private static String service;
    private static String sources;
    private static boolean print = true;
    private static boolean header = false;
    private static boolean body = true;
    private static RoDefine contract = null;


    private RoDefine() {
    }

    public static RoDefine create() {
        contract = new RoDefine();
        return contract;
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

    public RoDefine printHeader(boolean header) {
        RoDefine.header = header;
        return this;
    }

    public RoDefine printBody(boolean body) {
        RoDefine.body = body;
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

    boolean header() {
        return header;
    }

    boolean body() {
        return body;
    }
}
