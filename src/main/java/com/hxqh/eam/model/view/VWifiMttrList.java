package com.hxqh.eam.model.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the V_WIFI_MTTR database table.
 */
@Entity
@Table(name = "v_wifi_mttr_list")
public class VWifiMttrList implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    private Integer rn;

    private String ioc1;
    private String ioc2;
    private String ioc3;
    private String ioc4;
    private String ioc5;
    private String ioc6;


    public VWifiMttrList() {
    }

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }

    public String getIoc1() {
        return ioc1;
    }

    public void setIoc1(String ioc1) {
        this.ioc1 = ioc1;
    }

    public String getIoc2() {
        return ioc2;
    }

    public void setIoc2(String ioc2) {
        this.ioc2 = ioc2;
    }

    public String getIoc3() {
        return ioc3;
    }

    public void setIoc3(String ioc3) {
        this.ioc3 = ioc3;
    }

    public String getIoc4() {
        return ioc4;
    }

    public void setIoc4(String ioc4) {
        this.ioc4 = ioc4;
    }

    public String getIoc5() {
        return ioc5;
    }

    public void setIoc5(String ioc5) {
        this.ioc5 = ioc5;
    }

    public String getIoc6() {
        return ioc6;
    }

    public void setIoc6(String ioc6) {
        this.ioc6 = ioc6;
    }
}