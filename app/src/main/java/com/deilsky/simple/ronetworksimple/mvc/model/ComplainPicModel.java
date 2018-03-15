package com.deilsky.simple.ronetworksimple.mvc.model;

/**
 * Created by 帷幕 on 2018/1/9.
 */

public class ComplainPicModel {
    private int ComplainId;
    private int ComplainPicId;
    private String Name;
    private String Url;

    public int getComplainId() {
        return ComplainId;
    }

    public void setComplainId(int complainId) {
        ComplainId = complainId;
    }

    public int getComplainPicId() {
        return ComplainPicId;
    }

    public void setComplainPicId(int complainPicId) {
        ComplainPicId = complainPicId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
