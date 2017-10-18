package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VMob91;

import java.util.List;

/**
 * Created by Ocean lin on 2017/6/29.
 */
public class Mob91Dto {
   private List<VMob91> mob91LeftList;
   private List<VMob91> mob9RightList;

    public Mob91Dto(List<VMob91> mob91LeftList, List<VMob91> mob9RightList) {
        this.mob91LeftList = mob91LeftList;
        this.mob9RightList = mob9RightList;
    }

    public List<VMob91> getMob91LeftList() {
        return mob91LeftList;
    }

    public void setMob91LeftList(List<VMob91> mob91LeftList) {
        this.mob91LeftList = mob91LeftList;
    }

    public List<VMob91> getMob9RightList() {
        return mob9RightList;
    }

    public void setMob9RightList(List<VMob91> mob9RightList) {
        this.mob9RightList = mob9RightList;
    }
}
