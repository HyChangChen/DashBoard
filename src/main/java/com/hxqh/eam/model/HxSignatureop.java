package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the HX_SIGNATUREOPS database table.
 * 
 */
@Entity
@Table(name="HX_SIGNATUREOPS")
public class HxSignatureop implements Serializable {
	private static final long serialVersionUID = 1L;

	private String app;

	private String conditions;

	@Temporal(TemporalType.DATE)
	private Date createtime;

	private String description;

	@Id
	private String id;

	private String signature;

	public HxSignatureop() {
	}

	public String getApp() {
		return this.app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getConditions() {
		return this.conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
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

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}