package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HX_AUTHGROUP database table.
 * 
 */
@Entity
@Table(name="HX_AUTHGROUP")
public class HxAuthgroup implements Serializable {
	private static final long serialVersionUID = 1L;

	private String authallcompanies;

	private String authallstorerooms;

	private String description;

	@Id
	@Column(name="HX_AUTHGROUPID")
	private String hxAuthgroupid;

	private String id;

	private String ifadmin;

	private String name;

	private String textname;

	public HxAuthgroup() {
	}

	public String getAuthallcompanies() {
		return this.authallcompanies;
	}

	public void setAuthallcompanies(String authallcompanies) {
		this.authallcompanies = authallcompanies;
	}

	public String getAuthallstorerooms() {
		return this.authallstorerooms;
	}

	public void setAuthallstorerooms(String authallstorerooms) {
		this.authallstorerooms = authallstorerooms;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHxAuthgroupid() {
		return this.hxAuthgroupid;
	}

	public void setHxAuthgroupid(String hxAuthgroupid) {
		this.hxAuthgroupid = hxAuthgroupid;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIfadmin() {
		return this.ifadmin;
	}

	public void setIfadmin(String ifadmin) {
		this.ifadmin = ifadmin;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTextname() {
		return this.textname;
	}

	public void setTextname(String textname) {
		this.textname = textname;
	}

}