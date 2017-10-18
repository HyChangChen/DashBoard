package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VDig18;

import java.util.List;

/**
 * Created by Ocean Lin on 2017/6/26.
 */
public class Dig18Dto {
    private List<VDig18> dig18List;
    private String name;

    public Dig18Dto() {
    }

    public Dig18Dto(List<VDig18> dig18List, String name) {
        this.dig18List = dig18List;
        this.name = name;
    }

    public List<VDig18> getDig18List() {
        return dig18List;
    }

    public void setDig18List(List<VDig18> dig18List) {
        this.dig18List = dig18List;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
