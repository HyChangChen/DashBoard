package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_MOB_86 database table.
 */
@Entity
@Table(name = "V_MOB_86")
public class VMob86 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String ioc1;

    private Double ioc2;

    private Double ioc3;

    private Double ioc4;

    private Double ioc5;

    private Double ioc6;

    private Double ioc7;

    private Double total_site;

    private String week1;

    private String week2;


    public VMob86() {
    }

    public String getIoc1() {
        return ioc1;
    }

    public void setIoc1(String ioc1) {
        this.ioc1 = ioc1;
    }

    public Double getIoc2() {
        return ioc2;
    }

    public void setIoc2(Double ioc2) {
        this.ioc2 = ioc2;
    }

    public Double getIoc3() {
        return ioc3;
    }

    public void setIoc3(Double ioc3) {
        this.ioc3 = ioc3;
    }

    public Double getIoc4() {
        return ioc4;
    }

    public void setIoc4(Double ioc4) {
        this.ioc4 = ioc4;
    }

    public Double getIoc5() {
        return ioc5;
    }

    public void setIoc5(Double ioc5) {
        this.ioc5 = ioc5;
    }

    public Double getIoc6() {
        return ioc6;
    }

    public void setIoc6(Double ioc6) {
        this.ioc6 = ioc6;
    }

    public Double getIoc7() {
        return ioc7;
    }

    public void setIoc7(Double ioc7) {
        this.ioc7 = ioc7;
    }

    public Double getTotal_site() {
        return total_site;
    }

    public void setTotal_site(Double total_site) {
        this.total_site = total_site;
    }

    public String getWeek1() {
        return week1;
    }

    public void setWeek1(String week1) {
        this.week1 = week1;
    }

    public String getWeek2() {
        return week2;
    }

    public void setWeek2(String week2) {
        this.week2 = week2;
    }
}