package com.hxqh.eam.model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ocean lin on 2017/7/13.
 */
@Entity
public class EnterpriseThreeColor {

    @Id
    private Integer colorid;

    private String cust;
    private Integer gt;
    private Integer eq;
    private Integer lt;

    public EnterpriseThreeColor() {
    }

    public EnterpriseThreeColor(String cust, Integer gt, Integer eq, Integer lt) {
        this.cust = cust;
        this.gt = gt;
        this.eq = eq;
        this.lt = lt;
    }

    public Integer getColorid() {
        return colorid;
    }

    public void setColorid(Integer colorid) {
        this.colorid = colorid;
    }

    public String getCust() {
        return cust;
    }

    public void setCust(String cust) {
        this.cust = cust;
    }

    public Integer getGt() {
        return gt;
    }

    public void setGt(Integer gt) {
        this.gt = gt;
    }

    public Integer getEq() {
        return eq;
    }

    public void setEq(Integer eq) {
        this.eq = eq;
    }

    public Integer getLt() {
        return lt;
    }

    public void setLt(Integer lt) {
        this.lt = lt;
    }
}
