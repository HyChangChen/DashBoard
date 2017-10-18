package com.hxqh.eam.model.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/6/29.
 */
public class TrafficTdo {
    private List<String> topNameList;
    private List<String> bottomNameList;

    private Map<String, List<BigDecimal>> topMap;

    Map<String, List<BigDecimal>> bottomMap;

    public TrafficTdo() {
    }

    public TrafficTdo(List<String> topNameList, List<String> bottomNameList, Map<String, List<BigDecimal>> topMap, Map<String, List<BigDecimal>> bottomMap) {
        this.topNameList = topNameList;
        this.bottomNameList = bottomNameList;
        this.topMap = topMap;
        this.bottomMap = bottomMap;
    }

    public List<String> getTopNameList() {
        return topNameList;
    }

    public void setTopNameList(List<String> topNameList) {
        this.topNameList = topNameList;
    }

    public List<String> getBottomNameList() {
        return bottomNameList;
    }

    public void setBottomNameList(List<String> bottomNameList) {
        this.bottomNameList = bottomNameList;
    }

    public Map<String, List<BigDecimal>> getTopMap() {
        return topMap;
    }

    public void setTopMap(Map<String, List<BigDecimal>> topMap) {
        this.topMap = topMap;
    }

    public Map<String, List<BigDecimal>> getBottomMap() {
        return bottomMap;
    }

    public void setBottomMap(Map<String, List<BigDecimal>> bottomMap) {
        this.bottomMap = bottomMap;
    }
}
