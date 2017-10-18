package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_HOME_IMPACT database table.
 */
@Entity
@Table(name = "V_HOME_IMPACT")
public class VHomeImpact implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "IM_CL")
    private BigDecimal cl;

    @Column(name = "IM_OP")
    private BigDecimal op;

    @Column(name = "IM_SH")
    private BigDecimal sh;

    @Column(name = "IM_SH_1")
    private BigDecimal sh1;

    @Column(name = "IMDEV")
    private BigDecimal dev;

    @Id
    private String regional;

    public VHomeImpact() {
    }

    public BigDecimal getCl() {
        return cl;
    }

    public void setCl(BigDecimal cl) {
        this.cl = cl;
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

    public BigDecimal getDev() {
        return dev;
    }

    public void setDev(BigDecimal dev) {
        this.dev = dev;
    }

    public String getRegional() {
        return this.regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

}