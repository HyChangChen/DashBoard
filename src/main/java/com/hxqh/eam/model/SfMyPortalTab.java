package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SF_MY_PORTAL_TABS database table.
 * 
 */
@Entity
@Table(name="SF_MY_PORTAL_TABS")
public class SfMyPortalTab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date createdate;

	private String description;

	@Id
	private String id;

	private BigDecimal tabmark;

	private String tabtext;

	private String userid;

	private BigDecimal views;

	public SfMyPortalTab() {
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

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getTabmark() {
		return this.tabmark;
	}

	public void setTabmark(BigDecimal tabmark) {
		this.tabmark = tabmark;
	}

	public String getTabtext() {
		return this.tabtext;
	}

	public void setTabtext(String tabtext) {
		this.tabtext = tabtext;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public BigDecimal getViews() {
		return this.views;
	}

	public void setViews(BigDecimal views) {
		this.views = views;
	}

}