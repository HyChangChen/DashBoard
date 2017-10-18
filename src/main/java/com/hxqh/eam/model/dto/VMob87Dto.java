package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VMob87;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/6/30.
 */
public class VMob87Dto {

   private Map<String, List<VMob87>> map;

    public VMob87Dto(Map<String, List<VMob87>> map) {
        this.map = map;
    }

    public Map<String, List<VMob87>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<VMob87>> map) {
        this.map = map;
    }
}
