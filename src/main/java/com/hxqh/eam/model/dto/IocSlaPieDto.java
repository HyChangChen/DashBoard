package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.TbIocSlaPerformance;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/8/3.
 */
public class IocSlaPieDto {

    private Map<String, List<TbIocSlaPerformance>> pieMap;
    private Map<String, List<TbIocSlaPerformance>> arcMap;

    public Map<String, List<TbIocSlaPerformance>> getPieMap() {
        return pieMap;
    }

    public void setPieMap(Map<String, List<TbIocSlaPerformance>> pieMap) {
        this.pieMap = pieMap;
    }

    public Map<String, List<TbIocSlaPerformance>> getArcMap() {
        return arcMap;
    }

    public void setArcMap(Map<String, List<TbIocSlaPerformance>> arcMap) {
        this.arcMap = arcMap;
    }
}
