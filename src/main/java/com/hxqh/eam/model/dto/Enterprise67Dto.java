package com.hxqh.eam.model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Ocean lin on 2017/7/13.
 */
@Entity
public class Enterprise67Dto {

    private String treg;

    private String dh;

    private Double personsum;

    @Id
    private BigDecimal regionrn;

    public Enterprise67Dto() {
    }


    public BigDecimal getRegionrn() {
        return regionrn;
    }

    public void setRegionrn(BigDecimal regionrn) {
        this.regionrn = regionrn;
    }

    public String getTreg() {
        return treg;
    }

    public void setTreg(String treg) {
        this.treg = treg;
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }


    public Double getPersonsum() {
        return personsum;
    }

    public void setPersonsum(Double personsum) {
        this.personsum = personsum;
    }
}
