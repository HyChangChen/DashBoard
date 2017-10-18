package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_ENTERPRISE_TICKET database table.
 */
@Entity
@Table(name = "V_ENTERPRISE_TICKET")
public class VEnterpriseTicket implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigDecimal allcount;

    private BigDecimal closenums;

    private String custname;

    @Column(name = "CUSTOMER_SEGMENT")
    private String customerSegment;

    private BigDecimal opennums;

    @Column(name = "SOURCE_TYPE")
    private String sourceType;

    @Id
    private BigDecimal ticketid;

    private String ts;

    private Integer custrank;

    public VEnterpriseTicket() {
    }

    public BigDecimal getAllcount() {
        return this.allcount;
    }

    public void setAllcount(BigDecimal allcount) {
        this.allcount = allcount;
    }

    public BigDecimal getClosenums() {
        return this.closenums;
    }

    public void setClosenums(BigDecimal closenums) {
        this.closenums = closenums;
    }

    public String getCustname() {
        return this.custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustomerSegment() {
        return this.customerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
        this.customerSegment = customerSegment;
    }

    public BigDecimal getOpennums() {
        return this.opennums;
    }

    public void setOpennums(BigDecimal opennums) {
        this.opennums = opennums;
    }

    public String getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public BigDecimal getTicketid() {
        return this.ticketid;
    }

    public void setTicketid(BigDecimal ticketid) {
        this.ticketid = ticketid;
    }

    public String getTs() {
        return this.ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public Integer getCustrank() {
        return custrank;
    }

    public void setCustrank(Integer custrank) {
        this.custrank = custrank;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VEnterpriseTicket{");
        sb.append("allcount=").append(allcount);
        sb.append(", closenums=").append(closenums);
        sb.append(", custname='").append(custname).append('\'');
        sb.append(", customerSegment='").append(customerSegment).append('\'');
        sb.append(", opennums=").append(opennums);
        sb.append(", sourceType='").append(sourceType).append('\'');
        sb.append(", ticketid=").append(ticketid);
        sb.append(", ts='").append(ts).append('\'');
        sb.append(", custrank=").append(custrank);
        sb.append('}');
        return sb.toString();
    }
}