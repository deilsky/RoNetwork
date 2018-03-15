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
        this.service = service;
        this.sources = sources;
    }

    public Contract(String service, String sources, boolean print) {
        this.service = service;
        this.sources = sources;
        this.print = print;
    }

    public Contract service(String service) {
        this.service = service;
        return this;
    }

    public Contract sources(String sources) {
        this.sources = sources;
        return this;
    }

    public Contract print(boolean print) {
        this.print = print;
        return this;
    }

    public String service() {
        return service;
    }

    public String sources() {
        return sources;
    }

    public boolean print() {
        return print;
    }

}
