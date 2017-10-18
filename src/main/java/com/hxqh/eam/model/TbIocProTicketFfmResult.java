package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_IOC_PRO_TICKET_FFM_RESULT database table.
 */
@Entity
@Table(name = "TB_IOC_PRO_TICKET_FFM_RESULT")
public class TbIocProTicketFfmResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private String jumlah;

    private String keterangan;

    @Id
    @Column(name = "TICKE_FFM_ID")
    private BigDecimal tickeFfmId;

    @Column(name = "TICKET_HOURRS")
    private String ticketHourrs;

    @Column(name = "TICKET_YMD")
    private String ticketYmd;

    private String ts;

    public TbIocProTicketFfmResult() {
    }

    public String getJumlah() {
        return this.jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return this.keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public BigDecimal getTickeFfmId() {
        return this.tickeFfmId;
    }

    public void setTickeFfmId(BigDecimal tickeFfmId) {
        this.tickeFfmId = tickeFfmId;
    }

    public String getTicketHourrs() {
        return this.ticketHourrs;
    }

    public void setTicketHourrs(String ticketHourrs) {
        this.ticketHourrs = ticketHourrs;
    }

    public String getTicketYmd() {
        return this.ticketYmd;
    }

    public void setTicketYmd(String ticketYmd) {
        this.ticketYmd = ticketYmd;
    }

    public String getTs() {
        return this.ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

}