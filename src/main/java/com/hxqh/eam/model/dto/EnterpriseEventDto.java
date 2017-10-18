package com.hxqh.eam.model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ocean lin on 2017/7/13.
 */
@Entity
public class EnterpriseEventDto {
    private String affevent;
    @Id
    private Integer rn;

    public EnterpriseEventDto(String affevent, Integer rn) {
        this.affevent = affevent;
        this.rn = rn;
    }

    public EnterpriseEventDto() {
    }

    public String getAffevent() {
        return affevent;
    }

    public void setAffevent(String affevent) {
        this.affevent = affevent;
    }

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }
}

