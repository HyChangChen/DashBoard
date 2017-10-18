package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_IOC_SLA_PER_SERVICE database table.
 * 
 */
@Entity
@Table(name="TB_IOC_SLA_PER_SERVICE")
public class TbIocSlaPerService implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal apr;

	private BigDecimal aug;

	private String ayear;

	private BigDecimal decp;

	private BigDecimal feb;

	private BigDecimal jan;

	private BigDecimal jul;

	private BigDecimal jun;

	private BigDecimal mar;

	private BigDecimal may;

	private BigDecimal nov;

	private BigDecimal oct;

	private String pengguna;

	private BigDecimal sep;

	@Id
	@Column(name="SLA_PER_ID")
	private BigDecimal slaPerId;

	private String ts;

	public TbIocSlaPerService() {
	}

	public BigDecimal getApr() {
		return this.apr;
	}

	public void setApr(BigDecimal apr) {
		this.apr = apr;
	}

	public BigDecimal getAug() {
		return this.aug;
	}

	public void setAug(BigDecimal aug) {
		this.aug = aug;
	}

	public String getAyear() {
		return this.ayear;
	}

	public void setAyear(String ayear) {
		this.ayear = ayear;
	}

	public BigDecimal getDecp() {
		return this.decp;
	}

	public void setDecp(BigDecimal decp) {
		this.decp = decp;
	}

	public BigDecimal getFeb() {
		return this.feb;
	}

	public void setFeb(BigDecimal feb) {
		this.feb = feb;
	}

	public BigDecimal getJan() {
		return this.jan;
	}

	public void setJan(BigDecimal jan) {
		this.jan = jan;
	}

	public BigDecimal getJul() {
		return this.jul;
	}

	public void setJul(BigDecimal jul) {
		this.jul = jul;
	}

	public BigDecimal getJun() {
		return this.jun;
	}

	public void setJun(BigDecimal jun) {
		this.jun = jun;
	}

	public BigDecimal getMar() {
		return this.mar;
	}

	public void setMar(BigDecimal mar) {
		this.mar = mar;
	}

	public BigDecimal getMay() {
		return this.may;
	}

	public void setMay(BigDecimal may) {
		this.may = may;
	}

	public BigDecimal getNov() {
		return this.nov;
	}

	public void setNov(BigDecimal nov) {
		this.nov = nov;
	}

	public BigDecimal getOct() {
		return this.oct;
	}

	public void setOct(BigDecimal oct) {
		this.oct = oct;
	}

	public String getPengguna() {
		return this.pengguna;
	}

	public void setPengguna(String pengguna) {
		this.pengguna = pengguna;
	}

	public BigDecimal getSep() {
		return this.sep;
	}

	public void setSep(BigDecimal sep) {
		this.sep = sep;
	}

	public BigDecimal getSlaPerId() {
		return this.slaPerId;
	}

	public void setSlaPerId(BigDecimal slaPerId) {
		this.slaPerId = slaPerId;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

}