package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_MOB_87 database table.
 */
@Entity
@Table(name = "V_MOB_87")
public class VMob87 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer rn;

    private String name;

    private String otherfull;

    private String regional;

    @Column(name = "\"VALUE\"")
    private BigDecimal value;

    public VMob87() {
    }

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtherfull() {
        return this.otherfull;
    }

    public void setOtherfull(String otherfull) {
        this.otherfull = otherfull;
    }

    public String getRegional() {
        return this.regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

}