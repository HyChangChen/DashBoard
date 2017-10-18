package com.hxqh.eam.model.dto

import java.util

/**
  * Created by Ocean lin on 2017/8/2.
  */
class VariousunitDto (var fmap: util.Map[String, IocSlaPerformanceDto]){
  def getFmap: util.Map[String, IocSlaPerformanceDto] = fmap

  def setFmap(fmap: util.Map[String, IocSlaPerformanceDto]): Unit = {
    this.fmap = fmap
  }
}
