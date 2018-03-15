package com.deilsky.simple.ronetworksimple.mvc.model;

/**
 * Created by 帷幕 on 2018/1/9.
 */

public class EditPics {
    private String path;
    private boolean selected;

    public EditPics(boolean selected,String path) {
        this.path = path;
        this.selected = selected;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
