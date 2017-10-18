package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_IOC_MOBILE_PERFOR database table.
 * 
 */
@Entity
@Table(name="TB_IOC_MOBILE_PERFOR")
public class TbIocMobilePerfor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PERFOR_ID")
	private BigDecimal perforId;

	private String psr;

	@Column(name="PSR_BAD")
	private BigDecimal psrBad;

	@Column(name="PSR_GOOD")
	private BigDecimal psrGood;

	private String sr;

	@Column(name="SR_BAD")
	private BigDecimal srBad;

	@Column(name="SR_GOOD")
	private BigDecimal srGood;

	private String treg;

	private String ts;

	public TbIocMobilePerfor() {
	}

	public BigDecimal getPerforId() {
		return this.perforId;
	}

	public void setPerforId(BigDecimal perforId) {
		this.perforId = perforId;
	}

	public String getPsr() {
		return this.psr;
	}

	public void setPsr(String psr) {
		this.psr = psr;
	}

	public BigDecimal getPsrBad() {
		return this.psrBad;
	}

	public void setPsrBad(BigDecimal psrBad) {
		this.psrBad = psrBad;
	}

	public BigDecimal getPsrGood() {
		return this.psrGood;
	}

	public void setPsrGood(BigDecimal psrGood) {
		this.psrGood = psrGood;
	}

	public String getSr() {
		return this.sr;
	}

	public void setSr(String sr) {
		this.sr = sr;
	}

	public BigDecimal getSrBad() {
		return this.srBad;
	}

	public void setSrBad(BigDecimal srBad) {
		this.srBad = srBad;
	}

	public BigDecimal getSrGood() {
		return this.srGood;
	}

	public void setSrGood(BigDecimal srGood) {
		this.srGood = srGood;
	}

	public String getTreg() {
		return this.treg;
	}

	public void setTreg(String treg) {
		this.treg = treg;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

}