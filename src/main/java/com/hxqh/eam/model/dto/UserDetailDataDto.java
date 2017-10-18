package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.SfOrganizationAccount;
import com.hxqh.eam.model.TbRole;
import com.hxqh.eam.model.UserObj;

import java.util.List;

/**
 * Created by Ocean lin on 2017/8/16.
 */
public class UserDetailDataDto {

    private UserObj account;
    private List<TbRole> roleList;

    public UserDetailDataDto() {
    }

    public UserDetailDataDto(UserObj account, List<TbRole> roleList) {
        this.account = account;
        this.roleList = roleList;
    }

    public UserObj getAccount() {
        return account;
    }

    public void setAccount(UserObj account) {
        this.account = account;
    }

    public List<TbRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<TbRole> roleList) {
        this.roleList = roleList;
    }
}
