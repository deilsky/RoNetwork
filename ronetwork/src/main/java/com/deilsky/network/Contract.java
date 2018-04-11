package com.deilsky.network;

/**
 * Created by 帷幕 on 2017/10/30.
 */

public class Contract {
    private static String service;
    private static String sources;
    private static boolean print = true;
    private static Contract contract = null;

    private Contract() {
    }

    public static Contract create() {
        contract = new Contract();
        return contract;
    }

    public Contract(String service, String sources) {
        Contract.service = service;
        Contract.sources = sources;
    }

    public Contract(String service, String sources, boolean print) {
        Contract.service = service;
        Contract.sources = sources;
        Contract.print = print;
    }

    public Contract service(String service) {
        Contract.service = service;
        return this;
    }

    public Contract sources(String sources) {
        Contract.sources = sources;
        return this;
    }

    public Contract print(boolean print) {
        Contract.print = print;
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
