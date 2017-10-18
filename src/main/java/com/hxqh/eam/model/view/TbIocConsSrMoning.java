package com.hxqh.eam.model.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the TB_IOC_CONS_SR_MONING database table.
 * 
 */
@Entity
@Table(name="V_IOC_CONS_SR_MONING")
public class TbIocConsSrMoning implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"A\"")
	private Long a;

	private Long b;

	private Long c;

	private Long d;

	private Long e;

	@Column(name="EMAIL_BACKEND")
	private String emailBackend;

	@Column(name="EMAIL_OPEN")
	private String emailOpen;

	private Long f;

	private String regional;

	private Long reopen;

	@Column(name="SMS_BACKEND")
	private String smsBackend;

	@Column(name="SMS_OPEN")
	private String smsOpen;

	@Id
	@Column(name="SR_ID")
	private Long srId;

	@Column(name="TITLE_TYPE")
	private String titleType;

	private String ts;

	private Long ttl;

	public TbIocConsSrMoning() {
	}

	public TbIocConsSrMoning(Long a, Long b, Long c, Long d, Long e, Long f, Long ttl) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.ttl = ttl;
	}

	public Long getA() {
		return this.a;
	}

	public void setA(Long a) {
		this.a = a;
	}

	public Long getB() {
		return this.b;
	}

	public void setB(Long b) {
		this.b = b;
	}

	public Long getC() {
		return this.c;
	}

	public void setC(Long c) {
		this.c = c;
	}

	public Long getD() {
		return this.d;
	}

	public void setD(Long d) {
		this.d = d;
	}

	public Long getE() {
		return this.e;
	}

	public void setE(Long e) {
		this.e = e;
	}

	public String getEmailBackend() {
		return this.emailBackend;
	}

	public void setEmailBackend(String emailBackend) {
		this.emailBackend = emailBackend;
	}

	public String getEmailOpen() {
		return this.emailOpen;
	}

	public void setEmailOpen(String emailOpen) {
		this.emailOpen = emailOpen;
	}

	public Long getF() {
		return this.f;
	}

	public void setF(Long f) {
		this.f = f;
	}

	public String getRegional() {
		return this.regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

	public Long getReopen() {
		return this.reopen;
	}

	public void setReopen(Long reopen) {
		this.reopen = reopen;
	}

	public String getSmsBackend() {
		return this.smsBackend;
	}

	public void setSmsBackend(String smsBackend) {
		this.smsBackend = smsBackend;
	}

	public String getSmsOpen() {
		return this.smsOpen;
	}

	public void setSmsOpen(String smsOpen) {
		this.smsOpen = smsOpen;
	}

	public Long getSrId() {
		return this.srId;
	}

	public void setSrId(Long srId) {
		this.srId = srId;
	}

	public String getTitleType() {
		return this.titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public Long getTtl() {
		return this.ttl;
	}

	public void setTtl(Long ttl) {
		this.ttl = ttl;
	}

}