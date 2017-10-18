/**
  * Created by Ocean lin on 2017/8/2.
  */
package com.hxqh.eam.dao

import com.hxqh.eam.common.basedao.DaoSupport
import com.hxqh.eam.model.TbIocSlaPerformance
import org.springframework.stereotype.Repository


/**
  *
  * @author lh
  *
  */
@Repository("tbIocSlaPerformanceDao")
class TbIocSlaPerformanceDaoImpl extends DaoSupport[TbIocSlaPerformance] with TbIocSlaPerformanceDao {}

