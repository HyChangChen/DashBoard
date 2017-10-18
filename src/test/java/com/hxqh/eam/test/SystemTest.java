package com.hxqh.eam.test;

import com.hxqh.eam.common.LetterUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lh on 2017/5/5.
 */

//@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
public class SystemTest {

//    @Resource
//    private AppDao appDao;
//
//    @Resource
//    private AttributecfgDao attributecfgDao;
//
//    @Resource
//    private G03unitDao g03unitDao;
//
//    @Resource
//    private SfMyPortalTabDao sfMyPortalTabDao;
//
//    @Resource
//    private OrganizationDao organizationDao;
//
//    @Resource
//    private SfOrganizationUserLobDao sfOrganizationUserLobDao;

    @Test
    public void testGetAppDate() {
//        List<App> appDaoAll = appDao.findAll();
//        Assert.assertTrue(appDaoAll.size() > 0);
//
//        App app = appDao.find("iaet324stt9re3c81wvovuqx89t");
//        Assert.assertEquals(app.getApptype(), "app");
//        Assert.assertEquals(app.getDescription(), "Cron Task");
//
//        List<Attributecfg> attributecfgList = attributecfgDao.findAll();
//        Assert.assertTrue(attributecfgList.size() > 0);
//
//        List<G03unit> g03unitList = g03unitDao.findAll();
//        Assert.assertTrue(g03unitList.size() > 0);
//
//        List<SfMyPortalTab> sfMyPortalTabList = sfMyPortalTabDao.findAll();
//        Assert.assertTrue(sfMyPortalTabList.size() > 0);
//
//        List<Organization> organizationList = organizationDao.findAll();
//        Assert.assertTrue(organizationList.size() > 0);
//
//        List<SfOrganizationUserLob> organizationUserLobList = sfOrganizationUserLobDao.findAll();
//        Assert.assertTrue(organizationUserLobList.size() > 0);
    }

    @Test
    public void testCapture() {
        String s = "Xx";
        Assert.assertTrue("xx".equals(LetterUtil.firstLetterToLowercase(s)));
        Assert.assertTrue("x".equals(LetterUtil.firstLetterSubString(s)));
    }





}
