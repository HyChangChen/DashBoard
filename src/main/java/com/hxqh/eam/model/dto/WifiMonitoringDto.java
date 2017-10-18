package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VWifiMonitoring;

import java.util.List;

/**
 * Created by Ocean lin on 2017/7/14.
 */
public class WifiMonitoringDto {

    private List<VWifiMonitoring> monitoringList;
    private String nowtime;

    public WifiMonitoringDto() {
    }

    public WifiMonitoringDto(List<VWifiMonitoring> monitoringList, String nowtime) {
        this.monitoringList = monitoringList;
        this.nowtime = nowtime;
    }

    public List<VWifiMonitoring> getMonitoringList() {
        return monitoringList;
    }

    public void setMonitoringList(List<VWifiMonitoring> monitoringList) {
        this.monitoringList = monitoringList;
    }

    public String getNowtime() {
        return nowtime;
    }

    public void setNowtime(String nowtime) {
        this.nowtime = nowtime;
    }
}
