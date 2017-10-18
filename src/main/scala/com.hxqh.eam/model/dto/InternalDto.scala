package com.hxqh.eam.model.dto

import java.util

import com.hxqh.eam.model.TbIocSlaNitsSource

/**
  * Created by Ocean lin on 2017/8/2.
  */
class InternalDto (var listMap: util.List[TbIocSlaNitsSource]){
  def getListMap:util.List[TbIocSlaNitsSource] = listMap

  def setListMap(listMap: util.List[TbIocSlaNitsSource]): Unit = {
    this.listMap = listMap
  }

}
