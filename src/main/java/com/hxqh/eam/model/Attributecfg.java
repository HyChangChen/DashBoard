package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ATTRIBUTECFG database table.
 * 
 */
@Entity
@Table(name="ATTRIBUTECFG")
public class Attributecfg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"ALIAS\"")
	private String alias;

	@Id
	private String attributecfgid;

	private String attributename;

	private BigDecimal attributeno;

	private String autokeyname;

	private BigDecimal canautonum;

	private String changed;

	private String classname;

	private String columnname;

	private String complexexpression;

	private String defalultvalue;

	private String domainid;

	private BigDecimal eauditenabled;

	private String entityname;

	private BigDecimal esigenabeld;

	private String handlecolumnname;

	private BigDecimal isldowner;

	private BigDecimal ispositive;

	@Column(name="\"LENGTH\"")
	private BigDecimal length;

	private BigDecimal localzable;

	private String maxtype;

	private BigDecimal mlinuse;

	private BigDecimal mlsupported;

	private BigDecimal mustbe;

	private String objectcfgid;

	private String objectname;

	private BigDecimal persistent;

	private BigDecimal primarykeycolseq;

	private String remarks;

	private BigDecimal required;

	@Column(name="\"RESTRICTED\"")
	private BigDecimal restricted;

	private String rowstamp;

	private String sameasattribute;

	private String sameasobject;

	private BigDecimal scale;

	private String searchtype;

	private String textdirection;

	private String title;

	private BigDecimal userdefined;

	public Attributecfg() {
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getAttributecfgid() {
		return this.attributecfgid;
	}

	public void setAttributecfgid(String attributecfgid) {
		this.attributecfgid = attributecfgid;
	}

	public String getAttributename() {
		return this.attributename;
	}

	public void setAttributename(String attributename) {
		this.attributename = attributename;
	}

	public BigDecimal getAttributeno() {
		return this.attributeno;
	}

	public void setAttributeno(BigDecimal attributeno) {
		this.attributeno = attributeno;
	}

	public String getAutokeyname() {
		return this.autokeyname;
	}

	public void setAutokeyname(String autokeyname) {
		this.autokeyname = autokeyname;
	}

	public BigDecimal getCanautonum() {
		return this.canautonum;
	}

	public void setCanautonum(BigDecimal canautonum) {
		this.canautonum = canautonum;
	}

	public String getChanged() {
		return this.changed;
	}

	public void setChanged(String changed) {
		this.changed = changed;
	}

	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getColumnname() {
		return this.columnname;
	}

	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}

	public String getComplexexpression() {
		return this.complexexpression;
	}

	public void setComplexexpression(String complexexpression) {
		this.complexexpression = complexexpression;
	}

	public String getDefalultvalue() {
		return this.defalultvalue;
	}

	public void setDefalultvalue(String defalultvalue) {
		this.defalultvalue = defalultvalue;
	}

	public String getDomainid() {
		return this.domainid;
	}

	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}

	public BigDecimal getEauditenabled() {
		return this.eauditenabled;
	}

	public void setEauditenabled(BigDecimal eauditenabled) {
		this.eauditenabled = eauditenabled;
	}

	public String getEntityname() {
		return this.entityname;
	}

	public void setEntityname(String entityname) {
		this.entityname = entityname;
	}

	public BigDecimal getEsigenabeld() {
		return this.esigenabeld;
	}

	public void setEsigenabeld(BigDecimal esigenabeld) {
		this.esigenabeld = esigenabeld;
	}

	public String getHandlecolumnname() {
		return this.handlecolumnname;
	}

	public void setHandlecolumnname(String handlecolumnname) {
		this.handlecolumnname = handlecolumnname;
	}

	public BigDecimal getIsldowner() {
		return this.isldowner;
	}

	public void setIsldowner(BigDecimal isldowner) {
		this.isldowner = isldowner;
	}

	public BigDecimal getIspositive() {
		return this.ispositive;
	}

	public void setIspositive(BigDecimal ispositive) {
		this.ispositive = ispositive;
	}

	public BigDecimal getLength() {
		return this.length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public BigDecimal getLocalzable() {
		return this.localzable;
	}

	public void setLocalzable(BigDecimal localzable) {
		this.localzable = localzable;
	}

	public String getMaxtype() {
		return this.maxtype;
	}

	public void setMaxtype(String maxtype) {
		this.maxtype = maxtype;
	}

	public BigDecimal getMlinuse() {
		return this.mlinuse;
	}

	public void setMlinuse(BigDecimal mlinuse) {
		this.mlinuse = mlinuse;
	}

	public BigDecimal getMlsupported() {
		return this.mlsupported;
	}

	public void setMlsupported(BigDecimal mlsupported) {
		this.mlsupported = mlsupported;
	}

	public BigDecimal getMustbe() {
		return this.mustbe;
	}

	public void setMustbe(BigDecimal mustbe) {
		this.mustbe = mustbe;
	}

	public String getObjectcfgid() {
		return this.objectcfgid;
	}

	public void setObjectcfgid(String objectcfgid) {
		this.objectcfgid = objectcfgid;
	}

	public String getObjectname() {
		return this.objectname;
	}

	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}

	public BigDecimal getPersistent() {
		return this.persistent;
	}

	public void setPersistent(BigDecimal persistent) {
		this.persistent = persistent;
	}

	public BigDecimal getPrimarykeycolseq() {
		return this.primarykeycolseq;
	}

	public void setPrimarykeycolseq(BigDecimal primarykeycolseq) {
		this.primarykeycolseq = primarykeycolseq;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public BigDecimal getRequired() {
		return this.required;
	}

	public void setRequired(BigDecimal required) {
		this.required = required;
	}

	public BigDecimal getRestricted() {
		return this.restricted;
	}

	public void setRestricted(BigDecimal restricted) {
		this.restricted = restricted;
	}

	public String getRowstamp() {
		return this.rowstamp;
	}

	public void setRowstamp(String rowstamp) {
		this.rowstamp = rowstamp;
	}

	public String getSameasattribute() {
		return this.sameasattribute;
	}

	public void setSameasattribute(String sameasattribute) {
		this.sameasattribute = sameasattribute;
	}

	public String getSameasobject() {
		return this.sameasobject;
	}

	public void setSameasobject(String sameasobject) {
		this.sameasobject = sameasobject;
	}

	public BigDecimal getScale() {
		return this.scale;
	}

	public void setScale(BigDecimal scale) {
		this.scale = scale;
	}

	public String getSearchtype() {
		return this.searchtype;
	}

	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}

	public String getTextdirection() {
		return this.textdirection;
	}

	public void setTextdirection(String textdirection) {
		this.textdirection = textdirection;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getUserdefined() {
		return this.userdefined;
	}

	public void setUserdefined(BigDecimal userdefined) {
		this.userdefined = userdefined;
	}

}