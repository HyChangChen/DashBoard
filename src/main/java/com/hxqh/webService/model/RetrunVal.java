package com.hxqh.webService.model;

/**
 * ╔           ←══╬∞           ∝╬══→           ╗
 * § File Name:  RetrunVal.java                             §
 * §┇File Path: com.hxqh.webService.model.RetrunVal           §
 * §Descrption:     接口返回消息对象                                  §
 * §Version:  V0.1                                       §
 * §Create Date:   2017/10/13                              §
 * §IDE:    IntelliJ IDEA.2017                           §
 * §Font Code:  UTF-8                                    §
 * §JDK :1.6                                             §
 * §Author: Ocean_Hy                                     §
 * §History Version Note:                                §
 * ╚           ←══╬∞           ∝╬══→           ╝
 */
public class RetrunVal {


    private String returnMess;
    private int returnCode;


    public String getReturnMess() {
        return returnMess;
    }

    public void setReturnMess(String returnMess) {
        this.returnMess = returnMess;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }
}
