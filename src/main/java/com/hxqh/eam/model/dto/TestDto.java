package com.hxqh.eam.model.dto;

import java.util.Map;

/**
 * Created by Ocean lin on 2017/8/2.
 */
public class TestDto {

    private Map<String,IocSlaPerformanceDto> fmap;

    public TestDto() {
    }

    public TestDto(Map<String, IocSlaPerformanceDto> fmap) {
        this.fmap = fmap;
    }

    public Map<String, IocSlaPerformanceDto> getFmap() {
        return fmap;
    }

    public void setFmap(Map<String, IocSlaPerformanceDto> fmap) {
        this.fmap = fmap;
    }
}
