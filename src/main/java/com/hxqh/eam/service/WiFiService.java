package com.hxqh.eam.service;

import com.hxqh.eam.model.dto.DailyDto;
import com.hxqh.eam.model.dto.TrafficTdo;
import com.hxqh.eam.model.dto.WifiMonitoringDto;
import com.hxqh.eam.model.dto.WifiMttrDto;
import com.hxqh.eam.model.view.VWifiDistribution;
import com.hxqh.eam.model.view.VWifiMonitoring;
import com.hxqh.eam.model.view.VWifiNumber;
import com.hxqh.eam.model.view.VWifiTicket;

import java.util.List;

/**
 * Created by lh on 2017/4/14.
 */
public interface WiFiService {


    List<VWifiNumber> vWifiNumberData();

    List<VWifiTicket> vWifiTicketData();

    List<VWifiDistribution> vWifiDistributionData();

    WifiMttrDto vWifiMttrData();

    WifiMonitoringDto vWifiMonitoringData();

    DailyDto wifiDailyData();

    TrafficTdo getWifiTrafficData();
}
