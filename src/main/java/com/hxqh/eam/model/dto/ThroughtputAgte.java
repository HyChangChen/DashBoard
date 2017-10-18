package com.hxqh.eam.model.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Ocean lin on 2017/7/21.
 */
public class ThroughtputAgte {

    private List<BigDecimal> in;
    private List<BigDecimal> out;
    private List<BigDecimal> opers;
    private List<BigDecimal> wrong;
    private BigDecimal maxVal;


    public ThroughtputAgte(List<BigDecimal> in, List<BigDecimal> out, List<BigDecimal> opers, List<BigDecimal> wrong, BigDecimal maxVal) {
        this.in = in;
        this.out = out;
        this.opers = opers;
        this.wrong = wrong;
        this.maxVal = maxVal;
    }

    public BigDecimal getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(BigDecimal maxVal) {
        this.maxVal = maxVal;
    }

    public List<BigDecimal> getIn() {
        return in;
    }

    public void setIn(List<BigDecimal> in) {
        this.in = in;
    }

    public List<BigDecimal> getOut() {
        return out;
    }

    public void setOut(List<BigDecimal> out) {
        this.out = out;
    }

    public List<BigDecimal> getOpers() {
        return opers;
    }

    public void setOpers(List<BigDecimal> opers) {
        this.opers = opers;
    }

    public List<BigDecimal> getWrong() {
        return wrong;
    }

    public void setWrong(List<BigDecimal> wrong) {
        this.wrong = wrong;
    }
}
