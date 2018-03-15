package com.deilsky.simple.ronetworksimple.mvc.model;

/**
 * Created by shui_ on 2018/1/6.
 */

public class UserModel {
    private String Username;
    private String Password;

    public UserModel(String username, String password) {
        Username = username;
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
