package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_ENTERPRISE_TICKET_TKT database table.
 */
@Entity
@Table(name = "V_ENTERPRISE_TICKET_TKT")
public class VEnterpriseTicketTkt implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigDecimal countval;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "CUSTOMER_SEGMENT")
    private String customerSegment;

    private Integer custrank;

    private String mon;

    private String regional;

    @Column(name = "SOURCE_TYPE")
    private String sourcetype;

    private String status;

    @Id
    @Column(name = "TICKET_TKT_ID")
    private BigDecimal ticketTktId;

    private String ts;

    public VEnterpriseTicketTkt() {
    }

    public BigDecimal getCountval() {
        return this.countval;
    }

    public void setCountval(BigDecimal countval) {
        this.countval = countval;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSegment() {
        return this.customerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
        this.customerSegment = customerSegment;
    }

    public Integer getCustrank() {
        return custrank;
    }

    public void setCustrank(Integer custrank) {
        this.custrank = custrank;
    }

    public String getMon() {
        return this.mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getRegional() {
        return this.regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getSourcetype() {
        return this.sourcetype;
    }

    public void setSourcetype(String sourcetype) {
        this.sourcetype = sourcetype;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTicketTktId() {
        return this.ticketTktId;
    }

    public void setTicketTktId(BigDecimal ticketTktId) {
        this.ticketTktId = ticketTktId;
    }

    public String getTs() {
        return this.ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

}