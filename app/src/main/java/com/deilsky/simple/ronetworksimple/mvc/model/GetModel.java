package com.deilsky.simple.ronetworksimple.mvc.model;

import java.util.List;
import java.util.Map;

/**
 * Created by 帷幕 on 2017/8/21.
 */

public class GetModel {
    private String Avatar;

    @Override
    public String toString() {
        return "GetModel{" +
                "Avatar='" + Avatar + '\'' +
                '}';
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }


}
