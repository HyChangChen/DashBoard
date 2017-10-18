package com.hxqh.webService.model;

/**
 * ╔           ←══╬∞           ∝╬══→           ╗
 * § File Name:  BaseAgentIp.java                             §
 * §┇File Path: com.hxqh.webService.interceptor.BaseAgentIp           §
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
public class BaseAgentIp {

    String ipAddress;
    String macAddress;
    String status;
    String secretKey;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
