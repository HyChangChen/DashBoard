package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OBJECTCFG database table.
 * 
 */
@Entity
@Table(name="OBJECTCFG")
public class Objectcfg implements Serializable {
	private static final long serialVersionUID = 1L;

	private String bowstamp;

	private String changed;

	private String classname;

	private String description;

	private String eauditenabled;

	private String eauditfilter;

	private String entityname;

	private String esigfilter;

	private String extendsobject;

	private String imported;

	private String internal;

	private String isview;

	private String mainobject;

	@Id
	private String objectcfgid;

	private String objectname;

	private String persistent;

	private String servicename;

	private String siteorgtype;

	private String textdirection;

	private String userdefined;

	public Objectcfg() {
	}

	public String getBowstamp() {
		return this.bowstamp;
	}

	public void setBowstamp(String bowstamp) {
		this.bowstamp = bowstamp;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEauditenabled() {
		return this.eauditenabled;
	}

	public void setEauditenabled(String eauditenabled) {
		this.eauditenabled = eauditenabled;
	}

	public String getEauditfilter() {
		return this.eauditfilter;
	}

	public void setEauditfilter(String eauditfilter) {
		this.eauditfilter = eauditfilter;
	}

	public String getEntityname() {
		return this.entityname;
	}

	public void setEntityname(String entityname) {
		this.entityname = entityname;
	}

	public String getEsigfilter() {
		return this.esigfilter;
	}

	public void setEsigfilter(String esigfilter) {
		this.esigfilter = esigfilter;
	}

	public String getExtendsobject() {
		return this.extendsobject;
	}

	public void setExtendsobject(String extendsobject) {
		this.extendsobject = extendsobject;
	}

	public String getImported() {
		return this.imported;
	}

	public void setImported(String imported) {
		this.imported = imported;
	}

	public String getInternal() {
		return this.internal;
	}

	public void setInternal(String internal) {
		this.internal = internal;
	}

	public String getIsview() {
		return this.isview;
	}

	public void setIsview(String isview) {
		this.isview = isview;
	}

	public String getMainobject() {
		return this.mainobject;
	}

	public void setMainobject(String mainobject) {
		this.mainobject = mainobject;
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

	public String getPersistent() {
		return this.persistent;
	}

	public void setPersistent(String persistent) {
		this.persistent = persistent;
	}

	public String getServicename() {
		return this.servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public String getSiteorgtype() {
		return this.siteorgtype;
	}

	public void setSiteorgtype(String siteorgtype) {
		this.siteorgtype = siteorgtype;
	}

	public String getTextdirection() {
		return this.textdirection;
	}

	public void setTextdirection(String textdirection) {
		this.textdirection = textdirection;
	}

	public String getUserdefined() {
		return this.userdefined;
	}

	public void setUserdefined(String userdefined) {
		this.userdefined = userdefined;
	}

}