package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.TbModel;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/8/11.
 */
public class ModelDto {
    private Map<Integer, List<TbModel>> listMap;

    public ModelDto(Map<Integer, List<TbModel>> listMap) {
        this.listMap = listMap;
    }

    public Map<Integer, List<TbModel>> getListMap() {
        return listMap;
    }

    public void setListMap(Map<Integer, List<TbModel>> listMap) {
        this.listMap = listMap;
    }
}
