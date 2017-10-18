package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the APPMARKS database table.
 * 
 */
@Entity
@Table(name="APPMARKS")
public class Appmark implements Serializable {
	private static final long serialVersionUID = 1L;

	private String appname;

	private String groupname;

	@Id
	private String id;

	private String menupower;

	private String optionspower;

	public Appmark() {
	}

	public String getAppname() {
		return this.appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenupower() {
		return this.menupower;
	}

	public void setMenupower(String menupower) {
		this.menupower = menupower;
	}

	public String getOptionspower() {
		return this.optionspower;
	}

	public void setOptionspower(String optionspower) {
		this.optionspower = optionspower;
	}

}