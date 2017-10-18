package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_IOC_PRO_MONTHLY database table.
 * 
 */
@Entity
@Table(name="TB_IOC_PRO_MONTHLY")
public class TbIocProMonthly implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="JML_ALL")
	private BigDecimal jmlAll;

	@Id
	@Column(name="MONTHLY_ID")
	private BigDecimal monthlyId;

	private BigDecimal mtt;

	private String mtti;

	private String regional;

	private String ts;

	private String tt;

	public TbIocProMonthly() {
	}

	public BigDecimal getJmlAll() {
		return this.jmlAll;
	}

	public void setJmlAll(BigDecimal jmlAll) {
		this.jmlAll = jmlAll;
	}

	public BigDecimal getMonthlyId() {
		return this.monthlyId;
	}

	public void setMonthlyId(BigDecimal monthlyId) {
		this.monthlyId = monthlyId;
	}

	public BigDecimal getMtt() {
		return this.mtt;
	}

	public void setMtt(BigDecimal mtt) {
		this.mtt = mtt;
	}

	public String getMtti() {
		return this.mtti;
	}

	public void setMtti(String mtti) {
		this.mtti = mtti;
	}

	public String getRegional() {
		return this.regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getTt() {
		return this.tt;
	}

	public void setTt(String tt) {
		this.tt = tt;
	}

}