package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import com.hxqh.eam.common.util.StaticUtils;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.model.view.VWifiDistribution;
import com.hxqh.eam.model.view.VWifiMonitoring;
import com.hxqh.eam.model.view.VWifiNumber;
import com.hxqh.eam.model.view.VWifiTicket;
import com.hxqh.eam.service.WiFiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/wifi")
@SessionAttributes(value = "sessionInfo")
public class WiFiController {

    @Autowired
    private WiFiService wiFiService;


    /**
     * wifi Traffic 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/wifi", method = RequestMethod.GET)
    public String wifi() {
        return "wifi/traffic";
    }


    /**
     * vWifiTrafficData 数据接口
     * Access 2017-6-26 11:21:26
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vWifiTrafficData", method = RequestMethod.GET)
    public TrafficTdo vWifiTrafficData() {
        TrafficTdo wifiTrafficTdo = wiFiService.getWifiTrafficData();
        return wifiTrafficTdo;
    }


    /**
     * number   页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/number", method = RequestMethod.GET)
    public String number() {
        return "wifi/number";
    }

    /**
     * vWifiNumberData 数据接口
     * Access 2017-6-26 11:21:40
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vWifiNumberData", method = RequestMethod.GET)
    public List<VWifiNumber> vWifiNumberData() {
        List<VWifiNumber> dig13List = wiFiService.vWifiNumberData();
        return dig13List;
    }

    /**
     * 1. Wifi Ticket Monitoring 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public String ticket() {
        return "wifi/ticket";
    }

    /**
     * 1. Wifi Ticket Monitoring 数据接口
     * Access 2017-6-26 11:23:07
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vWifiTicketData", method = RequestMethod.GET)
    public WifiTicketDataDto vWifiTicketData() {
        List<VWifiTicket> vWifiTicketList = wiFiService.vWifiTicketData();
        String nowTime = StaticUtils.getDateTimeFormat(new Date());
        WifiTicketDataDto wifiTicketDataDto = new WifiTicketDataDto(vWifiTicketList, nowTime);
        return wifiTicketDataDto;
    }


    /**
     * 9. Daily Ticket Distribution  页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/daily", method = RequestMethod.GET)
    public String daily() {
        return "wifi/daily";
    }


    /**
     * 9. Daily Ticket Distribution 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/wifiDailyData", method = RequestMethod.GET)
    public DailyDto wifiDailyData() {

        DailyDto dailyDto = wiFiService.wifiDailyData();
        return dailyDto;
    }


    /**
     * 6. Distribution Status Report   页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/distribution", method = RequestMethod.GET)
    public String distribution() {
        return "wifi/distribution";
    }


    /**
     * 6. Distribution Status Report 数据接口
     * Access 2017-6-26 11:23:29
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vWifiDistributionData", method = RequestMethod.GET)
    public List<VWifiDistribution> vWifiDistributionData() {
        List<VWifiDistribution> dig13List = wiFiService.vWifiDistributionData();
        return dig13List;
    }

    /**
     * 5. MTTR Targets   页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/mttr", method = RequestMethod.GET)
    public String mttr() {
        return "wifi/mttr";
    }

    /**
     * 5. MTTR Targets 数据接口
     * Access 2017-6-26 11:23:51
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vWifiMttrData", method = RequestMethod.GET)
    public WifiMttrDto vWifiMttrData() {
        WifiMttrDto mttrDto = wiFiService.vWifiMttrData();
        return mttrDto;
    }

    /**
     * 8. Monitoring MTTR Proactive   页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/monitoring", method = RequestMethod.GET)
    public String monitoring() {
        return "wifi/monitoring";
    }

    /**
     * 8. Monitoring MTTR Proactive 数据接口
     * Access 2017-6-26 11:24:01
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vWifiMonitoringData", method = RequestMethod.GET)
    public WifiMonitoringDto vWifiMonitoringData() {
        WifiMonitoringDto monitoringDto = wiFiService.vWifiMonitoringData();
        return monitoringDto;
    }

}
