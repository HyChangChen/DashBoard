package com.hxqh.eam.model.sqlquery;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Ocean lin on 2017/7/12.
 */
@Entity
public class EnterpriseKTK implements Serializable {
    @Id
    private Integer rn;
    private String mon;
    private String regional;
    private Integer countval;

    private Integer eid;

    public EnterpriseKTK() {
    }


    public EnterpriseKTK(Integer rn, String mon, String regional, Integer countval) {
        this.rn = rn;
        this.mon = mon;
        this.regional = regional;
        this.countval = countval;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public Integer getCountval() {
        return countval;
    }

    public void setCountval(Integer countval) {
        this.countval = countval;
    }
}
