package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_IOC_SLA_TREG_PER database table.
 * 
 */
@Entity
@Table(name="TB_IOC_SLA_TREG_PER")
public class TbIocSlaTregPer implements Serializable {
	private static final long serialVersionUID = 1L;

	private String amonths;

	private BigDecimal ayears;

	@Column(name="CLOSE_TICKET")
	private BigDecimal closeTicket;

	private BigDecimal mttr;

	private String regional;

	@Id
	@Column(name="SLA_ID")
	private BigDecimal slaId;

	private String ts;

	private BigDecimal ttr;

	public TbIocSlaTregPer() {
	}

	public String getAmonths() {
		return this.amonths;
	}

	public void setAmonths(String amonths) {
		this.amonths = amonths;
	}

	public BigDecimal getAyears() {
		return this.ayears;
	}

	public void setAyears(BigDecimal ayears) {
		this.ayears = ayears;
	}

	public BigDecimal getCloseTicket() {
		return this.closeTicket;
	}

	public void setCloseTicket(BigDecimal closeTicket) {
		this.closeTicket = closeTicket;
	}

	public BigDecimal getMttr() {
		return this.mttr;
	}

	public void setMttr(BigDecimal mttr) {
		this.mttr = mttr;
	}

	public String getRegional() {
		return this.regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

	public BigDecimal getSlaId() {
		return this.slaId;
	}

	public void setSlaId(BigDecimal slaId) {
		this.slaId = slaId;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public BigDecimal getTtr() {
		return this.ttr;
	}

	public void setTtr(BigDecimal ttr) {
		this.ttr = ttr;
	}

}