package com.hxqh.eam.model.dto;

import java.util.List;

/**
 * Created by Ocean lin on 2017/8/11.
 */
public class UserDto {
    private List<UserRoleDto> list;

    public UserDto(List<UserRoleDto> list) {
        this.list = list;
    }

    public List<UserRoleDto> getList() {
        return list;
    }

    public void setList(List<UserRoleDto> list) {
        this.list = list;
    }
}
