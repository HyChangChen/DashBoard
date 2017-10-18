package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HX_RESTRICT_OBJECT database table.
 * 
 */
@Entity
@Table(name="HX_RESTRICT_OBJECT")
public class HxRestrictObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private String appid;

	private String attributename;

	private String conditionnum;

	private String groupid;

	@Id
	private String id;

	private String objectname;

	private String restriction;

	public HxRestrictObject() {
	}

	public String getAppid() {
		return this.appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAttributename() {
		return this.attributename;
	}

	public void setAttributename(String attributename) {
		this.attributename = attributename;
	}

	public String getConditionnum() {
		return this.conditionnum;
	}

	public void setConditionnum(String conditionnum) {
		this.conditionnum = conditionnum;
	}

	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getObjectname() {
		return this.objectname;
	}

	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}

	public String getRestriction() {
		return this.restriction;
	}

	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}

}