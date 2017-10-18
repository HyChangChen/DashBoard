package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SF_ORGANIZATION_ROLECHART database table.
 * 
 */
@Entity
@Table(name="SF_ORGANIZATION_ROLECHART")
@NamedQuery(name="SfOrganizationRolechart.findAll", query="SELECT s FROM SfOrganizationRolechart s")
public class SfOrganizationRolechart implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal chartmark;

	private String departmentid;

	private String description;

	@Id
	private String id;

	private String name;

	private BigDecimal oorder;

	private String text;

	public SfOrganizationRolechart() {
	}

	public BigDecimal getChartmark() {
		return this.chartmark;
	}

	public void setChartmark(BigDecimal chartmark) {
		this.chartmark = chartmark;
	}

	public String getDepartmentid() {
		return this.departmentid;
	}

	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
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

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}