package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TB_IOC_TEAM_ROSTER database table.
 * 
 */
@Entity
@Table(name="TB_IOC_TEAM_ROSTER")
public class TbIocTeamRoster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="DUTY_TIME")
	private String dutyTime;

	private String nama;

	private String perner;

	@Id
	@Column(name="ROSTER_ID")
	private BigDecimal rosterId;

	private String status;

	@Temporal(TemporalType.DATE)
	private Date tanggal;

	private String ts;

	private String unit;

	public TbIocTeamRoster() {
	}

	public String getDutyTime() {
		return this.dutyTime;
	}

	public void setDutyTime(String dutyTime) {
		this.dutyTime = dutyTime;
	}

	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getPerner() {
		return this.perner;
	}

	public void setPerner(String perner) {
		this.perner = perner;
	}

	public BigDecimal getRosterId() {
		return this.rosterId;
	}

	public void setRosterId(BigDecimal rosterId) {
		this.rosterId = rosterId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTanggal() {
		return this.tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}