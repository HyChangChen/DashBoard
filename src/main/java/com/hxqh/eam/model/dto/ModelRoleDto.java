package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.TbModel;

import java.util.List;

/**
 * Created by Ocean lin on 2017/8/11.
 */
public class ModelRoleDto {

    private List<TbModel> modelNoList;
    private List<TbModel> modelHaveList;

    public ModelRoleDto(List<TbModel> modelNoList, List<TbModel> modelHaveList) {
        this.modelNoList = modelNoList;
        this.modelHaveList = modelHaveList;
    }

    public List<TbModel> getModelNoList() {
        return modelNoList;
    }

    public void setModelNoList(List<TbModel> modelNoList) {
        this.modelNoList = modelNoList;
    }

    public List<TbModel> getModelHaveList() {
        return modelHaveList;
    }

    public void setModelHaveList(List<TbModel> modelHaveList) {
        this.modelHaveList = modelHaveList;
    }
}
