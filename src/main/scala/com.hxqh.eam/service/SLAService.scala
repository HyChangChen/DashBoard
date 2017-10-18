package com.hxqh.eam.service

import com.hxqh.eam.model.dto._

/**
  * Created by Ocean lin on 2017/8/2.
  */


trait SLAService {

  def variousunitData: VariousunitDto

  def viewperregionData: ViewperregionDto

  def perserviceData: PerserviceDto

  def internalData: InternalDto

  def rosterData: RosterDto


}

