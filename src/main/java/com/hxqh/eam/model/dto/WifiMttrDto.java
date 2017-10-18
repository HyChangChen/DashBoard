package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VWifiMttrList;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/6/29.
 */
public class WifiMttrDto {

    Map<String, List<BigDecimal>> mttrM;
    private Map<String ,List<VWifiMttrList>> leftList;
    private Map<String ,List<VWifiMttrList>> rightList;

    private String[] axisiData;

    private String nowtime;

    public WifiMttrDto() {
    }

    public WifiMttrDto(Map<String, List<BigDecimal>> mttrM, Map<String, List<VWifiMttrList>> leftList, Map<String, List<VWifiMttrList>> rightList, String[] axisiData) {
        this.mttrM = mttrM;
        this.leftList = leftList;
        this.rightList = rightList;
        this.axisiData = axisiData;
    }

    public String[] getAxisiData() {
        return axisiData;
    }

    public void setAxisiData(String[] axisiData) {
        this.axisiData = axisiData;
    }

    public Map<String, List<BigDecimal>> getMttrM() {
        return mttrM;
    }

    public void setMttrM(Map<String, List<BigDecimal>> mttrM) {
        this.mttrM = mttrM;
    }

    public Map<String, List<VWifiMttrList>> getLeftList() {
        return leftList;
    }

    public void setLeftList(Map<String, List<VWifiMttrList>> leftList) {
        this.leftList = leftList;
    }

    public Map<String, List<VWifiMttrList>> getRightList() {
        return rightList;
    }

    public void setRightList(Map<String, List<VWifiMttrList>> rightList) {
        this.rightList = rightList;
    }

    public String getNowtime() {
        return nowtime;
    }

    public void setNowtime(String nowtime) {
        this.nowtime = nowtime;
    }
}
