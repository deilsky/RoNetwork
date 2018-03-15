package com.deilsky.simple.ronetworksimple.mvc.model;

/**
 * Created by 帷幕 on 2018/3/13.
 */

public class UpdateComplainStation {
    private int ComplainId;
    private int StationUserId;
    private String Result;
    private String FinishTime;
    private String Progress;
    private String Satisfaction;
    private String Reason;
    private Double Lat;
    private Double Lng;
    private String Loction;
    private String Pics;

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

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getFinishTime() {
        return FinishTime;
    }

    public void setFinishTime(String finishTime) {
        FinishTime = finishTime;
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

    public Double getLat() {
        return Lat;
    }

    public void setLat(Double lat) {
        Lat = lat;
    }

    public Double getLng() {
        return Lng;
    }

    public void setLng(Double lng) {
        Lng = lng;
    }

    public String getLoction() {
        return Loction;
    }

    public void setLoction(String loction) {
        Loction = loction;
    }

    public String getPics() {
        return Pics;
    }

    public void setPics(String pics) {
        Pics = pics;
    }
}
