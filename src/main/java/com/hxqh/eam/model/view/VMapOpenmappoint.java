package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_MAP_OPENMAPPOINTS database table.
 */
@Entity
@Table(name = "V_MAP")
public class VMapOpenmappoint implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    @Id
    private BigDecimal rn;

    @Column(name = "\"TYPE\"")
    private String type;

    private String x;

    private String y;

    private String status;

    private String treg;

    public VMapOpenmappoint() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRn() {
        return this.rn;
    }

    public void setRn(BigDecimal rn) {
        this.rn = rn;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getX() {
        return this.x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return this.y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTreg() {
        return treg;
    }

    public void setTreg(String treg) {
        this.treg = treg;
    }
}