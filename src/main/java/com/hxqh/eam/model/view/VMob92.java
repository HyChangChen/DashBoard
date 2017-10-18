package com.hxqh.eam.model.view;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the V_MOB_92 database table.
 */
@Entity
@Table(name = "V_MOB_92")
public class VMob92 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer rn;

    private BigDecimal greennum;

    private String treg;

    private BigDecimal orangenum;

    private BigDecimal rednum;

    private String kpitype;

    public VMob92() {
    }

    public VMob92(Integer rn, BigDecimal greennum, String treg, BigDecimal orangenum, BigDecimal rednum, String kpitype) {
        this.rn = rn;
        this.greennum = greennum;
        this.treg = treg;
        this.orangenum = orangenum;
        this.rednum = rednum;
        this.kpitype = kpitype;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }

    public BigDecimal getGreennum() {
        return greennum;
    }

    public void setGreennum(BigDecimal greennum) {
        this.greennum = greennum;
    }

    public String getTreg() {
        return treg;
    }

    public void setTreg(String treg) {
        this.treg = treg;
    }

    public BigDecimal getOrangenum() {
        return orangenum;
    }

    public void setOrangenum(BigDecimal orangenum) {
        this.orangenum = orangenum;
    }

    public BigDecimal getRednum() {
        return rednum;
    }

    public void setRednum(BigDecimal rednum) {
        this.rednum = rednum;
    }

    public String getKpitype() {
        return kpitype;
    }

    public void setKpitype(String kpitype) {
        this.kpitype = kpitype;
    }
}