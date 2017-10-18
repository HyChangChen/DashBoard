package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ORGANIZATION database table.
 * 
 */
@Entity
@Table(name="ORGANIZATION")
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	private String active;

	private String basecurrency1;

	private String basecurrency2;

	private String category;

	private String clearingacct;

	private String companysetid;

	private String description;

	@Column(name="DESCRIPTION_LONGDESCRIPTION")
	private String descriptionLongdescription;

	private String dfltitemstatus;

	private String enterby;

	@Temporal(TemporalType.DATE)
	private Date enterdate;

	private String hasld;

	private String itemsetid;

	private String langcode;

	@Id
	private String organizationid;

	private String orgid;

	public Organization() {
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getBasecurrency1() {
		return this.basecurrency1;
	}

	public void setBasecurrency1(String basecurrency1) {
		this.basecurrency1 = basecurrency1;
	}

	public String getBasecurrency2() {
		return this.basecurrency2;
	}

	public void setBasecurrency2(String basecurrency2) {
		this.basecurrency2 = basecurrency2;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getClearingacct() {
		return this.clearingacct;
	}

	public void setClearingacct(String clearingacct) {
		this.clearingacct = clearingacct;
	}

	public String getCompanysetid() {
		return this.companysetid;
	}

	public void setCompanysetid(String companysetid) {
		this.companysetid = companysetid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionLongdescription() {
		return this.descriptionLongdescription;
	}

	public void setDescriptionLongdescription(String descriptionLongdescription) {
		this.descriptionLongdescription = descriptionLongdescription;
	}

	public String getDfltitemstatus() {
		return this.dfltitemstatus;
	}

	public void setDfltitemstatus(String dfltitemstatus) {
		this.dfltitemstatus = dfltitemstatus;
	}

	public String getEnterby() {
		return this.enterby;
	}

	public void setEnterby(String enterby) {
		this.enterby = enterby;
	}

	public Date getEnterdate() {
		return this.enterdate;
	}

	public void setEnterdate(Date enterdate) {
		this.enterdate = enterdate;
	}

	public String getHasld() {
		return this.hasld;
	}

	public void setHasld(String hasld) {
		this.hasld = hasld;
	}

	public String getItemsetid() {
		return this.itemsetid;
	}

	public void setItemsetid(String itemsetid) {
		this.itemsetid = itemsetid;
	}

	public String getLangcode() {
		return this.langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public String getOrganizationid() {
		return this.organizationid;
	}

	public void setOrganizationid(String organizationid) {
		this.organizationid = organizationid;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

}