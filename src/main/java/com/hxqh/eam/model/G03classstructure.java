package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the G03CLASSSTRUCTURE database table.
 * 
 */
@Entity
@Table(name="G03CLASSSTRUCTURE")
public class G03classstructure implements Serializable {
	private static final long serialVersionUID = 1L;

	private String classificationid;

	private String classpath;

	@Id
	private BigDecimal classstructureid;

	private String companyid;

	private String description;

	private String g03classstructureid;

	private String groupid;

	private BigDecimal haschildren;

	private BigDecimal hasparent;

	@Column(name="\"LEVEL\"")
	private BigDecimal level;

	private BigDecimal lifetime;

	private String orgid;

	private String parent;

	private String parentclassificationid;

	private String siteid;

	private BigDecimal useclassindesc;

	public G03classstructure() {
	}

	public String getClassificationid() {
		return this.classificationid;
	}

	public void setClassificationid(String classificationid) {
		this.classificationid = classificationid;
	}

	public String getClasspath() {
		return this.classpath;
	}

	public void setClasspath(String classpath) {
		this.classpath = classpath;
	}

	public BigDecimal getClassstructureid() {
		return this.classstructureid;
	}

	public void setClassstructureid(BigDecimal classstructureid) {
		this.classstructureid = classstructureid;
	}

	public String getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getG03classstructureid() {
		return this.g03classstructureid;
	}

	public void setG03classstructureid(String g03classstructureid) {
		this.g03classstructureid = g03classstructureid;
	}

	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public BigDecimal getHaschildren() {
		return this.haschildren;
	}

	public void setHaschildren(BigDecimal haschildren) {
		this.haschildren = haschildren;
	}

	public BigDecimal getHasparent() {
		return this.hasparent;
	}

	public void setHasparent(BigDecimal hasparent) {
		this.hasparent = hasparent;
	}

	public BigDecimal getLevel() {
		return this.level;
	}

	public void setLevel(BigDecimal level) {
		this.level = level;
	}

	public BigDecimal getLifetime() {
		return this.lifetime;
	}

	public void setLifetime(BigDecimal lifetime) {
		this.lifetime = lifetime;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getParent() {
		return this.parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getParentclassificationid() {
		return this.parentclassificationid;
	}

	public void setParentclassificationid(String parentclassificationid) {
		this.parentclassificationid = parentclassificationid;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public BigDecimal getUseclassindesc() {
		return this.useclassindesc;
	}

	public void setUseclassindesc(BigDecimal useclassindesc) {
		this.useclassindesc = useclassindesc;
	}

}