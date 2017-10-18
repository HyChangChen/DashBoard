package com.hxqh.eam.model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ocean lin on 2017/8/3.
 */
@Entity
public class SrDto {

    @Id
    private String regional;

    private String smsbackend;

    private String emailopen;

    private String smsopen;

    private String  emailbackend;

    private Integer reopen;

    public SrDto() {
    }

    public SrDto(String smsbackend, String emailopen, String smsopen, String emailbackend, Integer reopen) {
        this.smsbackend = smsbackend;
        this.emailopen = emailopen;
        this.smsopen = smsopen;
        this.emailbackend = emailbackend;
        this.reopen = reopen;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getSmsbackend() {
        return smsbackend;
    }

    public void setSmsbackend(String smsbackend) {
        this.smsbackend = smsbackend;
    }

    public String getEmailopen() {
        return emailopen;
    }

    public void setEmailopen(String emailopen) {
        this.emailopen = emailopen;
    }

    public String getSmsopen() {
        return smsopen;
    }

    public void setSmsopen(String smsopen) {
        this.smsopen = smsopen;
    }

    public String getEmailbackend() {
        return emailbackend;
    }

    public void setEmailbackend(String emailbackend) {
        this.emailbackend = emailbackend;
    }

    public Integer getReopen() {
        return reopen;
    }

    public void setReopen(Integer reopen) {
        this.reopen = reopen;
    }
}
