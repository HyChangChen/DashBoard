package com.hxqh.eam.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;


/**
 * The persistent class for the TB_IOC_MOBILE_BACKHAUL_TTC database table.
 */
@Entity
@Table(name = "TB_IOC_MOBILE_BACKHAUL_TTC")
public class TbIocMobileBackhaulTtc implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @SequenceGenerator(name = "TB_IOC_MOBILE_BACKHAUL_TTC_TTCID_GENERATOR", sequenceName = "SEQ_TB_IOC_MOBILE_BACKHAUL_TTC")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_IOC_MOBILE_BACKHAUL_TTC_TTCID_GENERATOR")
    @Column(name = "TTC_ID")
    private BigDecimal ttcId;

    @Column(name = "COLOR_TYPE")
    private BigDecimal colorType;

    private String msg;

    @Column(name = "PARENT_ID")
    private BigDecimal parentId;

    private String title;

    private String ts;

    private Integer catagory;

    private Integer deptdepth;




    public TbIocMobileBackhaulTtc() {
    }

    public BigDecimal getTtcId() {
        return ttcId;
    }

    public void setTtcId(BigDecimal ttcId) {
        this.ttcId = ttcId;
    }

    public BigDecimal getColorType() {
        return this.colorType;
    }

    public void setColorType(BigDecimal colorType) {
        this.colorType = colorType;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BigDecimal getParentId() {
        return this.parentId;
    }

    public void setParentId(BigDecimal parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTs() {
        return this.ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public Integer getCatagory() {
        return catagory;
    }

    public void setCatagory(Integer catagory) {
        this.catagory = catagory;
    }

    public Integer getDeptdepth() {
        return deptdepth;
    }

    public void setDeptdepth(Integer deptdepth) {
        this.deptdepth = deptdepth;
    }
}