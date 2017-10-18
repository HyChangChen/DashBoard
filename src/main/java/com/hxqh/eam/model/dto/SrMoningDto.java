package com.hxqh.eam.model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ocean lin on 2017/8/3.
 */
@Entity
public class SrMoningDto {

    @Id
    private String regional;
    private Long allttl;

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public Long getAllttl() {
        return allttl;
    }

    public void setAllttl(Long allttl) {
        this.allttl = allttl;
    }
}
