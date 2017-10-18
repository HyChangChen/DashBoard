package com.hxqh.eam.common.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * ╔           ←══╬∞           ∝╬══→           ╗
 * § File Name:  HttpUtils.java                             §
 * §┇File Path: com.hxqh.eam.common.util.HttpUtils           §
 * §Descrption:                                          §
 * §Version:  V0.1                                       §
 * §Create Date:   2017/10/12                              §
 * §IDE:    IntelliJ IDEA.2017                           §
 * §Font Code:  UTF-8                                    §
 * §JDK :1.6                                             §
 * §Author: Ocean_Hy                                     §
 * §History Version Note:                                §
 * ╚           ←══╬∞           ∝╬══→           ╝
 */
public class HttpUtils {
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    public static boolean checkSign(String[] getSignStr, String signStr) {
        return true;
    }
}
