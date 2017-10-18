package com.hxqh.eam.model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ocean lin on 2017/7/13.
 */
@Entity
public class EnterprisePieDto {

    private String ctype;
    private Integer opennums;
    private Integer closenums;
    @Id
    private Integer rn;

    public EnterprisePieDto(String ctype, Integer opennums, Integer closenums, Integer rn) {
        this.ctype = ctype;
        this.opennums = opennums;
        this.closenums = closenums;
        this.rn = rn;
    }

    public EnterprisePieDto() {
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public Integer getOpennums() {
        return opennums;
    }

    public void setOpennums(Integer opennums) {
        this.opennums = opennums;
    }

    public Integer getClosenums() {
        return closenums;
    }

    public void setClosenums(Integer closenums) {
        this.closenums = closenums;
    }

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }
}
