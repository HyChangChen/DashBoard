package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.SfOrganizationAccount;

import java.util.List;

/**
 * Created by Ocean lin on 2017/7/4.
 */
public class AccountDto {


   private List<SfOrganizationAccount> accountList;

   private long  allUser;
   private long  normal;
   private long  onlineUser;

    public AccountDto(List<SfOrganizationAccount> accountList, long allUser, long normal, long onlineUser) {
        this.accountList = accountList;
        this.allUser = allUser;
        this.normal = normal;
        this.onlineUser = onlineUser;
    }

    public List<SfOrganizationAccount> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<SfOrganizationAccount> accountList) {
        this.accountList = accountList;
    }

    public long getAllUser() {
        return allUser;
    }

    public void setAllUser(long allUser) {
        this.allUser = allUser;
    }

    public long getNormal() {
        return normal;
    }

    public void setNormal(long normal) {
        this.normal = normal;
    }

    public long getOnlineUser() {
        return onlineUser;
    }

    public void setOnlineUser(long onlineUser) {
        this.onlineUser = onlineUser;
    }
}
