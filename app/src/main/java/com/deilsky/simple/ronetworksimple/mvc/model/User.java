package com.deilsky.simple.ronetworksimple.mvc.model;

/**
 * Created by 帷幕 on 2017/6/15.
 */

public class User {
    private int CustomerId;
    private boolean IsHero;
    private String Avatar;
    private String Name;
    private String Phone;
    private String CenterUser;
    private String CenterPwd;
    private boolean IsReqhero;
    private String LinkName;
    private String LinkPhone;
    private double Amount;
    private double Point;
    private boolean Offline;

    @Override
    public String toString() {
        return "User{" +
                "CustomerId=" + CustomerId +
                ", IsHero=" + IsHero +
                ", Avatar='" + Avatar + '\'' +
                ", Name='" + Name + '\'' +
                ", Phone='" + Phone + '\'' +
                ", CenterUser='" + CenterUser + '\'' +
                ", CenterPwd='" + CenterPwd + '\'' +
                ", IsReqhero=" + IsReqhero +
                ", LinkName='" + LinkName + '\'' +
                ", LinkPhone='" + LinkPhone + '\'' +
                ", Amount=" + Amount +
                ", Point=" + Point +
                ", Offline=" + Offline +
                '}';
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public boolean isHero() {
        return IsHero;
    }

    public void setHero(boolean hero) {
        IsHero = hero;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getCenterUser() {
        return CenterUser;
    }

    public void setCenterUser(String centerUser) {
        CenterUser = centerUser;
    }

    public String getCenterPwd() {
        return CenterPwd;
    }

    public void setCenterPwd(String centerPwd) {
        CenterPwd = centerPwd;
    }

    public boolean isReqhero() {
        return IsReqhero;
    }

    public void setReqhero(boolean reqhero) {
        IsReqhero = reqhero;
    }

    public String getLinkName() {
        return LinkName;
    }

    public void setLinkName(String linkName) {
        LinkName = linkName;
    }

    public String getLinkPhone() {
        return LinkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        LinkPhone = linkPhone;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public double getPoint() {
        return Point;
    }

    public void setPoint(double point) {
        Point = point;
    }

    public boolean isOffline() {
        return Offline;
    }

    public void setOffline(boolean offline) {
        Offline = offline;
    }
}
