package com.deilsky.simple.ronetworksimple.mvc.model;

/**
 * Created by shui_ on 2018/1/6.
 */

public class ComplainModel {
    private int StationUserId;
    private String FinishTime;
    private String Result;
    private String Progress;
    private String Satisfaction;
    private String Reason;
    private String Lat;
    private String Lng;
    private String Location;
    private int ComplainId;
    private String Pics;

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getComplainId() {
        return ComplainId;
    }

    public void setComplainId(int complainId) {
        ComplainId = complainId;
    }


    public int getStationUserId() {
        return StationUserId;
    }

    public void setStationUserId(int stationUserId) {
        StationUserId = stationUserId;
    }

    public String getFinishTime() {
        return FinishTime;
    }

    public void setFinishTime(String finishTime) {
        FinishTime = finishTime;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getProgress() {
        return Progress;
    }

    public void setProgress(String progress) {
        Progress = progress;
    }

    public String getSatisfaction() {
        return Satisfaction;
    }

    public void setSatisfaction(String satisfaction) {
        Satisfaction = satisfaction;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getLng() {
        return Lng;
    }

    public void setLng(String lng) {
        Lng = lng;
    }

    @Override
    public String toString() {
        return "ComplainModel{" +
                "StationUserId=" + StationUserId +
                ", FinishTime='" + FinishTime + '\'' +
                ", Result='" + Result + '\'' +
                ", Progress='" + Progress + '\'' +
                ", Satisfaction='" + Satisfaction + '\'' +
                ", Reason='" + Reason + '\'' +
                ", Lat=" + Lat +
                ", Lng=" + Lng +
                ", Location='" + Location + '\'' +
                ", ComplainId=" + ComplainId +
                ", Pics='" + Pics + '\'' +
                '}';
    }

    public String getPics() {
        return Pics;
    }

    public void setPics(String Pics) {
        this.Pics = Pics;
    }
}
