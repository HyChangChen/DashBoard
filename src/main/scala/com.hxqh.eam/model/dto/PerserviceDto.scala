package com.hxqh.eam.model.dto

import java.util

import com.hxqh.eam.model.TbIocSlaPerService

/**
  * Created by Ocean lin on 2017/8/2.
  */
class PerserviceDto(var fmap: util.Map[String, util.List[TbIocSlaPerService]]) {
  def getFmap: util.Map[String, util.List[TbIocSlaPerService]] = fmap

  def setFmap(fmap: util.Map[String, util.List[TbIocSlaPerService]]): Unit = {
    this.fmap = fmap
  }
}

