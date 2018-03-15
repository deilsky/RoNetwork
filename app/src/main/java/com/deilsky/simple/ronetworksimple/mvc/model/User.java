package com.deilsky.simple.ronetworksimple.mvc.model;

/**
 * Created by shui_ on 2018/1/6.
 */

public class User {
    private String Username;
    private int UserId;
    private String Birthday;
    private Integer CompanyId;
    private String CompanyName;
    private String DeviceId;
    private String Name;
    private String Password;
    private String sex;
    private Integer StationId;
    private String StationName;
    private boolean NeedLocaltion;

    public User(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public Integer getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(Integer companyId) {
        CompanyId = companyId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String deviceId) {
        DeviceId = deviceId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getStationId() {
        return StationId;
    }

    public void setStationId(Integer stationId) {
        StationId = stationId;
    }

    public String getStationName() {
        return StationName;
    }

    public void setStationName(String stationName) {
        StationName = stationName;
    }

    @Override
    public String toString() {
        return "User{" +
                "Username='" + Username + '\'' +
                ", UserId=" + UserId +
                ", Birthday='" + Birthday + '\'' +
                ", CompanyId=" + CompanyId +
                ", CompanyName='" + CompanyName + '\'' +
                ", DeviceId='" + DeviceId + '\'' +
                ", Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                ", sex='" + sex + '\'' +
                ", StationId=" + StationId +
                ", StationName='" + StationName + '\'' +
                ", NeedLocaltion=" + NeedLocaltion +
                '}';
    }

    public boolean isNeedLocaltion() {
        return NeedLocaltion;
    }

    public void setNeedLocaltion(boolean needLocaltion) {
        NeedLocaltion = needLocaltion;
    }
}
