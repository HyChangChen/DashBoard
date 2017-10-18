package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the G04COMPANYLINE database table.
 * 
 */
@Entity
@Table(name="G04COMPANYLINE")
public class G04companyline implements Serializable {
	private static final long serialVersionUID = 1L;

	private String companylinenum;

	private String companynum;

	private String fax;

	private String g04companyid;

	@Id
	private String g04companylineid;

	private String mail;

	private String name;

	private String notes;

	private String officephone;

	private String orgid;

	private String phone;

	@Column(name="\"POSITION\"")
	private String position;

	private String siteid;

	private String status;

	public G04companyline() {
	}

	public String getCompanylinenum() {
		return this.companylinenum;
	}

	public void setCompanylinenum(String companylinenum) {
		this.companylinenum = companylinenum;
	}

	public String getCompanynum() {
		return this.companynum;
	}

	public void setCompanynum(String companynum) {
		this.companynum = companynum;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getG04companyid() {
		return this.g04companyid;
	}

	public void setG04companyid(String g04companyid) {
		this.g04companyid = g04companyid;
	}

	public String getG04companylineid() {
		return this.g04companylineid;
	}

	public void setG04companylineid(String g04companylineid) {
		this.g04companylineid = g04companylineid;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getOfficephone() {
		return this.officephone;
	}

	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}