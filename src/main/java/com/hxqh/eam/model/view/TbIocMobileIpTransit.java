package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_IOC_MOBILE_IP_TRANSIT database table.
 * 
 */
@Entity
@Table(name="V_IOC_MOBILE_IP_TRANSIT")
public class TbIocMobileIpTransit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TRANSIT_ID")
	private long transitId;

	private String agte;

	@Column(name="DATA_TIMES")
	private String dataTimes;

	private BigDecimal opers;

	@Column(name="SUM_IN")
	private BigDecimal sumIn;

	@Column(name="SUM_OUT")
	private BigDecimal sumOut;

	private String ts;

	private BigDecimal wrong;

	public TbIocMobileIpTransit() {
	}

	public long getTransitId() {
		return this.transitId;
	}

	public void setTransitId(long transitId) {
		this.transitId = transitId;
	}

	public String getAgte() {
		return this.agte;
	}

	public void setAgte(String agte) {
		this.agte = agte;
	}

	public String getDataTimes() {
		return this.dataTimes;
	}

	public void setDataTimes(String dataTimes) {
		this.dataTimes = dataTimes;
	}

	public BigDecimal getOpers() {
		return this.opers;
	}

	public void setOpers(BigDecimal opers) {
		this.opers = opers;
	}

	public BigDecimal getSumIn() {
		return this.sumIn;
	}

	public void setSumIn(BigDecimal sumIn) {
		this.sumIn = sumIn;
	}

	public BigDecimal getSumOut() {
		return this.sumOut;
	}

	public void setSumOut(BigDecimal sumOut) {
		this.sumOut = sumOut;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public BigDecimal getWrong() {
		return this.wrong;
	}

	public void setWrong(BigDecimal wrong) {
		this.wrong = wrong;
	}

}