package com.hxqh.eam.model;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SF_ORGANIZATION_ACCOUNT database table.
 * 
 */
@Entity
@Table(name="SF_ORGANIZATION_ACCOUNT")
public class SfOrganizationAccount implements Serializable {


	private static final long serialVersionUID = 1L;

	private BigDecimal accountmark;

	private BigDecimal attemplogintimes;

	@Temporal(TemporalType.DATE)
	private Date createdate;

	@Id
	private String id;

	private String isiniticalpassword;

	@Temporal(TemporalType.DATE)
	private Date lastlogindate;

	private String lastloginip;

	@Temporal(TemporalType.DATE)
	private Date lastmdate;

	private BigDecimal login;

	private String loginaccountnum;

	private BigDecimal logintimes;

	private BigDecimal mailbinding;

	private BigDecimal mobilebinding;

	private String name;

	private BigDecimal onlinemillis;

	private String password;

	private BigDecimal status;

	private String useinitialpass;

	//bi-directional many-to-one association to UserroleObj
	@OneToMany(mappedBy="tbUser")
	@XStreamOmitField
	private List<TbUserrole> tbUserroles;


	public SfOrganizationAccount() {
	}

	public SfOrganizationAccount(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public BigDecimal getAccountmark() {
		return this.accountmark;
	}

	public void setAccountmark(BigDecimal accountmark) {
		this.accountmark = accountmark;
	}

	public BigDecimal getAttemplogintimes() {
		return this.attemplogintimes;
	}

	public void setAttemplogintimes(BigDecimal attemplogintimes) {
		this.attemplogintimes = attemplogintimes;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsiniticalpassword() {
		return this.isiniticalpassword;
	}

	public void setIsiniticalpassword(String isiniticalpassword) {
		this.isiniticalpassword = isiniticalpassword;
	}

	public Date getLastlogindate() {
		return this.lastlogindate;
	}

	public void setLastlogindate(Date lastlogindate) {
		this.lastlogindate = lastlogindate;
	}

	public String getLastloginip() {
		return this.lastloginip;
	}

	public void setLastloginip(String lastloginip) {
		this.lastloginip = lastloginip;
	}

	public Date getLastmdate() {
		return this.lastmdate;
	}

	public void setLastmdate(Date lastmdate) {
		this.lastmdate = lastmdate;
	}

	public BigDecimal getLogin() {
		return this.login;
	}

	public void setLogin(BigDecimal login) {
		this.login = login;
	}

	public String getLoginaccountnum() {
		return this.loginaccountnum;
	}

	public void setLoginaccountnum(String loginaccountnum) {
		this.loginaccountnum = loginaccountnum;
	}

	public BigDecimal getLogintimes() {
		return this.logintimes;
	}

	public void setLogintimes(BigDecimal logintimes) {
		this.logintimes = logintimes;
	}

	public BigDecimal getMailbinding() {
		return this.mailbinding;
	}

	public void setMailbinding(BigDecimal mailbinding) {
		this.mailbinding = mailbinding;
	}

	public BigDecimal getMobilebinding() {
		return this.mobilebinding;
	}

	public void setMobilebinding(BigDecimal mobilebinding) {
		this.mobilebinding = mobilebinding;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getOnlinemillis() {
		return this.onlinemillis;
	}

	public void setOnlinemillis(BigDecimal onlinemillis) {
		this.onlinemillis = onlinemillis;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public String getUseinitialpass() {
		return this.useinitialpass;
	}

	public void setUseinitialpass(String useinitialpass) {
		this.useinitialpass = useinitialpass;
	}

}