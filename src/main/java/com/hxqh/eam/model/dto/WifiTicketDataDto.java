package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VWifiTicket;

import java.util.List;

/**
 * Created by Ocean lin on 2017/7/11.
 */
public class WifiTicketDataDto {

    private List<VWifiTicket> vWifiTickets;
    private String nowTime;

    public WifiTicketDataDto() {
    }

    public WifiTicketDataDto(List<VWifiTicket> vWifiTickets, String nowTime) {
        this.vWifiTickets = vWifiTickets;
        this.nowTime = nowTime;
    }

    public List<VWifiTicket> getvWifiTickets() {
        return vWifiTickets;
    }

    public void setvWifiTickets(List<VWifiTicket> vWifiTickets) {
        this.vWifiTickets = vWifiTickets;
    }

    public String getNowTime() {
        return nowTime;
    }

    public void setNowTime(String nowTime) {
        this.nowTime = nowTime;
    }
}
