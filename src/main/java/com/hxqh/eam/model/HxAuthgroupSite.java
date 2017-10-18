package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HX_AUTHGROUP_SITE database table.
 * 
 */
@Entity
@Table(name="HX_AUTHGROUP_SITE")
public class HxAuthgroupSite implements Serializable {
	private static final long serialVersionUID = 1L;

	private String groupid;

	@Id
	private String id;

	private String orgid;

	private String siteauthid;

	private String siteid;

	public HxAuthgroupSite() {
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

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getSiteauthid() {
		return this.siteauthid;
	}

	public void setSiteauthid(String siteauthid) {
		this.siteauthid = siteauthid;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

}