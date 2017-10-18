package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the G03TAX database table.
 * 
 */
@Entity
@Table(name="G03TAX")
public class G03tax implements Serializable {
	private static final long serialVersionUID = 1L;

	private String changeby;

	@Temporal(TemporalType.DATE)
	private Date changedate;

	private String createby;

	@Temporal(TemporalType.DATE)
	private Date createdate;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date effective;

	private String g03taxid;

	private String orgid;

	private String siteid;

	private String taxcode;

	@Id
	private String taxid;

	private double taxrate;

	public G03tax() {
	}

	public String getChangeby() {
		return this.changeby;
	}

	public void setChangeby(String changeby) {
		this.changeby = changeby;
	}

	public Date getChangedate() {
		return this.changedate;
	}

	public void setChangedate(Date changedate) {
		this.changedate = changedate;
	}

	public String getCreateby() {
		return this.createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEffective() {
		return this.effective;
	}

	public void setEffective(Date effective) {
		this.effective = effective;
	}

	public String getG03taxid() {
		return this.g03taxid;
	}

	public void setG03taxid(String g03taxid) {
		this.g03taxid = g03taxid;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getTaxcode() {
		return this.taxcode;
	}

	public void setTaxcode(String taxcode) {
		this.taxcode = taxcode;
	}

	public String getTaxid() {
		return this.taxid;
	}

	public void setTaxid(String taxid) {
		this.taxid = taxid;
	}

	public double getTaxrate() {
		return this.taxrate;
	}

	public void setTaxrate(double taxrate) {
		this.taxrate = taxrate;
	}

}