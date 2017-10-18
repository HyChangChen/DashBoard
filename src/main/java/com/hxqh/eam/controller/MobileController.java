package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import com.hxqh.eam.model.TbIocMobilePerforBadMsg;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mobile")
@SessionAttributes(value = "sessionInfo")
public class MobileController {

    @Autowired
    private MobileService mobileService;


    /**
     * mobile87 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/mobile87", method = RequestMethod.GET)
    public String mobile87() {
        return "mobile/mob87";
    }

    /**
     * vMob87Data 数据接口
     * Access 2017-6-26 11:19:23
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vMob87Data", method = RequestMethod.GET)
    public VMob87Dto vMob87Data() {
        VMob87Dto dig13List = mobileService.vMob87Data();
        return dig13List;
    }


    /**
     * 2. IPPM KPI页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/mobile86", method = RequestMethod.GET)
    public String mobile86() {
        return "mobile/mob86";
    }

    /**
     * 2. IPPM KPI 数据接口
     * Access 2017-6-26 11:19:42
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vMob86Data", method = RequestMethod.GET)
    public Mob86Dto vMob86Data() {
        Mob86Dto mob86Dto = mobileService.vMob86Data();

        return mob86Dto;
    }

    /**
     * 4. MTTR & MTTI页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/mobile88", method = RequestMethod.GET)
    public String mobile88() {
        return "mobile/mob88";
    }

    /**
     * 4. MTTR & MTTI 数据接口
     * Access 2017-6-26 11:19:56
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vMob88Data", method = RequestMethod.GET)
    public Mob88Dto vMob88Data() {
        Mob88Dto mob88Dto = mobileService.getMob88Data();
        return mob88Dto;
    }


    /**
     *  4. MTTR & MTTI  悬停数据接口
     *  treg: TREG-1~7
     *  type: SR,PSR
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/badmsg", method = RequestMethod.GET)
    public List<TbIocMobilePerforBadMsg> badmsgData(@RequestParam("treg") String treg,
                               @RequestParam("type") String type) {
        List<TbIocMobilePerforBadMsg> badmsgData= mobileService.badmsgData(treg,type);
        return badmsgData;
    }




    /**
     * 7. SQUAT页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/mobile91", method = RequestMethod.GET)
    public String mobile91() {
        return "mobile/mob91";
    }

    /**
     * 7. SQUAT 数据接口
     * Access  2017-6-26 11:20:24
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vMob91Data", method = RequestMethod.GET)
    public Mob91Dto vMob91Data() {
        Mob91Dto dig13List = mobileService.vMob91Data();
        return dig13List;
    }

    /**
     * 8. Quality CNOP 页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/mobile92", method = RequestMethod.GET)
    public String mobile92() {
        return "mobile/mob92";
    }

    /**
     * 8. Quality CNOP 数据接口
     * Access  2017-6-26 11:20:48
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vMob92Data", method = RequestMethod.GET)
    public Moblie92 vMob92Data() {
        Moblie92 moblie92 = mobileService.vMob92Data();
//        JSONObject json = JSONObject.fromObject(moblie92);//将java对象转换为json对象
//        String str = json.toString();//将json对象转换为字符串
        return moblie92;
    }

    /**
     * 6. Throughtput IP Transit  页面接口
     *
     * @return
     */
    @RequestMapping(value = "/throughtput", method = RequestMethod.GET)
    public String throughtput() {
        return "mobile/throughput";
    }


    /**
     * 6. Throughtput IP Transit  数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/throughtputData", method = RequestMethod.GET)
    public ThroughtputDto throughtputData() {
        ThroughtputDto throughtputDto = mobileService.throughtputData();
        return throughtputDto;
    }

    /**
     *  1. Backhaul TTC Tsel National  页面跳转接口（拓扑图）
     *
     * @return
     */
    @RequestMapping(value = "/topological", method = RequestMethod.GET)
    public String topological() {
        return "mobile/backhaul";
    }

    /**
     * 1. Backhaul TTC Tsel National  数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/topologicalData", method = RequestMethod.GET)
    public TopologicalDto topologicalData() {
        TopologicalDto topologicalData = mobileService.topologicalData();
        return topologicalData;
    }


}
