package com.hxqh.eam.controller;

/**
 * Created by Ocean Lin on 2017/6/26.
 */

import com.hxqh.eam.model.base.Status;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.model.view.VDig13;
import com.hxqh.eam.model.view.VDig14;
import com.hxqh.eam.model.view.VDig17;
import com.hxqh.eam.model.view.VDig18;
import com.hxqh.eam.service.DigitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/digital")
@SessionAttributes(value = "sessionInfo")
public class DigitalController {

    @Autowired
    private DigitalService digitalService;

    /**
     * digital13  digital14 digital17 digital18   13141718 公用页面跳转接口
     *
     * @return
     */
    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    public ModelAndView digital(@PathVariable String page) {
        Map<String, Object> result = new HashMap<>();
        result.put("page", page);
        return new ModelAndView("digital/digital", result);
    }

    /**
     * digital13Data 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vDigital13Data", method = RequestMethod.GET)
    public Dig13Dto digital13Data() {

        List<VDig13> dig13List = digitalService.digital13Data();
        Dig13Dto dig13Dto = new Dig13Dto(dig13List, Status.IOC13);
        return dig13Dto;
    }

    /**
     * vDig14Data 数据接口
     * Access 2017-6-26 11:05:12
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vDigital14Data", method = RequestMethod.GET)
    public Dig14Dto vDig14Data() {
        List<VDig14> dig13List = digitalService.vDig14Data();
        Dig14Dto dig14Dto = new Dig14Dto(dig13List, Status.IOC14);
        return dig14Dto;
    }

    /**
     * vDig17Data 数据接口
     * Access 2017-6-26 11:05:50
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vDigital17Data", method = RequestMethod.GET)
    public Dig17Dto vDig17Data() {
        List<VDig17> dig17List = digitalService.vDig17Data();
        Dig17Dto dig17Dto = new Dig17Dto(dig17List, Status.IOC17);
        return dig17Dto;
    }

    /**
     * vDig18Data 数据接口
     * Access 2017-6-26 11:06:08
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vDigital18Data", method = RequestMethod.GET)
    public Dig18Dto vDig18Data() {
        List<VDig18> dig13List = digitalService.vDig18Data();
        Dig18Dto dig18Dto = new Dig18Dto(dig13List, Status.IOC18);
        return dig18Dto;
    }

    /**
     * vDig13141718Data 数据接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/vDigital13141718Data", method = RequestMethod.GET)
    public Dig13141718Dto vDig13141718Data() {
        return digitalService.vDig13141718Data();
    }

}

