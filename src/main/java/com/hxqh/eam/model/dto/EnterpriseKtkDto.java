package com.hxqh.eam.model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ocean lin on 2017/7/13.
 */
@Entity
public class EnterpriseKtkDto {

    private String mon;
    private String etype;
    private Integer enternum;
    @Id
    private Integer rn;

    public EnterpriseKtkDto(String mon, String etype, Integer enternum, Integer rn) {
        this.mon = mon;
        this.etype = etype;
        this.enternum = enternum;
        this.rn = rn;
    }

    public EnterpriseKtkDto() {
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getEtype() {
        return etype;
    }

    public void setEtype(String etype) {
        this.etype = etype;
    }

    public Integer getEnternum() {
        return enternum;
    }

    public void setEnternum(Integer enternum) {
        this.enternum = enternum;
    }

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }
}
