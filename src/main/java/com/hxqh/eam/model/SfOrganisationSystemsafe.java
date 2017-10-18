package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SF_ORGANISATION_SYSTEMSAFE database table.
 * 
 */
@Entity
@Table(name="SF_ORGANISATION_SYSTEMSAFE")
public class SfOrganisationSystemsafe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SF_ORGANISATION_SYSTEMSAFE_ID_GENERATOR", sequenceName="SF_ORGANISATION_SYSTEMSAFE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SF_ORGANISATION_SYSTEMSAFE_ID_GENERATOR")
	private String id;

	private String amfromnum;

	private String amfromsystem;

	private String ammessage;

	private String amtitle;

	@Column(name="CMEMAIL_FROM")
	private String cmemailFrom;

	@Column(name="CMEMAIL_HOST")
	private String cmemailHost;

	@Column(name="CMEMAIL_PASSWORD")
	private String cmemailPassword;

	@Column(name="CMEMAIL_PORT")
	private String cmemailPort;

	@Column(name="CMEMAIL_SSL")
	private String cmemailSsl;

	@Column(name="CMEMAIL_USERNAME")
	private String cmemailUsername;

	private String cmfromnum;

	private String cmfromsystem;

	private String cmmessage;

	private String cmmessageurl;

	private String cmtitle;

	@Column(name="NOLOGIN_DURATION_DAY")
	private BigDecimal nologinDurationDay;

	@Column(name="PWD_ERRORNUM")
	private BigDecimal pwdErrornum;

	@Column(name="PWD_LENGTH")
	private BigDecimal pwdLength;

	@Column(name="PWD_LOWCASE")
	private String pwdLowcase;

	@Column(name="PWD_NUM")
	private String pwdNum;

	@Column(name="PWD_OVERTIME_DAY")
	private BigDecimal pwdOvertimeDay;

	@Column(name="PWD_SPECHAR")
	private String pwdSpechar;

	@Column(name="PWD_UPPERCASE")
	private String pwdUppercase;

	@Column(name="SESSION_COUNT")
	private BigDecimal sessionCount;

	@Column(name="SESSION_OVERTIME_DAY")
	private BigDecimal sessionOvertimeDay;

	public SfOrganisationSystemsafe() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAmfromnum() {
		return this.amfromnum;
	}

	public void setAmfromnum(String amfromnum) {
		this.amfromnum = amfromnum;
	}

	public String getAmfromsystem() {
		return this.amfromsystem;
	}

	public void setAmfromsystem(String amfromsystem) {
		this.amfromsystem = amfromsystem;
	}

	public String getAmmessage() {
		return this.ammessage;
	}

	public void setAmmessage(String ammessage) {
		this.ammessage = ammessage;
	}

	public String getAmtitle() {
		return this.amtitle;
	}

	public void setAmtitle(String amtitle) {
		this.amtitle = amtitle;
	}

	public String getCmemailFrom() {
		return this.cmemailFrom;
	}

	public void setCmemailFrom(String cmemailFrom) {
		this.cmemailFrom = cmemailFrom;
	}

	public String getCmemailHost() {
		return this.cmemailHost;
	}

	public void setCmemailHost(String cmemailHost) {
		this.cmemailHost = cmemailHost;
	}

	public String getCmemailPassword() {
		return this.cmemailPassword;
	}

	public void setCmemailPassword(String cmemailPassword) {
		this.cmemailPassword = cmemailPassword;
	}

	public String getCmemailPort() {
		return this.cmemailPort;
	}

	public void setCmemailPort(String cmemailPort) {
		this.cmemailPort = cmemailPort;
	}

	public String getCmemailSsl() {
		return this.cmemailSsl;
	}

	public void setCmemailSsl(String cmemailSsl) {
		this.cmemailSsl = cmemailSsl;
	}

	public String getCmemailUsername() {
		return this.cmemailUsername;
	}

	public void setCmemailUsername(String cmemailUsername) {
		this.cmemailUsername = cmemailUsername;
	}

	public String getCmfromnum() {
		return this.cmfromnum;
	}

	public void setCmfromnum(String cmfromnum) {
		this.cmfromnum = cmfromnum;
	}

	public String getCmfromsystem() {
		return this.cmfromsystem;
	}

	public void setCmfromsystem(String cmfromsystem) {
		this.cmfromsystem = cmfromsystem;
	}

	public String getCmmessage() {
		return this.cmmessage;
	}

	public void setCmmessage(String cmmessage) {
		this.cmmessage = cmmessage;
	}

	public String getCmmessageurl() {
		return this.cmmessageurl;
	}

	public void setCmmessageurl(String cmmessageurl) {
		this.cmmessageurl = cmmessageurl;
	}

	public String getCmtitle() {
		return this.cmtitle;
	}

	public void setCmtitle(String cmtitle) {
		this.cmtitle = cmtitle;
	}

	public BigDecimal getNologinDurationDay() {
		return this.nologinDurationDay;
	}

	public void setNologinDurationDay(BigDecimal nologinDurationDay) {
		this.nologinDurationDay = nologinDurationDay;
	}

	public BigDecimal getPwdErrornum() {
		return this.pwdErrornum;
	}

	public void setPwdErrornum(BigDecimal pwdErrornum) {
		this.pwdErrornum = pwdErrornum;
	}

	public BigDecimal getPwdLength() {
		return this.pwdLength;
	}

	public void setPwdLength(BigDecimal pwdLength) {
		this.pwdLength = pwdLength;
	}

	public String getPwdLowcase() {
		return this.pwdLowcase;
	}

	public void setPwdLowcase(String pwdLowcase) {
		this.pwdLowcase = pwdLowcase;
	}

	public String getPwdNum() {
		return this.pwdNum;
	}

	public void setPwdNum(String pwdNum) {
		this.pwdNum = pwdNum;
	}

	public BigDecimal getPwdOvertimeDay() {
		return this.pwdOvertimeDay;
	}

	public void setPwdOvertimeDay(BigDecimal pwdOvertimeDay) {
		this.pwdOvertimeDay = pwdOvertimeDay;
	}

	public String getPwdSpechar() {
		return this.pwdSpechar;
	}

	public void setPwdSpechar(String pwdSpechar) {
		this.pwdSpechar = pwdSpechar;
	}

	public String getPwdUppercase() {
		return this.pwdUppercase;
	}

	public void setPwdUppercase(String pwdUppercase) {
		this.pwdUppercase = pwdUppercase;
	}

	public BigDecimal getSessionCount() {
		return this.sessionCount;
	}

	public void setSessionCount(BigDecimal sessionCount) {
		this.sessionCount = sessionCount;
	}

	public BigDecimal getSessionOvertimeDay() {
		return this.sessionOvertimeDay;
	}

	public void setSessionOvertimeDay(BigDecimal sessionOvertimeDay) {
		this.sessionOvertimeDay = sessionOvertimeDay;
	}

}