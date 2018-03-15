package com.deilsky.simple.ronetworksimple.mvc.model;

/**
 * Created by 帷幕 on 2018/3/12.
 */

public class UpdateComplainCompany {
    private int ComplainId;
    //延期内容
    private String DelayContent;
    // 承办人
    private String Operator;
    // 主办人
    private String Marster;

    private String BackTime;
    private String BackPhone;
    private String BackUser;
    private String BackContent;

    public int getComplainId() {
        return ComplainId;
    }

    public void setComplainId(int complainId) {
        ComplainId = complainId;
    }

    public String getDelayContent() {
        return DelayContent;
    }

    public void setDelayContent(String delayContent) {
        DelayContent = delayContent;
    }

    public String getOperator() {
        return Operator;
    }

    public void setOperator(String operator) {
        Operator = operator;
    }

    public String getMarster() {
        return Marster;
    }

    public void setMarster(String marster) {
        Marster = marster;
    }

    public String getBackTime() {
        return BackTime;
    }

    public void setBackTime(String backTime) {
        BackTime = backTime;
    }

    public String getBackPhone() {
        return BackPhone;
    }

    public void setBackPhone(String backPhone) {
        BackPhone = backPhone;
    }

    public String getBackUser() {
        return BackUser;
    }

    public void setBackUser(String backUser) {
        BackUser = backUser;
    }

    public String getBackContent() {
        return BackContent;
    }

    public void setBackContent(String backContent) {
        BackContent = backContent;
    }
}
