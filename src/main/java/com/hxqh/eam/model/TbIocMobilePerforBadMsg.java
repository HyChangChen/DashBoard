package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_IOC_MOBILE_PERFOR_BAD_MSG database table.
 * 
 */
@Entity
@Table(name="TB_IOC_MOBILE_PERFOR_BAD_MSG")
public class TbIocMobilePerforBadMsg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ACCOUNT_PSR")
	private BigDecimal accountPsr;

	@Column(name="ACCOUNT_SR_PSR")
	private BigDecimal accountSrPsr;

	@Column(name="DATA_TIMES")
	private String dataTimes;

	@Id
	@Column(name="MSG_ID")
	private BigDecimal msgId;

	private String node;

	@Column(name="PERFOR_TYPE")
	private String perforType;

	@Column(name="REGION_NAME")
	private String regionName;

	private String ts;

	@Column(name="TSEL_REGION")
	private String tselRegion;

	public TbIocMobilePerforBadMsg() {
	}

	public BigDecimal getAccountPsr() {
		return this.accountPsr;
	}

	public void setAccountPsr(BigDecimal accountPsr) {
		this.accountPsr = accountPsr;
	}

	public BigDecimal getAccountSrPsr() {
		return this.accountSrPsr;
	}

	public void setAccountSrPsr(BigDecimal accountSrPsr) {
		this.accountSrPsr = accountSrPsr;
	}

	public String getDataTimes() {
		return this.dataTimes;
	}

	public void setDataTimes(String dataTimes) {
		this.dataTimes = dataTimes;
	}

	public BigDecimal getMsgId() {
		return this.msgId;
	}

	public void setMsgId(BigDecimal msgId) {
		this.msgId = msgId;
	}

	public String getNode() {
		return this.node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getPerforType() {
		return this.perforType;
	}

	public void setPerforType(String perforType) {
		this.perforType = perforType;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getTselRegion() {
		return this.tselRegion;
	}

	public void setTselRegion(String tselRegion) {
		this.tselRegion = tselRegion;
	}

}