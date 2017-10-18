package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HX_AUTHGROUP_APP database table.
 * 
 */
@Entity
@Table(name="HX_AUTHGROUP_APP")
public class HxAuthgroupApp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String appid;

	private String appname;

	private String description;

	private String groupid;

	private String id;

	private String objectname;

	public HxAuthgroupApp() {
	}

	public String getAppid() {
		return this.appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppname() {
		return this.appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

}