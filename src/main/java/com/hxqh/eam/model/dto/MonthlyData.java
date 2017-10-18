package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.TbIocProMonthly;

import java.util.List;

/**
 * Created by Ocean lin on 2017/7/20.
 */
public class MonthlyData {

   private List<TbIocProMonthly> iocProMonthlyList;

    public MonthlyData(List<TbIocProMonthly> iocProMonthlyList) {
        this.iocProMonthlyList = iocProMonthlyList;
    }

    public List<TbIocProMonthly> getIocProMonthlyList() {
        return iocProMonthlyList;
    }

    public void setIocProMonthlyList(List<TbIocProMonthly> iocProMonthlyList) {
        this.iocProMonthlyList = iocProMonthlyList;
    }
}
