package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SF_LOG_PV_STAT database table.
 * 
 */
@Entity
@Table(name="SF_LOG_PV_STAT")
public class SfLogPvStat implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal averagetime;

	@Id
	private String id;

	private BigDecimal ip;

	private BigDecimal lday;

	private BigDecimal lhour;

	private BigDecimal lmonth;

	private BigDecimal lyear;

	private BigDecimal maxtime;

	private BigDecimal mintime;

	private BigDecimal pv;

	private BigDecimal uv;

	public SfLogPvStat() {
	}

	public BigDecimal getAveragetime() {
		return this.averagetime;
	}

	public void setAveragetime(BigDecimal averagetime) {
		this.averagetime = averagetime;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getIp() {
		return this.ip;
	}

	public void setIp(BigDecimal ip) {
		this.ip = ip;
	}

	public BigDecimal getLday() {
		return this.lday;
	}

	public void setLday(BigDecimal lday) {
		this.lday = lday;
	}

	public BigDecimal getLhour() {
		return this.lhour;
	}

	public void setLhour(BigDecimal lhour) {
		this.lhour = lhour;
	}

	public BigDecimal getLmonth() {
		return this.lmonth;
	}

	public void setLmonth(BigDecimal lmonth) {
		this.lmonth = lmonth;
	}

	public BigDecimal getLyear() {
		return this.lyear;
	}

	public void setLyear(BigDecimal lyear) {
		this.lyear = lyear;
	}

	public BigDecimal getMaxtime() {
		return this.maxtime;
	}

	public void setMaxtime(BigDecimal maxtime) {
		this.maxtime = maxtime;
	}

	public BigDecimal getMintime() {
		return this.mintime;
	}

	public void setMintime(BigDecimal mintime) {
		this.mintime = mintime;
	}

	public BigDecimal getPv() {
		return this.pv;
	}

	public void setPv(BigDecimal pv) {
		this.pv = pv;
	}

	public BigDecimal getUv() {
		return this.uv;
	}

	public void setUv(BigDecimal uv) {
		this.uv = uv;
	}

}