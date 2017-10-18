package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VMob86;

import java.util.List;

/**
 * Created by Ocean lin on 2017/7/16.
 */
public class Mob86Dto {
    private List<VMob86> vMob86List;
    private String week1;
    private String week2;

    public Mob86Dto() {
    }

    public Mob86Dto(List<VMob86> vMob86List, String week1, String week2) {
        this.vMob86List = vMob86List;
        this.week1 = week1;
        this.week2 = week2;
    }

    public List<VMob86> getvMob86List() {
        return vMob86List;
    }

    public void setvMob86List(List<VMob86> vMob86List) {
        this.vMob86List = vMob86List;
    }

    public String getWeek1() {
        return week1;
    }

    public void setWeek1(String week1) {
        this.week1 = week1;
    }

    public String getWeek2() {
        return week2;
    }

    public void setWeek2(String week2) {
        this.week2 = week2;
    }
}
