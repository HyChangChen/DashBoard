package com.hxqh.webService.interceptor;

/**
 * ╔           ←══╬∞           ∝╬══→           ╗
 * § File Name:  ipInterceptor.java                             §
 * §┇File Path: com.hxqh.webService.interceptor.ipInterceptor           §
 * §Descrption:    IP地址拦截器 IpAddressInInterceptor                                      §
 * §Version:  V0.1                                       §
 * §Create Date:   2017/10/12                              §
 * §IDE:    IntelliJ IDEA.2017                           §
 * §Font Code:  UTF-8                                    §
 * §JDK :1.6                                             §
 * §Author: Ocean_Hy                                     §
 * §History Version Note:                                §
 * ╚           ←══╬∞           ∝╬══→           ╝
 */


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.hxqh.eam.common.util.HttpUtils;
import com.hxqh.webService.model.BaseAgentIp;
import com.hxqh.webService.service.BaseAgentIpService;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.log4j.Logger;


class IpAddressInInterceptor extends AbstractPhaseInterceptor<Message> {

    private Logger logger = Logger.getLogger(IpAddressInInterceptor.class);

    /* 注入用于获取IP地址的service */
    @Resource(name = "baseAgentIpService")
    private BaseAgentIpService agentIpService;

    public IpAddressInInterceptor(String phase) {
        super(phase);
    }

    public IpAddressInInterceptor() {
        super(Phase.RECEIVE);
    }

    public void handleMessage(Message message) throws Fault {

        System.out.println("进入 ipInterceptor.......................");

        HttpServletRequest request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);

        List<BaseAgentIp> allowedList = agentIpService.findAll(); // 从数据库获取允许访问的IP地址

        String ipAddress = HttpUtils.getIpAddr(request); // 取客户端IP地址

        // 如果访问的集合非空，继续处理，否则认为全部IP地址均合法
        if (allowedList.size() > 0) {
            boolean contains = false;
            for (BaseAgentIp allowedIpAddress : allowedList) {
                if (allowedIpAddress.getIpAddress().equals(ipAddress)) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                throw new Fault(new IllegalAccessException("请求Ip地址错误!"));
            }
        }
    }

    @Override
    public void handleFault(Message msg) {
        Exception exeption = msg.getContent(Exception.class);
        logger.error(exeption.getMessage(), exeption);
    }

}

