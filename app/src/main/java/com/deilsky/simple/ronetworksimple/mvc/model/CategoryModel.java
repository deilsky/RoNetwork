package com.deilsky.simple.ronetworksimple.mvc.model;

/**
 * Created by 帷幕 on 2018/3/12.
 */

public class CategoryModel {
    private int CategoryId;
    private String Name;
    private String Parent;
    private String Remark;
    private int Type;

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getParent() {
        return Parent;
    }

    public void setParent(String parent) {
        Parent = parent;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }
}
