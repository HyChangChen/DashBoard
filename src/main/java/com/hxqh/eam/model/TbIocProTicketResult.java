package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_IOC_PRO_TICKET_RESULT database table.
 */
@Entity
@Table(name = "TB_IOC_PRO_TICKET_RESULT")
public class TbIocProTicketResult implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "CHART_TYPE")
    private String chartType;

    private String jumlah;

    private String keterangan;

    @Column(name = "TICKE_TYPE")
    private String tickeType;

    @Id
    @Column(name = "TICKET_ID")
    private BigDecimal ticketId;

    @Column(name = "TICKET_STATUS")
    private String ticketStatus;

    private String ts;

    @Column(name = "X_VALUE")
    private String xValue;

    public TbIocProTicketResult() {
    }

    public String getChartType() {
        return this.chartType;
    }

    public void setChartType(String chartType) {
        this.chartType = chartType;
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

    public String getTickeType() {
        return this.tickeType;
    }

    public void setTickeType(String tickeType) {
        this.tickeType = tickeType;
    }

    public BigDecimal getTicketId() {
        return this.ticketId;
    }

    public void setTicketId(BigDecimal ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketStatus() {
        return this.ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getTs() {
        return this.ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getXValue() {
        return this.xValue;
    }

    public void setXValue(String xValue) {
        this.xValue = xValue;
    }

}