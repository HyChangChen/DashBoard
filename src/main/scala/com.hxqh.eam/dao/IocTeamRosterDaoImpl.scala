package com.hxqh.eam.dao

import com.hxqh.eam.common.basedao.DaoSupport
import com.hxqh.eam.model.TbIocTeamRoster
import org.springframework.stereotype.Repository

/**
  * Created by Ocean lin on 2017/8/4.
  */
@Repository("iocTeamRosterDao")
class IocTeamRosterDaoImpl extends DaoSupport[TbIocTeamRoster] with  IocTeamRosterDao{

}
