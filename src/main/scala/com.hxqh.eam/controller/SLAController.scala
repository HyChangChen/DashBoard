/**
  * Created by Ocean lin on 2017/8/2.
  */
package com.hxqh.eam.controller

import com.hxqh.eam.model.dto._
import com.hxqh.eam.service.SLAService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation._
import org.springframework.web.servlet.ModelAndView

@ComponentScan
@RestController
@RequestMapping(Array("/sla"))
class SLAController  @Autowired()(private val sLAService: SLAService) {

//  @Autowired private val sLAService: SLAService = null

  /**
    * 5.Internal for all NITS  页面跳转接口
    *
    * @return
    */
  @RequestMapping(value = Array("/internal"), method = Array(RequestMethod.GET)) def internal: ModelAndView = new ModelAndView("sla/internal")

  /**
    * 5.Internal for all NITS 数据接口
    *
    * @return
    */
  @ResponseBody
  @RequestMapping(value = Array("/internalData"), method = Array(RequestMethod.GET)) def internalData: InternalDto = {
    sLAService.internalData
  }



  /**
    * 6.Per service Type Performance View Internal   页面跳转接口
    *
    * @return
    */
  @RequestMapping(value = Array("/perservice"), method = Array(RequestMethod.GET)) def perservice: ModelAndView = new ModelAndView("sla/perservice")

  /**
    * 6.Per service Type Performance View Internal 数据接口
    *
    * @return
    */
  @ResponseBody
  @RequestMapping(value = Array("/perserviceData"), method = Array(RequestMethod.GET)) def perserviceData: PerserviceDto = {
    sLAService.perserviceData
  }




  /**
    * 7.Closed ticket performance of various unit’s  页面跳转接口
    *
    * @return
    */
  @RequestMapping(value = Array("/variousunit"), method = Array(RequestMethod.GET)) def variousunit: ModelAndView = new ModelAndView("sla/variousunit")


  /**
    * 7.Closed ticket performance of various unit’s  数据接口
    *
    * @return
    */
  @ResponseBody
  @RequestMapping(value = Array("/variousunitData"), method = Array(RequestMethod.GET)) def variousunitData: VariousunitDto = {
    sLAService.variousunitData
  }


  /**
    * 8.Closed ticket performance view per region per area  页面跳转接口
    *
    * @return
    */
  @RequestMapping(value = Array("/viewperregion"), method = Array(RequestMethod.GET)) def viewperregion: ModelAndView = new ModelAndView("sla/viewperregion")


  /**
    *  8.Closed ticket performance view per region per area  数据接口
    *  仅mttr有用有用，考虑其他字段可能有用，全部返回
    * @return
    */
  @ResponseBody
  @RequestMapping(value = Array("/viewperregionData"), method = Array(RequestMethod.GET)) def viewperregionData: ViewperregionDto = {
    sLAService.viewperregionData
  }

  /**
    *  roster 页面跳转接口
    *
    * @return
    */
  @RequestMapping(value = Array("/roster"), method = Array(RequestMethod.GET)) def roster: ModelAndView = new ModelAndView("sla/roster")

  /**
    *  rosterData 页面跳转接口
    *
    * @return
    */
  @ResponseBody
  @RequestMapping(value = Array("/rosterData"), method = Array(RequestMethod.GET)) def rosterData: RosterDto = {
    sLAService.rosterData
  }



}
