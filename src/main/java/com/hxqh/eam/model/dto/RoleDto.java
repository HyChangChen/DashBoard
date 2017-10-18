package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.TbRole;

import java.util.List;

/**
 * Created by Ocean lin on 2017/7/5.
 */
public class RoleDto {
    private List<TbRole> roleList;

    public RoleDto(List<TbRole> roleList) {
        this.roleList = roleList;
    }

    public List<TbRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<TbRole> roleList) {
        this.roleList = roleList;
    }
}
