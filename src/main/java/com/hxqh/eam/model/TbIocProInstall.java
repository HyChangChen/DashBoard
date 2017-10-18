package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_IOC_PRO_INSTALL database table.
 */
@Entity
@Table(name = "TB_IOC_PRO_INSTALL")
public class TbIocProInstall implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ayears;

    @Column(name = "E_MONTHS")
    private String eMonths;

    @Id
    @Column(name = "INSTALL_ID")
    private BigDecimal installId;

    @Column(name = "JML_GGN_60_HARI_ALL")
    private BigDecimal jmlGgn60HariAll;

    @Column(name = "JML_GGN_60_HARI_UNIQUE")
    private BigDecimal jmlGgn60HariUnique;

    @Column(name = "JML_PSB")
    private BigDecimal jmlPsb;

    @Column(name = "PERCENT_PLG_PSB_GGN")
    private BigDecimal percentPlgPsbGgn;

    private String treg;

    private String ts;

    public TbIocProInstall() {
    }

    public String getAyears() {
        return this.ayears;
    }

    public void setAyears(String ayears) {
        this.ayears = ayears;
    }

    public String getEMonths() {
        return this.eMonths;
    }

    public void setEMonths(String eMonths) {
        this.eMonths = eMonths;
    }

    public BigDecimal getInstallId() {
        return this.installId;
    }

    public void setInstallId(BigDecimal installId) {
        this.installId = installId;
    }

    public BigDecimal getJmlGgn60HariAll() {
        return this.jmlGgn60HariAll;
    }

    public void setJmlGgn60HariAll(BigDecimal jmlGgn60HariAll) {
        this.jmlGgn60HariAll = jmlGgn60HariAll;
    }

    public BigDecimal getJmlGgn60HariUnique() {
        return this.jmlGgn60HariUnique;
    }

    public void setJmlGgn60HariUnique(BigDecimal jmlGgn60HariUnique) {
        this.jmlGgn60HariUnique = jmlGgn60HariUnique;
    }

    public BigDecimal getJmlPsb() {
        return this.jmlPsb;
    }

    public void setJmlPsb(BigDecimal jmlPsb) {
        this.jmlPsb = jmlPsb;
    }

    public BigDecimal getPercentPlgPsbGgn() {
        return this.percentPlgPsbGgn;
    }

    public void setPercentPlgPsbGgn(BigDecimal percentPlgPsbGgn) {
        this.percentPlgPsbGgn = percentPlgPsbGgn;
    }

    public String getTreg() {
        return this.treg;
    }

    public void setTreg(String treg) {
        this.treg = treg;
    }

    public String getTs() {
        return this.ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

}