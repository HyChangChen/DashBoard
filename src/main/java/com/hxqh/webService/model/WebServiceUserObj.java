package com.hxqh.webService.model;

import com.hxqh.eam.model.UserObj;

/**
 * ╔           ←══╬∞           ∝╬══→           ╗
 * § File Name:  WebServiceUserObj.java                             §
 * §┇File Path: com.hxqh.webService.model.WebServiceUserObj           §
 * §Descrption:   接口对象                                       §
 * §Version:  V0.1                                       §
 * §Create Date:   2017/10/16                              §
 * §IDE:    IntelliJ IDEA.2017                           §
 * §Font Code:  UTF-8                                    §
 * §JDK :1.6                                             §
 * §Author: Ocean_Hy                                     §
 * §History Version Note:                                §
 * ╚           ←══╬∞           ∝╬══→           ╝
 */
public class WebServiceUserObj {


    private String userCode;//	用户编码
    private String name;//	姓名
    private String sex;//	性别
    private String orgId;//	组织机构ID
    private String orgName;//	组织机构名称
    private String phoneNumber;//		手机号
    private String leaderCode;//	上级用户的用户编码
    private String leaderPhoneNumber;//		上级用户的手机号
    private String leaderName;//		上级用户的姓名
    private String passWord;//密码
    private String roleID;//角色ID
    private String stopFlag;//状态


    /**
     * 将接口推送的数据转换为大屏平台的用户对象
     *
     * @param webServiceUserObj
     * @return
     */
    public UserObj webUserObj2UseObj(WebServiceUserObj webServiceUserObj) {
        UserObj u = new UserObj();
        u.setLoginpassword(webServiceUserObj.getPassWord());
        u.setSourceuserid(webServiceUserObj.getUserCode());
        u.setSex(webServiceUserObj.getSex());
        u.setDepartment(webServiceUserObj.getOrgName());
        u.setLoginname(webServiceUserObj.getPhoneNumber());
        u.setRoleid(webServiceUserObj.getRoleID());
        if (null != webServiceUserObj.getStopFlag()) {
            u.setUserstatus(Integer.parseInt(webServiceUserObj.getStopFlag()));
        } else {
            u.setUserstatus(1);
        }

        return u;
    }

    @Override
    public String toString() {
        return "WebServiceUserObj{" +
                "userCode='" + userCode + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", leaderCode='" + leaderCode + '\'' +
                ", leaderPhoneNumber='" + leaderPhoneNumber + '\'' +
                ", leaderName='" + leaderName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", roleID='" + roleID + '\'' +
                ", stopFlag='" + stopFlag + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebServiceUserObj that = (WebServiceUserObj) o;

        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (orgId != null ? !orgId.equals(that.orgId) : that.orgId != null) return false;
        if (orgName != null ? !orgName.equals(that.orgName) : that.orgName != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (leaderCode != null ? !leaderCode.equals(that.leaderCode) : that.leaderCode != null) return false;
        if (leaderPhoneNumber != null ? !leaderPhoneNumber.equals(that.leaderPhoneNumber) : that.leaderPhoneNumber != null)
            return false;
        if (leaderName != null ? !leaderName.equals(that.leaderName) : that.leaderName != null) return false;
        if (passWord != null ? !passWord.equals(that.passWord) : that.passWord != null) return false;
        if (roleID != null ? !roleID.equals(that.roleID) : that.roleID != null) return false;
        return stopFlag != null ? stopFlag.equals(that.stopFlag) : that.stopFlag == null;
    }

    @Override
    public int hashCode() {
        int result = userCode != null ? userCode.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (orgId != null ? orgId.hashCode() : 0);
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (leaderCode != null ? leaderCode.hashCode() : 0);
        result = 31 * result + (leaderPhoneNumber != null ? leaderPhoneNumber.hashCode() : 0);
        result = 31 * result + (leaderName != null ? leaderName.hashCode() : 0);
        result = 31 * result + (passWord != null ? passWord.hashCode() : 0);
        result = 31 * result + (roleID != null ? roleID.hashCode() : 0);
        result = 31 * result + (stopFlag != null ? stopFlag.hashCode() : 0);
        return result;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLeaderCode() {
        return leaderCode;
    }

    public void setLeaderCode(String leaderCode) {
        this.leaderCode = leaderCode;
    }

    public String getLeaderPhoneNumber() {
        return leaderPhoneNumber;
    }

    public void setLeaderPhoneNumber(String leaderPhoneNumber) {
        this.leaderPhoneNumber = leaderPhoneNumber;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }


}























