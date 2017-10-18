package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.TbModel;

import java.util.List;
import java.util.Set;

/**
 * Created by Ocean lin on 2017/8/23.
 */
public class ModelIndexDto {

    private List<TbModel> modelList;

    public ModelIndexDto(List<TbModel> modelList) {
        this.modelList = modelList;
    }

    public List<TbModel> getModelList() {
        return modelList;
    }

    public void setModelList(List<TbModel> modelList) {
        this.modelList = modelList;
    }
}
