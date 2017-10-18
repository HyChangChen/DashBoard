package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the APPS database table.
 * 
 */
@Entity
@Table(name="APPS")
public class App implements Serializable {
	private static final long serialVersionUID = 1L;

	private String app;

	@Id
	private String appsid;

	private String apptype;

	private String custapptype;

	@Lob
	private String datasrc;

	@Lob
	private String datasrcch;

	private BigDecimal deletee;

	private String description;

	private String groupname;

	private String handleclass;

	private BigDecimal insertt;

	private BigDecimal ismobile;

	private String keyattribute;

	private String maxappsid;

	@Column(name="\"MODULE\"")
	private String module;

	private String objectname;

	private String orderby;

	private String originalapp;

	private BigDecimal readd;

	private String restrictions;

	@Column(name="\"SAVE\"")
	private BigDecimal save;

	private String viewport;

	public App() {
	}

	public String getApp() {
		return this.app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getAppsid() {
		return this.appsid;
	}

	public void setAppsid(String appsid) {
		this.appsid = appsid;
	}

	public String getApptype() {
		return this.apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public String getCustapptype() {
		return this.custapptype;
	}

	public void setCustapptype(String custapptype) {
		this.custapptype = custapptype;
	}

	public String getDatasrc() {
		return this.datasrc;
	}

	public void setDatasrc(String datasrc) {
		this.datasrc = datasrc;
	}

	public String getDatasrcch() {
		return this.datasrcch;
	}

	public void setDatasrcch(String datasrcch) {
		this.datasrcch = datasrcch;
	}

	public BigDecimal getDeletee() {
		return this.deletee;
	}

	public void setDeletee(BigDecimal deletee) {
		this.deletee = deletee;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getHandleclass() {
		return this.handleclass;
	}

	public void setHandleclass(String handleclass) {
		this.handleclass = handleclass;
	}

	public BigDecimal getInsertt() {
		return this.insertt;
	}

	public void setInsertt(BigDecimal insertt) {
		this.insertt = insertt;
	}

	public BigDecimal getIsmobile() {
		return this.ismobile;
	}

	public void setIsmobile(BigDecimal ismobile) {
		this.ismobile = ismobile;
	}

	public String getKeyattribute() {
		return this.keyattribute;
	}

	public void setKeyattribute(String keyattribute) {
		this.keyattribute = keyattribute;
	}

	public String getMaxappsid() {
		return this.maxappsid;
	}

	public void setMaxappsid(String maxappsid) {
		this.maxappsid = maxappsid;
	}

	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getObjectname() {
		return this.objectname;
	}

	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}

	public String getOrderby() {
		return this.orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public String getOriginalapp() {
		return this.originalapp;
	}

	public void setOriginalapp(String originalapp) {
		this.originalapp = originalapp;
	}

	public BigDecimal getReadd() {
		return this.readd;
	}

	public void setReadd(BigDecimal readd) {
		this.readd = readd;
	}

	public String getRestrictions() {
		return this.restrictions;
	}

	public void setRestrictions(String restrictions) {
		this.restrictions = restrictions;
	}

	public BigDecimal getSave() {
		return this.save;
	}

	public void setSave(BigDecimal save) {
		this.save = save;
	}

	public String getViewport() {
		return this.viewport;
	}

	public void setViewport(String viewport) {
		this.viewport = viewport;
	}

}