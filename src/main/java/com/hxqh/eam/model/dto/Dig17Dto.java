package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VDig17;

import java.util.List;

/**
 * Created by Ocean Lin on 2017/6/26.
 */
public class Dig17Dto {
    private List<VDig17> dig17List;
    private String name;

    public Dig17Dto() {
    }

    public Dig17Dto(List<VDig17> dig17List, String name) {
        this.dig17List = dig17List;
        this.name = name;
    }

    public List<VDig17> getDig17List() {
        return dig17List;
    }

    public void setDig17List(List<VDig17> dig17List) {
        this.dig17List = dig17List;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
