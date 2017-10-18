package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the G04DEPARTMENT database table.
 * 
 */
@Entity
@Table(name="G04DEPARTMENT")
public class G04department implements Serializable {
	private static final long serialVersionUID = 1L;

	private String addressid;

	private String companyid;

	private String conperson;

	private String conphone;

	private String defecthead;

	private String departmentid;

	private String description;

	@Id
	private String g04departmentid;

	private String groupid;

	private String mailaddr;

	private String manager;

	private String name;

	private String note;

	private String orgid;

	private String parent;

	private String siteid;

	private String status;

	private String website;

	public G04department() {
	}

	public String getAddressid() {
		return this.addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}

	public String getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public String getConperson() {
		return this.conperson;
	}

	public void setConperson(String conperson) {
		this.conperson = conperson;
	}

	public String getConphone() {
		return this.conphone;
	}

	public void setConphone(String conphone) {
		this.conphone = conphone;
	}

	public String getDefecthead() {
		return this.defecthead;
	}

	public void setDefecthead(String defecthead) {
		this.defecthead = defecthead;
	}

	public String getDepartmentid() {
		return this.departmentid;
	}

	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getG04departmentid() {
		return this.g04departmentid;
	}

	public void setG04departmentid(String g04departmentid) {
		this.g04departmentid = g04departmentid;
	}

	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getMailaddr() {
		return this.mailaddr;
	}

	public void setMailaddr(String mailaddr) {
		this.mailaddr = mailaddr;
	}

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getParent() {
		return this.parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
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

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}