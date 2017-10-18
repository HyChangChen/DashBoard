package com.hxqh.eam.service

import java.util

import com.hxqh.eam.common.util.GroupListUtil
import com.hxqh.eam.dao._
import com.hxqh.eam.model.dto._
import com.hxqh.eam.model.{TbIocSlaPerService, TbIocSlaPerformance, TbIocSlaTregPer, TbIocTeamRoster}
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.collection.JavaConversions._


/**
  * Created by Ocean lin on 2017/8/2.
  */
@Service("sLAService") class SLAServiceImpl extends SLAService {

  private[service] val logger = Logger.getLogger(classOf[SLAServiceImpl])

  @Autowired private val tbIocSlaPerformanceDao: TbIocSlaPerformanceDao = null
  @Autowired private val iocSlaPerServiceDao: IocSlaPerServiceDao = null
  @Autowired private val iocSlaTregPerDao: IocSlaTregPerDao = null
  @Autowired private val iocSlaNitsSourceDao: IocSlaNitsSourceDao = null
  @Autowired private val iocTeamRosterDao: IocTeamRosterDao = null

  override def variousunitData: VariousunitDto = {
    val performanceList = tbIocSlaPerformanceDao.findAll
    val stringListMap = GroupListUtil.group(performanceList, new GroupListUtil.GroupBy[String]() {
      override def groupby(obj: Any): String = {
        val d = obj.asInstanceOf[TbIocSlaPerformance]
        d.getCtype // 分组依据为Ctype

      }
    })

    val finalMap = new util.HashMap[String, IocSlaPerformanceDto]

    //遍历Map取出数据
    for (map <- stringListMap.entrySet) {
      val dto = new IocSlaPerformanceDto
      val pieDto = new IocSlaPieDto
      val list = new util.ArrayList[TbIocSlaPerformance]
      val l = new util.ArrayList[TbIocSlaPerformance]
      val na = new util.ArrayList[TbIocSlaPerformance]
      for (slaPerformance <- map.getValue) { //左上数据准备
        //t.SEGMENT_TYPE = 'DES' and t.SLA_TYPE='MAIN';
        if (slaPerformance.getSegmentType == map.getKey && slaPerformance.getSlaType == "MAIN") dto.setLefttop(slaPerformance)
        //右上数据
        //t.SLA_TYPE='MAINPIE';
        if (slaPerformance.getSlaType == "MAINPIE") list.add(slaPerformance)
        //下侧三个饼图
        //t.SLA_TYPE='SUB' and t.CUST_TYPE='DES'
        if (slaPerformance.getCustType != null && slaPerformance.getCustType == map.getKey)
          if (slaPerformance.getSlaType == "SUB") {
            na.add(slaPerformance)
          }
          else if (slaPerformance.getSlaType == "SUBPIE")
            l.add(slaPerformance)
      }
      dto.setRighttopList(list)

      val pieMap = GroupListUtil.group(l, new GroupListUtil.GroupBy[String]() {
        override def groupby(obj: Any): String = {
          val d = obj.asInstanceOf[TbIocSlaPerformance]
          d.getSegmentType // 分组依据为SegmentType
        }
      })

      val arcMap = GroupListUtil.group(na, new GroupListUtil.GroupBy[String]() {
        override def groupby(obj: Any): String = {
          val d = obj.asInstanceOf[TbIocSlaPerformance]
          d.getSegmentType // 分组依据为SegmentType
        }
      })

      pieDto.setPieMap(pieMap)
      pieDto.setArcMap(arcMap)
      dto.setPieDto(pieDto)
      finalMap.put(map.getKey, dto)
    }
    new VariousunitDto(finalMap)
  }

  override def viewperregionData: ViewperregionDto = {
    val orderby = new util.LinkedHashMap[String, String]
    orderby.put("slaId", "asc")

    val iocSlaTregList = iocSlaTregPerDao.findAll(null, null, orderby);
    val stringListMap = GroupListUtil.group(iocSlaTregList, new GroupListUtil.GroupBy[String]() {
      override def groupby(obj: Any): String = {
        val d = obj.asInstanceOf[TbIocSlaTregPer]
        d.getAmonths // 分组依据为Amonths
      }
    })
    new ViewperregionDto(stringListMap)
  }

  override def perserviceData: PerserviceDto = {
    val perServiceList = iocSlaPerServiceDao.findAll()
    val stringListMap = GroupListUtil.group(perServiceList, new GroupListUtil.GroupBy[String]() {
      override def groupby(obj: Any): String = {
        val d = obj.asInstanceOf[TbIocSlaPerService]
        d.getPengguna // 分组依据为Pengguna
      }
    })
    new PerserviceDto(stringListMap)
  }


  override def internalData: InternalDto = {
    val orderby = new util.LinkedHashMap[String, String]
    orderby.put("sourceId", "asc")
    val internalList = iocSlaNitsSourceDao.findAll(null,null,orderby)
    new InternalDto(internalList)
  }


  override def rosterData: RosterDto = {
    val iocTeamList = iocTeamRosterDao.findAll("dutyTime is not null",null,null)
    val fMap = GroupListUtil.group(iocTeamList, new GroupListUtil.GroupBy[String]() {
      override def groupby(obj: Any): String = {
        val d = obj.asInstanceOf[TbIocTeamRoster]
        d.getUnit // 分组依据为Unit
      }
    })
    new RosterDto(fMap)
  }
}





