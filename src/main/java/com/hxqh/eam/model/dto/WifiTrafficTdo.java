package com.hxqh.eam.model.dto;


import java.util.List;

/**
 * Created by Ocean Lin on 2017/6/27.
 */
public class WifiTrafficTdo {

    private List<WifiTrafficTopTdo> strTop;
    private List<String> nameList;
    private List<String> nameBottomList;
    private List<WifiTrafficTopTdo> strBottom;



    public List<WifiTrafficTopTdo> getStrTop() {
        return strTop;
    }

    public void setStrTop(List<WifiTrafficTopTdo> strTop) {
        this.strTop = strTop;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public List<String> getNameBottomList() {
        return nameBottomList;
    }

    public void setNameBottomList(List<String> nameBottomList) {
        this.nameBottomList = nameBottomList;
    }

    public List<WifiTrafficTopTdo> getStrBottom() {
        return strBottom;
    }

    public void setStrBottom(List<WifiTrafficTopTdo> strBottom) {
        this.strBottom = strBottom;
    }
}
