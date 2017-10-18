package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SQLMARY database table.
 * 
 */
@Entity
public class Sqlmary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SQLMARY_SQLMARYID_GENERATOR", sequenceName="SQLMARY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQLMARY_SQLMARYID_GENERATOR")
	private String sqlmaryid;

	private String appname;

	@Lob
	private String sqldata;

	private String sqlnum;

	public Sqlmary() {
	}

	public String getSqlmaryid() {
		return this.sqlmaryid;
	}

	public void setSqlmaryid(String sqlmaryid) {
		this.sqlmaryid = sqlmaryid;
	}

	public String getAppname() {
		return this.appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getSqldata() {
		return this.sqldata;
	}

	public void setSqldata(String sqldata) {
		this.sqldata = sqldata;
	}

	public String getSqlnum() {
		return this.sqlnum;
	}

	public void setSqlnum(String sqlnum) {
		this.sqlnum = sqlnum;
	}

}