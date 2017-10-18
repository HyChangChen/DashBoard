package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.TbIocProIndihome;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/20.
 */
public class Per7xData {

   private Map<String, List<TbIocProIndihome>> stringListMap;

    public Per7xData(Map<String, List<TbIocProIndihome>> stringListMap) {
        this.stringListMap = stringListMap;
    }

    public Map<String, List<TbIocProIndihome>> getStringListMap() {
        return stringListMap;
    }

    public void setStringListMap(Map<String, List<TbIocProIndihome>> stringListMap) {
        this.stringListMap = stringListMap;
    }
}
