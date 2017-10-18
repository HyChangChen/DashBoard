/**
  * Created by Ocean lin on 2017/8/2.
  */

package com.hxqh.eam


import com.hxqh.eam.dao.TbIocSlaPerformanceDao
import org.junit.runner.RunWith
import org.junit.{Assert, Test}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
  * Created by Ocean lin on 2017/8/2.
  */

//@ContextConfiguration(locations = Array("classpath:spring/applicationContext.xml"))
//@RunWith(classOf[SpringJUnit4ClassRunner])
class PerformanceTest {
  @Autowired private val tbIocSlaPerformanceDao: TbIocSlaPerformanceDao = null

//  @Test def test(): Unit = {
//    Assert.assertTrue(tbIocSlaPerformanceDao.getCount > 5)
//  }
}

