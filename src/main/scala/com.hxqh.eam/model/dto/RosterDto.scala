package com.hxqh.eam.model.dto

import java.util

import com.hxqh.eam.model.TbIocTeamRoster

/**
  * Created by Ocean lin on 2017/8/4.
  */
class RosterDto (var fmap: util.Map[String, util.List[TbIocTeamRoster]]){
  def getFmap: util.Map[String, util.List[TbIocTeamRoster]] = fmap

  def setFmap(fmap: util.Map[String, util.List[TbIocTeamRoster]]): Unit = {
    this.fmap = fmap
  }
}
