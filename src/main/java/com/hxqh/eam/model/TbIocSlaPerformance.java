package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_IOC_SLA_PERFORMANCE database table.
 */
@Entity
@Table(name = "V_IOC_SLA_PERFORMANCE")
public class TbIocSlaPerformance implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "CLOSE_YEARS")
    private BigDecimal closeYears;

    @Column(name = "COLSE_MTTR_LEFT")
    private BigDecimal colseMttrLeft;

    @Column(name = "CUST_TYPE")
    private String custType;

    private String ctype;

    @Column(name = "OPEN_MTTR_LEFT")
    private BigDecimal openMttrLeft;

    @Column(name = "PIE_LABEL")
    private String pieLabel;

    @Column(name = "R_MTT")
    private BigDecimal rMtt;

    @Column(name = "SEGMENT_TYPE")
    private String segmentType;

    @Id
    @Column(name = "SLA_ID")
    private BigDecimal slaId;

    @Column(name = "SLA_TYPE")
    private String slaType;

    @Column(name = "T_STANDARD")
    private String tStandard;

    @Column(name = "TICKET_NUMS")
    private BigDecimal ticketNums;

    @Column(name = "TICKET_STATUS")
    private BigDecimal ticketStatus;

    private String ts;

    public TbIocSlaPerformance() {
    }

    public BigDecimal getCloseYears() {
        return closeYears;
    }

    public void setCloseYears(BigDecimal closeYears) {
        this.closeYears = closeYears;
    }

    public BigDecimal getColseMttrLeft() {
        return colseMttrLeft;
    }

    public void setColseMttrLeft(BigDecimal colseMttrLeft) {
        this.colseMttrLeft = colseMttrLeft;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public BigDecimal getOpenMttrLeft() {
        return openMttrLeft;
    }

    public void setOpenMttrLeft(BigDecimal openMttrLeft) {
        this.openMttrLeft = openMttrLeft;
    }

    public String getPieLabel() {
        return pieLabel;
    }

    public void setPieLabel(String pieLabel) {
        this.pieLabel = pieLabel;
    }

    public BigDecimal getrMtt() {
        return rMtt;
    }

    public void setrMtt(BigDecimal rMtt) {
        this.rMtt = rMtt;
    }

    public String getSegmentType() {
        return segmentType;
    }

    public void setSegmentType(String segmentType) {
        this.segmentType = segmentType;
    }

    public BigDecimal getSlaId() {
        return slaId;
    }

    public void setSlaId(BigDecimal slaId) {
        this.slaId = slaId;
    }

    public String getSlaType() {
        return slaType;
    }

    public void setSlaType(String slaType) {
        this.slaType = slaType;
    }

    public String gettStandard() {
        return tStandard;
    }

    public void settStandard(String tStandard) {
        this.tStandard = tStandard;
    }

    public BigDecimal getTicketNums() {
        return ticketNums;
    }

    public void setTicketNums(BigDecimal ticketNums) {
        this.ticketNums = ticketNums;
    }

    public BigDecimal getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(BigDecimal ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }
}