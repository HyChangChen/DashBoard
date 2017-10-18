package com.hxqh.eam.common.util

import java.util

/**
  * Created by Ocean lin on 2017/8/2.
  */
class GroupList {

  trait GroupBy[T] {
    def groupby(obj: Any): T
  }

  def group[T <: Comparable[T], D](colls: util.Collection[D], gb: GroupListUtil.GroupBy[T]): util.Map[T, util.List[D]] = {
    val map = new util.LinkedHashMap[T, util.List[D]]
    if (colls == null || colls.isEmpty) {
      println("分组集合不能为空!")
      return map
    }
    if (gb == null) {
      println("分组依赖不能为空!")
      return null
    }
    val iter = colls.iterator
    while ( {
      iter.hasNext
    }) {
      val d = iter.next
      val t = gb.groupby(d)
      if (map.containsKey(t)) map.get(t).add(d)
      else {
        val list = new util.LinkedList[D]
        list.add(d)
        map.put(t, list)
      }
    }
    map
  }
}
