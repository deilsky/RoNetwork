package com.deilsky.network;

import java.util.List;

/**
 * Created by shui_ on 2018/4/11.
 */

public class RoBase<T> {
    private int status;
    private String msg;
    private T data;
    private List<T> list;

    @Override
    public String toString() {
        return "RoResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", list=" + list +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
