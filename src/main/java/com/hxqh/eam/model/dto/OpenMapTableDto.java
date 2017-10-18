package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VMapOpenmaptableRighttable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/4.
 */
public class OpenMapTableDto {
    private Map<String, List<BigDecimal>> mttrM;
    private List<VMapOpenmaptableRighttable> mapOpenmaptableRighttableList;

    public OpenMapTableDto(Map<String, List<BigDecimal>> mttrM, List<VMapOpenmaptableRighttable> mapOpenmaptableRighttableList) {
        this.mttrM = mttrM;
        this.mapOpenmaptableRighttableList = mapOpenmaptableRighttableList;
    }

    public Map<String, List<BigDecimal>> getMttrM() {
        return mttrM;
    }

    public void setMttrM(Map<String, List<BigDecimal>> mttrM) {
        this.mttrM = mttrM;
    }

    public List<VMapOpenmaptableRighttable> getMapOpenmaptableRighttableList() {
        return mapOpenmaptableRighttableList;
    }

    public void setMapOpenmaptableRighttableList(List<VMapOpenmaptableRighttable> mapOpenmaptableRighttableList) {
        this.mapOpenmaptableRighttableList = mapOpenmaptableRighttableList;
    }
}
