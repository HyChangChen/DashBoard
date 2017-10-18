package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MARK database table.
 * 
 */
@Entity
@Table(name="MARK")
public class Mark implements Serializable {
	private static final long serialVersionUID = 1L;

	private String defaultpower;

	private String discription;

	@Id
	private String id;

	private String name;

	@Column(name="\"VALUE\"")
	private String value;

	public Mark() {
	}

	public String getDefaultpower() {
		return this.defaultpower;
	}

	public void setDefaultpower(String defaultpower) {
		this.defaultpower = defaultpower;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
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

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}