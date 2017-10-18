package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the G04PEOPLE database table.
 * 
 */
@Entity
@Table(name="G04PEOPLE")
public class G04people implements Serializable {
	private static final long serialVersionUID = 1L;

	private String addressid;

	private String bandaccount;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private String childcompanyid;

	private String companyid;

	private String conphone;

	private String department;

	private String deptdesc;

	private String duty;

	private String family;

	@Id
	private String g04peopleid;

	private String gender;

	private String groupid;

	@Temporal(TemporalType.DATE)
	private Date hireday;

	private String idcard;

	private String mailaddr;

	private String manager;

	private String microcode;

	private String name;

	private String note;

	private String openaccount;

	private String orgid;

	private String peopleid;

	@Column(name="\"POSITION\"")
	private String position;

	private String prosection;

	private String qqcode;

	private String siteid;

	private String standby;

	private String status;

	private String website;

	public G04people() {
	}

	public String getAddressid() {
		return this.addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}

	public String getBandaccount() {
		return this.bandaccount;
	}

	public void setBandaccount(String bandaccount) {
		this.bandaccount = bandaccount;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getChildcompanyid() {
		return this.childcompanyid;
	}

	public void setChildcompanyid(String childcompanyid) {
		this.childcompanyid = childcompanyid;
	}

	public String getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public String getConphone() {
		return this.conphone;
	}

	public void setConphone(String conphone) {
		this.conphone = conphone;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDeptdesc() {
		return this.deptdesc;
	}

	public void setDeptdesc(String deptdesc) {
		this.deptdesc = deptdesc;
	}

	public String getDuty() {
		return this.duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getG04peopleid() {
		return this.g04peopleid;
	}

	public void setG04peopleid(String g04peopleid) {
		this.g04peopleid = g04peopleid;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public Date getHireday() {
		return this.hireday;
	}

	public void setHireday(Date hireday) {
		this.hireday = hireday;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
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

	public String getMicrocode() {
		return this.microcode;
	}

	public void setMicrocode(String microcode) {
		this.microcode = microcode;
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

	public String getPeopleid() {
		return this.peopleid;
	}

	public void setPeopleid(String peopleid) {
		this.peopleid = peopleid;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getProsection() {
		return this.prosection;
	}

	public void setProsection(String prosection) {
		this.prosection = prosection;
	}

	public String getQqcode() {
		return this.qqcode;
	}

	public void setQqcode(String qqcode) {
		this.qqcode = qqcode;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getStandby() {
		return this.standby;
	}

	public void setStandby(String standby) {
		this.standby = standby;
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