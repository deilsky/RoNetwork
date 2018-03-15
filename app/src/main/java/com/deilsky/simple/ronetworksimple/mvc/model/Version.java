package com.deilsky.simple.ronetworksimple.mvc.model;

/**
 * Created by 帷幕 on 2018/2/2.
 */

public class Version {
    private int AppversionId;
    private String FilePath;
    private String Version;

    public int getAppversionId() {
        return AppversionId;
    }

    public void setAppversionId(int appversionId) {
        AppversionId = appversionId;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String filePath) {
        FilePath = filePath;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }
}
