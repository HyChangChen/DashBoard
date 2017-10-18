package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SF_ORGANIZATION_ROLEMEMBER database table.
 * 
 */
@Entity
@Table(name="SF_ORGANIZATION_ROLEMEMBER")
public class SfOrganizationRolemember implements Serializable {
	private static final long serialVersionUID = 1L;

	private String accountid;

	private String description;

	@Id
	private String id;

	private String memberid;

	private BigDecimal membertype;

	private String name;

	private BigDecimal oorder;

	private BigDecimal primaryrole;

	private String roleid;

	public SfOrganizationRolemember() {
	}

	public String getAccountid() {
		return this.accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMemberid() {
		return this.memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public BigDecimal getMembertype() {
		return this.membertype;
	}

	public void setMembertype(BigDecimal membertype) {
		this.membertype = membertype;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getOorder() {
		return this.oorder;
	}

	public void setOorder(BigDecimal oorder) {
		this.oorder = oorder;
	}

	public BigDecimal getPrimaryrole() {
		return this.primaryrole;
	}

	public void setPrimaryrole(BigDecimal primaryrole) {
		this.primaryrole = primaryrole;
	}

	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

}