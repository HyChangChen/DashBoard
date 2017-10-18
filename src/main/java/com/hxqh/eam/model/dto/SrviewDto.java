package com.hxqh.eam.model.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/24.
 */
public class SrviewDto {

    private String[] pilllist;

    Map<String, List<BigDecimal>> pillM;

    private String[] linelist;

    Map<String, Map<String, List<BigDecimal>>> lineM;


    public SrviewDto(String[] pilllist, Map<String, List<BigDecimal>> pillM, String[] linelist, Map<String, Map<String, List<BigDecimal>>> lineM) {
        this.pilllist = pilllist;
        this.pillM = pillM;
        this.linelist = linelist;
        this.lineM = lineM;
    }

    public String[] getPilllist() {
        return pilllist;
    }

    public void setPilllist(String[] pilllist) {
        this.pilllist = pilllist;
    }

    public Map<String, List<BigDecimal>> getPillM() {
        return pillM;
    }

    public void setPillM(Map<String, List<BigDecimal>> pillM) {
        this.pillM = pillM;
    }

    public String[] getLinelist() {
        return linelist;
    }

    public void setLinelist(String[] linelist) {
        this.linelist = linelist;
    }

    public Map<String, Map<String, List<BigDecimal>>> getLineM() {
        return lineM;
    }

    public void setLineM(Map<String, Map<String, List<BigDecimal>>> lineM) {
        this.lineM = lineM;
    }
}
