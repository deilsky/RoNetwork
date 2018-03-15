package com.deilsky.simple.ronetworksimple.mvc.model;

/**
 * Created by 帷幕 on 2018/3/12.
 */

public class StationModel {
    private int CompanyId;
    private String CompanyName;
    private String Name;
    private int StationId;

    public int getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(int companyId) {
        CompanyId = companyId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStationId() {
        return StationId;
    }

    public void setStationId(int stationId) {
        StationId = stationId;
    }
}
