package com.hxqh.eam.security;

import com.hxqh.eam.model.dto.AccountDto;
import com.hxqh.eam.dao.MenuDao;
import com.hxqh.eam.dao.SfOrganizationAccountDao;
import com.hxqh.eam.dao.SfOrganizationDepartmentDao;
import com.hxqh.eam.model.Menu;
import com.hxqh.eam.model.SfOrganizationDepartment;
import com.hxqh.eam.service.SystemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Ocean lin on 2017/7/4.
 */
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SecurityTest {


    @Autowired
    private SystemService systemService;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private SfOrganizationAccountDao accountDao;
    @Autowired
    private SfOrganizationDepartmentDao sfOrganizationDepartmentDao;

    @Test
    public void testGetList() {
        List<Menu> listData = systemService.getMenuListData();
        Assert.assertTrue(listData.size() > 0);
    }


    @Test
    public void testDepartmentList() {
        List<SfOrganizationDepartment> departments = sfOrganizationDepartmentDao.findAll();
        Assert.assertTrue(departments.size() > 0);
    }
//    //修改
//    @Test
//    public void testUpdate() throws Exception {
//        Menu menu = menuDao.find("f18fdb84a4be439d979d21b4b7400820");
//        Assert.assertNotNull(menu);
//        menu.setPosition("Test lh");
//        systemService.editMenu(menu);
//    }

//    //修改
//    @Test
//    public void testUserUpdate() throws Exception {
//        SfOrganizationAccount account = accountDao.find("e2188d20e39848b1aaf58b0c7ef2a858");
//        Assert.assertNotNull(account);
//        account.setAccountmark(new BigDecimal(0));
//        accountDao.update(account);
//    }

//    增加
//    @Test
//    public void testUserAdd() throws Exception {
//        Menu menu = new Menu();
//        menu.setMenuid(UUID.randomUUID().toString().substring(0,32));
//        menu.setAccesskey("lh Test");
//        menu.setPosition("Test lh");
//        systemService.addMenu(menu);
//    }

    //增加
//    @Test
//    public void testUserAdd() throws Exception {
//        SfOrganizationAccount account = new SfOrganizationAccount();
//        account.setId(UUID.randomUUID().toString().substring(0, 32));
//        account.setAccountmark(new BigDecimal(0));
//        account.setPassword("XXXXXXXX");
//        account.setStatus(new BigDecimal(0));
//        account.setLogin(new BigDecimal(0));
//        account.setLogintimes(new BigDecimal(0));
//        account.setOnlinemillis(new BigDecimal(0));
//        account.setMailbinding(new BigDecimal(0));
//        account.setMobilebinding(new BigDecimal(0));
//
//        systemService.addUser(account);
//    }

//删除
//    @Test
//    public void testDel() throws Exception {
//        systemService.delMenu("ca48ccfa-9bea-47");
//    }

    //删除
//    @Test
//    public void testUserDel() throws Exception {
//        systemService.delUser("9fd2c805-26ef-43b4-8ebd-010d00b1");
//    }


}
