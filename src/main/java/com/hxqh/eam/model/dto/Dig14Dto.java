package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VDig14;

import java.util.List;

/**
 * Created by Ocean Lin on 2017/6/26.
 */
public class Dig14Dto {
    private List<VDig14> dig14List;
    private String name;

    public Dig14Dto() {
    }

    public Dig14Dto(List<VDig14> dig14List, String name) {
        this.dig14List = dig14List;
        this.name = name;
    }

    public List<VDig14> getDig14List() {
        return dig14List;
    }

    public void setDig14List(List<VDig14> dig14List) {
        this.dig14List = dig14List;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
