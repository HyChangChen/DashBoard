package com.hxqh.webService.service.imp;

import com.google.gson.JsonParser;
import com.hxqh.eam.common.util.JsonUtil;
import com.hxqh.eam.model.Menu;
import com.hxqh.eam.model.TbRole;
import com.hxqh.eam.model.UserObj;
import com.hxqh.eam.model.dto.UserDto;
import com.hxqh.eam.service.SystemService;
import com.hxqh.webService.model.RetrunVal;
import com.hxqh.webService.model.RoleSource;
import com.hxqh.webService.model.WebServiceUserObj;
import com.hxqh.webService.model.WsRole;
import com.hxqh.webService.service.CommonService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * ╔           ←══╬∞           ∝╬══→           ╗
 * § File Name:  CommonServiceImp.java                             §
 * §┇File Path: com.hxqh.webService.service.imp.CommonServiceImp           §
 * §Descrption:     实现接口                                     §
 * §Version:  V0.1                                       §
 * §Create Date:   2017/10/12                              §
 * §IDE:    IntelliJ IDEA.2017                           §
 * §Font Code:  UTF-8                                    §
 * §JDK :1.6                                             §
 * §Author: Ocean_Hy                                     §
 * §History Version Note:                                §
 * ╚           ←══╬∞           ∝╬══→           ╝
 */
@Repository
@Transactional
@WebService
public class CommonServiceImp implements CommonService {
    @Autowired
    private SystemService systemService;


    /**
     * 获取角色列表
     *
     * @return
     */
    @Override
    public String getRoleList() {
        List<TbRole> roleDto = systemService.getRoleListData();
        List<WsRole> roleList = new ArrayList<>();
        for (TbRole e : roleDto) {
            WsRole wsRole = new WsRole();
            wsRole.setRoleId(e.getRoleid().toString());
            wsRole.setRoleName(e.getRolename() + "/" + e.getRoledesc());
            roleList.add(wsRole);
        }
        String jsonVal = JsonUtil.list2Json(roleList);
        System.out.println("jsonVal" + jsonVal);
        return jsonVal;
    }

    /**
     * 增加用户
     *
     * @param inPutVal
     * @return
     */
    @Override
    public String addUser(String inPutVal) {
        return OptionWebserviceData(inPutVal, 1);
    }

    /**
     * 删除用户
     *
     * @param inPutVal
     * @return
     */
    @Override
    public String delUser(String inPutVal) {
        return OptionWebserviceData(inPutVal, 3);
    }

    /**
     * 修改用户
     *
     * @param inPutVal
     * @return
     */
    @Override
    public String editUser(String inPutVal) {
        return OptionWebserviceData(inPutVal, 2);
    }

    /**
     * 操作角色拥有的资源以及关联的用户
     *
     * @param inPutVal
     * @return
     */
    @Override
    public String roleAddUser(String inPutVal) {
        return OptionWebserviceData(inPutVal, 4);
    }

    /**
     * 操作角色拥有的资源以及关联的用户
     *
     * @param inPutVal
     * @return
     */
    @Override
    public String roleDelUser(String inPutVal) {
        return OptionWebserviceData(inPutVal, 5);
    }

    /**
     * 验证用户的完整性
     *
     * @param inPutVal
     * @return
     */
    @Override
    public String validUser(String inPutVal) {
        return OptionWebserviceData(inPutVal, 6);
    }


    /**
     * 获得返回值为Json
     *
     * @param retrunVal
     * @return
     */
    public static String getReturnJsonVal(RetrunVal retrunVal) {
        return JsonUtil.object2Json(retrunVal);
    }

    /**
     * 校验输入的数据是否正确
     *
     * @return
     */
    public static boolean ValidInputVal(String inPutVal) {
        boolean validStatus = false;
        if (StringUtils.isBlank("") && StringUtils.isEmpty("")
                && StringUtils.isEmpty(null) && StringUtils.isEmpty(null)) {
            inPutVal = inPutVal.replaceAll(" ", "");
            Boolean json = new JsonParser().parse(inPutVal).isJsonArray();
            validStatus = json;
        }
        return validStatus;
    }


    /**
     * 操作用户（修改）
     *
     * @param inPutVal
     * @param optionType 1:新增用户 2 修改用户 3 删除用户，4 角色关联用户 5：角色删除用户
     * @return
     */
    public String OptionWebserviceData(String inPutVal, int optionType) {
        RetrunVal retrunVal = new RetrunVal();
        inPutVal = "[" + inPutVal + "]";
        boolean valid = ValidInputVal(inPutVal);
        if (valid) {
            List<WebServiceUserObj> webServiceUserObjs = JsonUtil.json2List(inPutVal, WebServiceUserObj.class);
            if (webServiceUserObjs.size() > 0) {
                List<UserObj> userObjList = new ArrayList<>();
                List<RoleSource> tbRoleList = new ArrayList<>();
                WebServiceUserObj wsu = new WebServiceUserObj();
                for (WebServiceUserObj webServiceUserObj : webServiceUserObjs) {
                    UserObj u = wsu.webUserObj2UseObj(webServiceUserObj);
                    userObjList.add(u);
                    RoleSource rs = new RoleSource();
                    rs.setRoleId(webServiceUserObj.getRoleID());
                    rs.setSourceId(webServiceUserObj.getUserCode());
                    tbRoleList.add(rs);
                }
                switch (optionType) {
                    case 1:
                        retrunVal = systemService.addUser(userObjList);
                        break;
                    case 2:
                        retrunVal = systemService.editUser(userObjList);
                        break;
                    case 3:
                        retrunVal = systemService.delUser(userObjList);
                        break;
                    case 4:
                        retrunVal = systemService.addRoleSource(tbRoleList);
                        break;
                    case 5:
                        retrunVal = systemService.delRoleSource(tbRoleList);
                        break;
                    case 6:
                        retrunVal = systemService.validUser(userObjList);
                        break;
                    default:
                        retrunVal.setReturnMess("操作标识未知，请联系管理员!");
                        retrunVal.setReturnCode(0);
                        break;
                }
            } else {
                retrunVal.setReturnMess("解析出错，请联系管理员!");
                retrunVal.setReturnCode(0);
            }
        } else {
            retrunVal.setReturnMess("参数不合格，请重新输入!");
            retrunVal.setReturnCode(0);
        }
        return getReturnJsonVal(retrunVal);
    }

    /**
     * 获取资源列表
     *
     * @return
     */
    public String getResouleList() {
        List<Menu> menuList = systemService.getMenuListData();
        String jsonVal = JsonUtil.list2Json(menuList);
        return jsonVal;
    }


}
