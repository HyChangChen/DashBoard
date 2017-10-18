package com.hxqh.eam.model.dto;

import javax.persistence.Id;

/**
 * Created by Ocean lin on 2017/8/22.
 */
public class SrTmpDto {

    @Id
    private String regional;

    private Integer smsbackend;

    private Integer emailopen;

    private Integer smsopen;

    private Integer emailbackend;

    private Integer reopen;

    public SrTmpDto() {
    }

    public SrTmpDto(Integer smsbackend, Integer emailopen, Integer smsopen, Integer emailbackend, Integer reopen) {
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

    public Integer getSmsbackend() {
        return smsbackend;
    }

    public void setSmsbackend(Integer smsbackend) {
        this.smsbackend = smsbackend;
    }

    public Integer getEmailopen() {
        return emailopen;
    }

    public void setEmailopen(Integer emailopen) {
        this.emailopen = emailopen;
    }

    public Integer getSmsopen() {
        return smsopen;
    }

    public void setSmsopen(Integer smsopen) {
        this.smsopen = smsopen;
    }

    public Integer getEmailbackend() {
        return emailbackend;
    }

    public void setEmailbackend(Integer emailbackend) {
        this.emailbackend = emailbackend;
    }

    public Integer getReopen() {
        return reopen;
    }

    public void setReopen(Integer reopen) {
        this.reopen = reopen;
    }
}
