package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VMapOpenmapline;
import com.hxqh.eam.model.view.VMapOpenmaplinesLinecolor;

import java.util.List;

/**
 * Created by Ocean lin on 2017/7/4.
 */
public class OpenMapLinesDto {
    private List<VMapOpenmapline> mapOpenmaplineList;

    private List<VMapOpenmaplinesLinecolor> mapOpenmaplinesLinecolorList;

    public OpenMapLinesDto(List<VMapOpenmapline> mapOpenmaplineList, List<VMapOpenmaplinesLinecolor> mapOpenmaplinesLinecolorList) {
        this.mapOpenmaplineList = mapOpenmaplineList;
        this.mapOpenmaplinesLinecolorList = mapOpenmaplinesLinecolorList;
    }

    public List<VMapOpenmapline> getMapOpenmaplineList() {
        return mapOpenmaplineList;
    }

    public void setMapOpenmaplineList(List<VMapOpenmapline> mapOpenmaplineList) {
        this.mapOpenmaplineList = mapOpenmaplineList;
    }

    public List<VMapOpenmaplinesLinecolor> getMapOpenmaplinesLinecolorList() {
        return mapOpenmaplinesLinecolorList;
    }

    public void setMapOpenmaplinesLinecolorList(List<VMapOpenmaplinesLinecolor> mapOpenmaplinesLinecolorList) {
        this.mapOpenmaplinesLinecolorList = mapOpenmaplinesLinecolorList;
    }
}
