package com.hxqh.eam.model.dto;


/**
 * Created by Ocean Lin on 2017/6/27.
 */
public class WifiTrafficTopTdo {

    private String da;
    private String str;

    public String getDa() {
        return da;
    }

    public void setDa(String da) {
        this.da = da;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public WifiTrafficTopTdo(String da, String str) {
        this.da = da;
        this.str = str;
    }
}
