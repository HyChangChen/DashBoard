package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the G04COMPANY database table.
 * 
 */
@Entity
@Table(name="APPMARKS")
@NamedQuery(name="G04company.findAll", query="SELECT g FROM G04company g")
public class G04company implements Serializable {
	private static final long serialVersionUID = 1L;

	private String address;

	private String bandaccount;

	private String city;

	private String companyid;

	private String companynum;

	private String conperson;

	private BigDecimal conphone;

	@Temporal(TemporalType.DATE)
	private Date createtime;

	private String currncycode;

	private String description;

	private String fax;

	private String g02groupid;

	@Id
	private String g04companyid;

	private String groupid;

	private String name;

	private String note;

	private String openaccount;

	private String orgid;

	private String parent;

	private String paymentterms;

	private String phone;

	private String registration;

	private String scop;

	private String shipvia;

	private String siteid;

	private String statuss;

	private String taxrate;

	private String website;

	public G04company() {
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBandaccount() {
		return this.bandaccount;
	}

	public void setBandaccount(String bandaccount) {
		this.bandaccount = bandaccount;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public String getCompanynum() {
		return this.companynum;
	}

	public void setCompanynum(String companynum) {
		this.companynum = companynum;
	}

	public String getConperson() {
		return this.conperson;
	}

	public void setConperson(String conperson) {
		this.conperson = conperson;
	}

	public BigDecimal getConphone() {
		return this.conphone;
	}

	public void setConphone(BigDecimal conphone) {
		this.conphone = conphone;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCurrncycode() {
		return this.currncycode;
	}

	public void setCurrncycode(String currncycode) {
		this.currncycode = currncycode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getG02groupid() {
		return this.g02groupid;
	}

	public void setG02groupid(String g02groupid) {
		this.g02groupid = g02groupid;
	}

	public String getG04companyid() {
		return this.g04companyid;
	}

	public void setG04companyid(String g04companyid) {
		this.g04companyid = g04companyid;
	}

	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
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

	public String getOpenaccount() {
		return this.openaccount;
	}

	public void setOpenaccount(String openaccount) {
		this.openaccount = openaccount;
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

	public String getPaymentterms() {
		return this.paymentterms;
	}

	public void setPaymentterms(String paymentterms) {
		this.paymentterms = paymentterms;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegistration() {
		return this.registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getScop() {
		return this.scop;
	}

	public void setScop(String scop) {
		this.scop = scop;
	}

	public String getShipvia() {
		return this.shipvia;
	}

	public void setShipvia(String shipvia) {
		this.shipvia = shipvia;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getStatuss() {
		return this.statuss;
	}

	public void setStatuss(String statuss) {
		this.statuss = statuss;
	}

	public String getTaxrate() {
		return this.taxrate;
	}

	public void setTaxrate(String taxrate) {
		this.taxrate = taxrate;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}