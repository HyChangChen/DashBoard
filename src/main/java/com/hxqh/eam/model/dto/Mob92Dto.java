package com.hxqh.eam.model.dto;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ocean lin on 2017/7/7.
 */
public class Mob92Dto {

    private List<BigDecimal> green;
    private List<BigDecimal> orange;
    private List<BigDecimal> red;

    private List<Double> greenPercent;
    private List<Double> orangePercent;
    private List<Double> redPercent;


    public Mob92Dto(List<BigDecimal> green, List<BigDecimal> orange, List<BigDecimal> red, List<Double> greenPercent, List<Double> orangePercent, List<Double> redPercent) {
        this.green = green;
        this.orange = orange;
        this.red = red;
        this.greenPercent = greenPercent;
        this.orangePercent = orangePercent;
        this.redPercent = redPercent;
    }

    public List<BigDecimal> getGreen() {
        return green;
    }

    public void setGreen(List<BigDecimal> green) {
        this.green = green;
    }

    public List<BigDecimal> getOrange() {
        return orange;
    }

    public void setOrange(List<BigDecimal> orange) {
        this.orange = orange;
    }

    public List<BigDecimal> getRed() {
        return red;
    }

    public void setRed(List<BigDecimal> red) {
        this.red = red;
    }

    public List<Double> getGreenPercent() {
        return greenPercent;
    }

    public void setGreenPercent(List<Double> greenPercent) {
        this.greenPercent = greenPercent;
    }

    public List<Double> getOrangePercent() {
        return orangePercent;
    }

    public void setOrangePercent(List<Double> orangePercent) {
        this.orangePercent = orangePercent;
    }

    public List<Double> getRedPercent() {
        return redPercent;
    }

    public void setRedPercent(List<Double> redPercent) {
        this.redPercent = redPercent;
    }
}
