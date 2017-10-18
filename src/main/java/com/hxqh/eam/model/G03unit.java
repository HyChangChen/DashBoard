package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the G03UNIT database table.
 * 
 */
@Entity
@Table(name = "G03UNIT")
public class G03unit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String g03unitid;

	private String note;

	private String orgid;

	private String siteid;

	private String status;

	private String unitid;

	private String unitname;

	public G03unit() {
	}

	public String getG03unitid() {
		return this.g03unitid;
	}

	public void setG03unitid(String g03unitid) {
		this.g03unitid = g03unitid;
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

	public String getUnitid() {
		return this.unitid;
	}

	public void setUnitid(String unitid) {
		this.unitid = unitid;
	}

	public String getUnitname() {
		return this.unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

}