package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_HOME_TOTAL database table.
 */
@Entity
@Table(name = "V_HOME_TOTAL")
public class VHomeTotal implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String regional;

    @Column(name = "TO_CL")
    private BigDecimal cl;

    @Column(name = "TO_DEV")
    private BigDecimal dev;

    @Column(name = "TO_OP")
    private BigDecimal op;

    @Column(name = "TO_SH")
    private BigDecimal sh;

    @Column(name = "TO_SH_1")
    private BigDecimal sh1;

    public VHomeTotal() {
    }

    public String getRegional() {
        return this.regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public BigDecimal getCl() {
        return cl;
    }

    public void setCl(BigDecimal cl) {
        this.cl = cl;
    }

    public BigDecimal getDev() {
        return dev;
    }

    public void setDev(BigDecimal dev) {
        this.dev = dev;
    }

    public BigDecimal getOp() {
        return op;
    }

    public void setOp(BigDecimal op) {
        this.op = op;
    }

    public BigDecimal getSh() {
        return sh;
    }

    public void setSh(BigDecimal sh) {
        this.sh = sh;
    }

    public BigDecimal getSh1() {
        return sh1;
    }

    public void setSh1(BigDecimal sh1) {
        this.sh1 = sh1;
    }
}