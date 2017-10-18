package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_IOC_PRO_INDIHOME database table.
 */
@Entity
@Table(name = "TB_IOC_PRO_INDIHOME")
public class TbIocProIndihome implements Serializable {
    private static final long serialVersionUID = 1L;

    private String app;

    @Column(name = "GRAND_TOTAL")
    private BigDecimal grandTotal;

    @Id
    @Column(name = "INDIHOME_ID")
    private BigDecimal indihomeId;

    private BigDecimal myindihome;

    @Column(name = "NOT_PS_DONE")
    private BigDecimal notPsDone;

    private BigDecimal other;

    @Column(name = "PS_DONE")
    private BigDecimal psDone;

    private String regional;

    @Column(name = "STATUS_IN")
    private String statusIn;

    @Column(name = "TREG_NUM")
    private String tregNum;

    private String ts;

    public TbIocProIndihome() {
    }

    public String getApp() {
        return this.app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public BigDecimal getGrandTotal() {
        return this.grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    public BigDecimal getIndihomeId() {
        return this.indihomeId;
    }

    public void setIndihomeId(BigDecimal indihomeId) {
        this.indihomeId = indihomeId;
    }

    public BigDecimal getMyindihome() {
        return this.myindihome;
    }

    public void setMyindihome(BigDecimal myindihome) {
        this.myindihome = myindihome;
    }

    public BigDecimal getNotPsDone() {
        return this.notPsDone;
    }

    public void setNotPsDone(BigDecimal notPsDone) {
        this.notPsDone = notPsDone;
    }

    public BigDecimal getOther() {
        return this.other;
    }

    public void setOther(BigDecimal other) {
        this.other = other;
    }

    public BigDecimal getPsDone() {
        return this.psDone;
    }

    public void setPsDone(BigDecimal psDone) {
        this.psDone = psDone;
    }

    public String getRegional() {
        return this.regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getStatusIn() {
        return this.statusIn;
    }

    public void setStatusIn(String statusIn) {
        this.statusIn = statusIn;
    }

    public String getTregNum() {
        return this.tregNum;
    }

    public void setTregNum(String tregNum) {
        this.tregNum = tregNum;
    }

    public String getTs() {
        return this.ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

}