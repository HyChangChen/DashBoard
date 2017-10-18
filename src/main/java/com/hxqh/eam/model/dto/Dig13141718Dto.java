package com.hxqh.eam.model.dto;

/**
 * Created by Ocean Lin on 2017/6/26.
 */
public class Dig13141718Dto {
    private Dig13Dto dig13Dto;
    private Dig14Dto dig14Dto;
    private Dig17Dto dig17Dto;
    private Dig18Dto dig18Dto;

    public Dig13141718Dto(Dig13Dto dig13Dto, Dig14Dto dig14Dto, Dig17Dto dig17Dto, Dig18Dto dig18Dto) {
        this.dig13Dto = dig13Dto;
        this.dig14Dto = dig14Dto;
        this.dig17Dto = dig17Dto;
        this.dig18Dto = dig18Dto;
    }

    public Dig13141718Dto() {
    }

    public Dig13Dto getDig13Dto() {
        return dig13Dto;
    }

    public void setDig13Dto(Dig13Dto dig13Dto) {
        this.dig13Dto = dig13Dto;
    }

    public Dig14Dto getDig14Dto() {
        return dig14Dto;
    }

    public void setDig14Dto(Dig14Dto dig14Dto) {
        this.dig14Dto = dig14Dto;
    }

    public Dig17Dto getDig17Dto() {
        return dig17Dto;
    }

    public void setDig17Dto(Dig17Dto dig17Dto) {
        this.dig17Dto = dig17Dto;
    }

    public Dig18Dto getDig18Dto() {
        return dig18Dto;
    }

    public void setDig18Dto(Dig18Dto dig18Dto) {
        this.dig18Dto = dig18Dto;
    }
}
