package com.deilsky.simple.ronetworksimple.mvc.model;

/**
 * Created by shui_ on 2018/3/11.
 */

public class Device {
    private int AlertId;
    // 分公司
    private int CompanyId;
    // 供热站
    private int StationId;
    // 开始时间
    private String Begin;
    private String BeginStr;
    // 预计恢复时间
    private String End;
    private String EndStr;
    // 报备原因
    private String Reason;
    // 影响区域
    private String Area;
    // 影响户数
    private String Nums;
    // 影响面积
    private String Areas;
    // 影响单元
    private String Units;
    // 采取措施
    private String Operation;
    // 是否张贴通知
    private String Noticeed;
    // 备注
    private String Remark;
    // 是否解除
    private boolean IsOver;
    private String CompanyName;
    private String StationName;

    @Override
    public String toString() {
        return "Device{" +
                "AlertId=" + AlertId +
                ", CompanyId=" + CompanyId +
                ", StationId=" + StationId +
                ", Begin='" + Begin + '\'' +
                ", BeginStr='" + BeginStr + '\'' +
                ", End='" + End + '\'' +
                ", EndStr='" + EndStr + '\'' +
                ", Reason='" + Reason + '\'' +
                ", Area='" + Area + '\'' +
                ", Nums='" + Nums + '\'' +
                ", Areas='" + Areas + '\'' +
                ", Units='" + Units + '\'' +
                ", Operation='" + Operation + '\'' +
                ", Noticeed='" + Noticeed + '\'' +
                ", Remark='" + Remark + '\'' +
                ", IsOver=" + IsOver +
                ", CompanyName='" + CompanyName + '\'' +
                ", StationName='" + StationName + '\'' +
                '}';
    }

    public int getAlertId() {
        return AlertId;
    }

    public void setAlertId(int alertId) {
        AlertId = alertId;
    }

    public String getBeginStr() {
        return BeginStr;
    }

    public void setBeginStr(String begin) {
        BeginStr = begin;
    }

    public String getEndStr() {
        return EndStr;
    }

    public void setEndStr(String end) {
        EndStr = end;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getNums() {
        return Nums;
    }

    public void setNums(String nums) {
        Nums = nums;
    }

    public String getAreas() {
        return Areas;
    }

    public void setAreas(String areas) {
        Areas = areas;
    }

    public String getUnits() {
        return Units;
    }

    public void setUnits(String units) {
        Units = units;
    }

    public String getOperation() {
        return Operation;
    }

    public void setOperation(String operation) {
        Operation = operation;
    }

    public String getNoticeed() {
        return Noticeed;
    }

    public void setNoticeed(String noticeed) {
        Noticeed = noticeed;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public boolean isOver() {
        return IsOver;
    }

    public void setOver(boolean over) {
        IsOver = over;
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

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getStationName() {
        return StationName;
    }

    public void setStationName(String stationName) {
        StationName = stationName;
    }

    public String getBegin() {
        return Begin;
    }

    public void setBegin(String begin) {
        Begin = begin;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }
}
