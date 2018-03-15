package com.deilsky.simple.ronetworksimple.mvc.model;

/**
 * Created by 帷幕 on 2018/3/12.
 */

public class SaveComplain {
    private int UserId;
    private int ComplainId;
    // 平台(热力平台、行风热线、信访局)
    private String Kind;
    // 类型
    private int CategoryId;
    // 分公司
    private int CompanyId;
    // 供热站
    private int StationId;
    // 姓名
    private String Name;
    // 电话
    private String Phone;
    // 地址
    private String Address;
    // 来电时间
    private String CallTimeStr;
    // 下发时间
    private String PubTimeStr;
    // 处理时限
    private String LimitTimeStr;
    // 来电内容
    private String CallContent;
    // 派单意见
    private String PubOpinion;
    // 班长意见
    private String MonitorOpinion;
    // 投诉次数
    private int CallNum;

    @Override
    public String toString() {
        return "SaveComplain{" +
                "UserId=" + UserId +
                ", ComplainId=" + ComplainId +
                ", Kind='" + Kind + '\'' +
                ", CategoryId=" + CategoryId +
                ", CompanyId=" + CompanyId +
                ", StationId=" + StationId +
                ", Name='" + Name + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Address='" + Address + '\'' +
                ", CallTimeStr='" + CallTimeStr + '\'' +
                ", PubTimeStr='" + PubTimeStr + '\'' +
                ", LimitTimeStr='" + LimitTimeStr + '\'' +
                ", CallContent='" + CallContent + '\'' +
                ", PubOpinion='" + PubOpinion + '\'' +
                ", MonitorOpinion='" + MonitorOpinion + '\'' +
                ", CallNum=" + CallNum +
                '}';
    }

    public int getComplainId() {
        return ComplainId;
    }

    public void setComplainId(int complainId) {
        ComplainId = complainId;
    }

    public String getKind() {
        return Kind;
    }

    public void setKind(String kind) {
        Kind = kind;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public int getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(int companyId) {
        CompanyId = companyId;
    }

    public int getStationId() {
        return StationId;
    }

    public void setStationId(int stationId) {
        StationId = stationId;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCallTimeStr() {
        return CallTimeStr;
    }

    public void setCallTimeStr(String callTimeStr) {
        CallTimeStr = callTimeStr;
    }

    public String getPubTimeStr() {
        return PubTimeStr;
    }

    public void setPubTimeStr(String pubTimeStr) {
        PubTimeStr = pubTimeStr;
    }

    public String getLimitTimeStr() {
        return LimitTimeStr;
    }

    public void setLimitTimeStr(String limitTimeStr) {
        LimitTimeStr = limitTimeStr;
    }

    public String getCallContent() {
        return CallContent;
    }

    public void setCallContent(String callContent) {
        CallContent = callContent;
    }

    public String getPubOpinion() {
        return PubOpinion;
    }

    public void setPubOpinion(String pubOpinion) {
        PubOpinion = pubOpinion;
    }

    public String getMonitorOpinion() {
        return MonitorOpinion;
    }

    public void setMonitorOpinion(String monitorOpinion) {
        MonitorOpinion = monitorOpinion;
    }

    public int getCallNum() {
        return CallNum;
    }

    public void setCallNum(int callNum) {
        CallNum = callNum;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }
}
