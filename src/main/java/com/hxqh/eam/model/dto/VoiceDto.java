package com.hxqh.eam.model.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/18.
 */
public class VoiceDto {
    private Map<String, List<BigDecimal>> seizM;
    private Map<String, List<BigDecimal>> answM;
    private List<String> nList;

    public VoiceDto() {
    }

    public VoiceDto(Map<String, List<BigDecimal>> seizM, Map<String, List<BigDecimal>> answM, List<String> nList) {
        this.seizM = seizM;
        this.answM = answM;
        this.nList = nList;
    }

    public Map<String, List<BigDecimal>> getSeizM() {
        return seizM;
    }

    public void setSeizM(Map<String, List<BigDecimal>> seizM) {
        this.seizM = seizM;
    }

    public Map<String, List<BigDecimal>> getAnswM() {
        return answM;
    }

    public void setAnswM(Map<String, List<BigDecimal>> answM) {
        this.answM = answM;
    }

    public List<String> getnList() {
        return nList;
    }

    public void setnList(List<String> nList) {
        this.nList = nList;
    }
}
