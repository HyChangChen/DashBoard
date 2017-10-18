package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.TbIocSlaPerformance;

import java.util.List;

/**
 * Created by Ocean lin on 2017/8/3.
 */
public class IocSlaPerformanceDto {

    private TbIocSlaPerformance lefttop;

    private List<TbIocSlaPerformance> righttopList;

    private IocSlaPieDto pieDto;

    public IocSlaPerformanceDto() {
    }

    public TbIocSlaPerformance getLefttop() {
        return lefttop;
    }

    public void setLefttop(TbIocSlaPerformance lefttop) {
        this.lefttop = lefttop;
    }

    public List<TbIocSlaPerformance> getRighttopList() {
        return righttopList;
    }

    public void setRighttopList(List<TbIocSlaPerformance> righttopList) {
        this.righttopList = righttopList;
    }

    public IocSlaPieDto getPieDto() {
        return pieDto;
    }

    public void setPieDto(IocSlaPieDto pieDto) {
        this.pieDto = pieDto;
    }
}
