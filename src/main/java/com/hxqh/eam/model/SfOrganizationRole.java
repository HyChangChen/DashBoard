package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SF_ORGANIZATION_ROLE database table.
 * 
 */
@Entity
@Table(name="SF_ORGANIZATION_ROLE")
public class SfOrganizationRole implements Serializable {
	private static final long serialVersionUID = 1L;

	private String description;

	@Id
	private String id;

	private String name;

	private BigDecimal oorder;

	private String parentid;

	private String rolechartid;

	private BigDecimal rolemark;

	private BigDecimal roletype;

	private String rulehandler;

	private String rulescript;

	private String text;

	public SfOrganizationRole() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getOorder() {
		return this.oorder;
	}

	public void setOorder(BigDecimal oorder) {
		this.oorder = oorder;
	}

	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getRolechartid() {
		return this.rolechartid;
	}

	public void setRolechartid(String rolechartid) {
		this.rolechartid = rolechartid;
	}

	public BigDecimal getRolemark() {
		return this.rolemark;
	}

	public void setRolemark(BigDecimal rolemark) {
		this.rolemark = rolemark;
	}

	public BigDecimal getRoletype() {
		return this.roletype;
	}

	public void setRoletype(BigDecimal roletype) {
		this.roletype = roletype;
	}

	public String getRulehandler() {
		return this.rulehandler;
	}

	public void setRulehandler(String rulehandler) {
		this.rulehandler = rulehandler;
	}

	public String getRulescript() {
		return this.rulescript;
	}

	public void setRulescript(String rulescript) {
		this.rulescript = rulescript;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}