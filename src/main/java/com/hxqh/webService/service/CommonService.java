package com.hxqh.webService.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * ╔          ╗
 * § File Name:  CommonService.java                             §
 * §┇File Path: com.hxqh.webService.service.CommonService           §
 * §Descrption:  公用服务接口                                        §
 * §Version:  V0.1                                       §
 * §Create Date:   2017/10/12                              §
 * §IDE:    IntelliJ IDEA.2017                           §
 * §Font Code:  UTF-8                                    §
 * §JDK :1.6                                             §
 * §Author: Ocean_Hy                                     §
 * §History Version Note:                                §
 * ╚                  ╝
 */
@WebService(endpointInterface = "com.hxqh.webService.service.CommonService",
        serviceName = "commService",
        targetNamespace = "http://service.webService.hxqh.com/")
public interface CommonService {


    /**
     * 获取角色列表
     *
     * @return
     */
    @WebMethod(action = "http://service.webService.hxqh.com/getRoleList")
    String getRoleList();


    /**
     * 增加用户
     *
     * @param inPutVal
     * @return
     */
    // @WebMethod(action = "http://service.webService.hxqh.com/addUser")
    //@WebResult(name = "SendResult", targetNamespace = "http://service.webService.hxqh.com/")
    @WebMethod(action = "http://service.webService.hxqh.com/addUser")
    String addUser(@WebParam(name = "inPutVal", targetNamespace = "http://service.webService.hxqh.com/") String inPutVal);

    /**
     * 删除用户
     *
     * @param inPutVal
     * @return
     */
    @WebMethod(action = "http://service.webService.hxqh.com/delUser")
    String delUser(@WebParam(name = "inPutVal", targetNamespace = "http://service.webService.hxqh.com/") String inPutVal);

    /**
     * 修改用户
     *
     * @param inPutVal
     * @return
     */
    @WebMethod(action = "http://service.webService.hxqh.com/editUser")
    String editUser(@WebParam(name = "inPutVal", targetNamespace = "http://service.webService.hxqh.com/") String inPutVal);
    /**
     * 角色操作
     *(新增、删除、修改)
     * @param inPutVal
     * @return
     *//*
    @WebMethod
    String OptionRole(@WebParam(name = "inPutVal") String inPutVal, @WebParam(name = "optionType") int optionType);*/

    /**
     * 操作角色拥有的资源以及关联的用户
     *
     * @param inPutVal
     * @return
     */
    @WebMethod(action = "http://service.webService.hxqh.com/roleAddUser")
    String roleAddUser(@WebParam(name = "inPutVal", targetNamespace = "http://service.webService.hxqh.com/") String inPutVal);

    /**
     * 操作角色拥有的资源以及关联的用户
     *
     * @param inPutVal
     * @return
     */
    @WebMethod(action = "http://service.webService.hxqh.com/roleDelUser")
    String roleDelUser(@WebParam(name = "inPutVal", targetNamespace = "http://service.webService.hxqh.com/") String inPutVal);

    /**
     * 验证用户的完整性
     *
     * @param inPutVal
     * @return
     */
    @WebMethod(action = "http://service.webService.hxqh.com/CheckedUser")
    String validUser(@WebParam(name = "inPutVal", targetNamespace = "http://service.webService.hxqh.com/") String inPutVal);


}
