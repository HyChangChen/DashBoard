package com.hxqh.eam.model.dto.action;

import java.io.Serializable;

/**
 * Created by Ocean Lin on 2017/6/27.
 */
public class LoginDto implements Serializable {

    private String name;

    private String password;

    public LoginDto() {
    }

    public LoginDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
