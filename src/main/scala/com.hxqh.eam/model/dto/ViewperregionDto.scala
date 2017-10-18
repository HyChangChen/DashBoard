package com.hxqh.eam.model.dto

import java.util

import com.hxqh.eam.model.TbIocSlaTregPer

/**
  * Created by Ocean lin on 2017/8/4.
  */
class ViewperregionDto(var fmap: util.Map[String, util.List[TbIocSlaTregPer]]) {
  def getFmap: util.Map[String, util.List[TbIocSlaTregPer]] = fmap

  def setFmap(fmap: util.Map[String, util.List[TbIocSlaTregPer]]): Unit = {
    this.fmap = fmap
  }
}
