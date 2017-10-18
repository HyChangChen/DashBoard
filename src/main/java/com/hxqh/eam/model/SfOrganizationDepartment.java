package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SF_ORGANIZATION_DEPARTMENT database table.
 * 
 */
@Entity
@Table(name="SF_ORGANIZATION_DEPARTMENT")
public class SfOrganizationDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal departmenttype;

	private String description;

	@Id
	private String id;

	private String name;

	private BigDecimal oorder;

	private String parentid;

	private String text;

	public SfOrganizationDepartment() {
	}

	public BigDecimal getDepartmenttype() {
		return this.departmenttype;
	}

	public void setDepartmenttype(BigDecimal departmenttype) {
		this.departmenttype = departmenttype;
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

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}