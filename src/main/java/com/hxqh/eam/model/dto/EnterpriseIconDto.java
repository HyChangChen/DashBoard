package com.hxqh.eam.model.dto;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ocean lin on 2017/7/13.
 */
@Entity
public class EnterpriseIconDto {

    @Id
    private String lay;
    private String status;

    public EnterpriseIconDto() {
    }

    public EnterpriseIconDto(String lay, String status) {
        this.lay = lay;
        this.status = status;
    }

    public String getLay() {
        return lay;
    }

    public void setLay(String lay) {
        this.lay = lay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}



