package com.hxqh.eam.model.dto;

import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/16.
 */
public class Moblie92 {

    private Map<String,Mob92Dto> dtoMap;

    public Moblie92(Map<String, Mob92Dto> dtoMap) {
        this.dtoMap = dtoMap;
    }

    public Map<String, Mob92Dto> getDtoMap() {
        return dtoMap;
    }

    public void setDtoMap(Map<String, Mob92Dto> dtoMap) {
        this.dtoMap = dtoMap;
    }
}
