package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_IOC_CONS_SRVIEW database table.
 * 
 */
@Entity
@Table(name="TB_IOC_CONS_SRVIEW")
public class TbIocConsSrview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CHARS_TYPE")
	private String charsType;

	@Column(name="LEV_COUNT")
	private BigDecimal levCount;

	private String regional;

	@Column(name="SERVICE_TYPE")
	private String serviceType;

	@Id
	@Column(name="SRVIEW_ID")
	private BigDecimal srviewId;

	@Column(name="TIMES_LEV")
	private String timesLev;

	private String ts;

	public TbIocConsSrview() {
	}

	public String getCharsType() {
		return this.charsType;
	}

	public void setCharsType(String charsType) {
		this.charsType = charsType;
	}

	public BigDecimal getLevCount() {
		return this.levCount;
	}

	public void setLevCount(BigDecimal levCount) {
		this.levCount = levCount;
	}

	public String getRegional() {
		return this.regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

	public String getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public BigDecimal getSrviewId() {
		return this.srviewId;
	}

	public void setSrviewId(BigDecimal srviewId) {
		this.srviewId = srviewId;
	}

	public String getTimesLev() {
		return this.timesLev;
	}

	public void setTimesLev(String timesLev) {
		this.timesLev = timesLev;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

}