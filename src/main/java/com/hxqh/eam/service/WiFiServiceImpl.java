package com.hxqh.eam.service;

import com.hxqh.eam.common.util.GroupListUtil;
import com.hxqh.eam.common.util.StaticUtils;
import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.dto.DailyDto;
import com.hxqh.eam.model.dto.TrafficTdo;
import com.hxqh.eam.model.dto.WifiMonitoringDto;
import com.hxqh.eam.model.dto.WifiMttrDto;
import com.hxqh.eam.model.view.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by lh on 2017/4/14.
 */
@Service("wiFiService")
public class WiFiServiceImpl implements WiFiService {

    static Logger logger = Logger.getLogger(WiFiServiceImpl.class);


    private static final String[] AXISIDATA = {"NAS", "TREG-1", "TREG-2", "TREG-3", "TREG-4", "TREG-5", "TREG-6", "TREG-7"};

    private static final String[] DAILYTICKET = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    @Autowired
    private VWifiDailyDao vWifiDailyDao;
    @Autowired
    private VWifiDistributionDao vWifiDistributionDao;
    @Autowired
    private VWifiMonitoringDao vWifiMonitoringDao;
    @Autowired
    private VWifiMttrDao vWifiMttrDao;
    @Autowired
    private VWifiNumberDao vWifiNumberDao;
    @Autowired
    private VWifiTicketDao vWifiTicketDao;
    @Autowired
    private VWifiTrafficBottomDao vWifiTrafficBottomDao;
    @Autowired
    private VWifiTrafficTopDao vWifiTrafficTopDao;
    @Autowired
    private VWifiMttrListDao vWifiMttrListDao;


    @Override
    public List<VWifiNumber> vWifiNumberData() {
        return vWifiNumberDao.findAll();
    }

    @Override
    public List<VWifiTicket> vWifiTicketData() {
        return vWifiTicketDao.findAll();
    }


    @Override
    public List<VWifiDistribution> vWifiDistributionData() {
        return vWifiDistributionDao.findAll();
    }

    @Override
    public WifiMttrDto vWifiMttrData() {
        List<VWifiMttr> wifiMttrList = vWifiMttrDao.findAll();
        List<VWifiMttrList> mttrListList = vWifiMttrListDao.findAll();
        // mttrListList进行分组
        Map<String, List<VWifiMttrList>> map = GroupListUtil.group(mttrListList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                VWifiMttrList d = (VWifiMttrList) obj;
                return d.getIoc1();    // 分组依据为Ioc1
            }
        });

        Map<String, List<VWifiMttrList>> leftList = new LinkedHashMap<>();
        Map<String, List<VWifiMttrList>> rightList = new LinkedHashMap<>();
        //拆分Map
        int i = 0;
        for (Map.Entry m : map.entrySet()) {
            if (map.size() / 2 > i) {
                leftList.put((String) m.getKey(), (List<VWifiMttrList>) m.getValue());
                i++;
            } else {
                rightList.put((String) m.getKey(), (List<VWifiMttrList>) m.getValue());
                i++;
            }
        }

        // wifiMttrList进行分组
        Map<String, List<VWifiMttr>> mttrMap = GroupListUtil.group(wifiMttrList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                VWifiMttr d = (VWifiMttr) obj;
                return d.getDa();    // 分组依据为Ioc1
            }
        });

        Map<String, List<BigDecimal>> mttrM = new LinkedHashMap<>();
        for (Map.Entry<String, List<VWifiMttr>> m : mttrMap.entrySet()) {
            List<BigDecimal> mttrs = new LinkedList<>();
            for (VWifiMttr l : m.getValue()) {
                mttrs.add(l.getCount());
            }
            mttrM.put(m.getKey(), mttrs);
        }

        WifiMttrDto mttrDto = new WifiMttrDto(mttrM, leftList, rightList, AXISIDATA);
        //示例：2017-07
        mttrDto.setNowtime(StaticUtils.getYearMonthFormat(new Date()));
        return mttrDto;
    }

    @Override
    public WifiMonitoringDto  vWifiMonitoringData() {
        List<VWifiMonitoring> monitoringList = vWifiMonitoringDao.findAll();
        //示例：Monitoring MTTR Proactive 2017-07-13
        String title = "Monitoring MTTR Proactive "+StaticUtils.getYearMonthDayFormat(new Date());
        WifiMonitoringDto monitoringDto = new WifiMonitoringDto(monitoringList,title);
        return monitoringDto;
    }

    @Override
    public DailyDto wifiDailyData() {
        List<VWifiDaily> dailyList = vWifiDailyDao.findAll();

        // 进行分组
        Map<String, List<VWifiDaily>> map = GroupListUtil.group(dailyList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                VWifiDaily d = (VWifiDaily) obj;
                return d.getDa();    // 分组依据为Regional
            }
        });

        Map<String, List<BigDecimal>> dailyktM = new LinkedHashMap<>();
        for (Map.Entry<String, List<VWifiDaily>> m : map.entrySet()) {
            List<BigDecimal> daily = new LinkedList<>();
            for (VWifiDaily l : m.getValue()) {
                daily.add(l.getCount());
            }
            dailyktM.put(m.getKey(), daily);
        }

        DailyDto dailyDto = new DailyDto(dailyktM, DAILYTICKET);
        //示例：Daily Ticket Distribution(2017-07-09 To 2017-07-15)
        StringBuilder builder = new StringBuilder(50);
        builder.append("Daily Ticket Distribution (").append(StaticUtils.getYearMonthDayFormat(StaticUtils.getBeginDayOfWeek()));
        builder.append(" To ").append(StaticUtils.getYearMonthDayFormat(StaticUtils.getEndDayOfWeek())).append(")");
        dailyDto.setNowtime(builder.toString());
        return dailyDto;
    }

    @Override
    public TrafficTdo getWifiTrafficData() {
        //先取出全部数据
        List<VWifiTrafficTop> trafficTopList = vWifiTrafficTopDao.findAll();
        List<VWifiTrafficBottom> trafficBottomList = vWifiTrafficBottomDao.findAll();

        // 分别计算top 和 bottom 的nameList
        HashMap<String, String> tempTopMap = new LinkedHashMap<>();
        for (VWifiTrafficTop top : trafficTopList) {
            String name = top.getName();
            tempTopMap.put(name, name);
        }
        List<String> topNameList = new LinkedList<>();
        for (String key : tempTopMap.keySet()) {
            topNameList.add(tempTopMap.get(key));
        }

        HashMap<String, String> tempBottomMap = new LinkedHashMap<>();
        for (VWifiTrafficBottom bottom : trafficBottomList) {
            String name = bottom.getName();
            tempBottomMap.put(name, name);
        }
        List<String> bottomNameList = new LinkedList<>();
        for (String key : tempBottomMap.keySet()) {
            bottomNameList.add(tempBottomMap.get(key));
        }

         /* 分组算法**/
        Map<String, List<BigDecimal>> topMap = new HashMap<>();
        for (VWifiTrafficTop skuVo : trafficTopList) {
            List<BigDecimal> tempList = topMap.get(skuVo.getDa());
            /*如果取不到数据,那么直接new一个空的ArrayList**/
            groupList(topMap, tempList, skuVo.getCount(), skuVo.getDa());
        }

        Map<String, List<BigDecimal>> bottomMap = new HashMap<>();
        for (VWifiTrafficBottom skuVo : trafficBottomList) {
            List<BigDecimal> tempList = bottomMap.get(skuVo.getDa());
            /*如果取不到数据,那么直接new一个空的ArrayList**/
            groupList(bottomMap, tempList, skuVo.getCount(), skuVo.getDa());
        }
        TrafficTdo trafficTdo = new TrafficTdo(topNameList, bottomNameList, topMap, bottomMap);
        return trafficTdo;
    }

    private void groupList(Map<String, List<BigDecimal>> skuIdMap, List<BigDecimal> tempList, BigDecimal count, String da) {
        if (tempList == null) {
            tempList = new LinkedList<>();
            tempList.add(count);
            skuIdMap.put(da, tempList);
        } else {
        /*某个sku之前已经存放过了,则直接追加数据到原来的List里**/
            tempList.add(count);
        }
    }
}



