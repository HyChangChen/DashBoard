package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VDig13;

import java.util.List;

/**
 * Created by Ocean Lin on 2017/6/26.
 */
public class Dig13Dto {
    private List<VDig13> vDig13List;
    private String name;

    public Dig13Dto() {
    }

    public Dig13Dto(List<VDig13> vDig13List, String name) {
        this.vDig13List = vDig13List;
        this.name = name;
    }

    public List<VDig13> getvDig13List() {
        return vDig13List;
    }

    public void setvDig13List(List<VDig13> vDig13List) {
        this.vDig13List = vDig13List;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
