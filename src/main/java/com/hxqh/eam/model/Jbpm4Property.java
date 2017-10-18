package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the JBPM4_PROPERTY database table.
 * 
 */
@Entity
@Table(name="JBPM4_PROPERTY")
public class Jbpm4Property implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="KEY_")
	private String key;

	@Column(name="VALUE_")
	private String value;

	@Column(name="VERSION_")
	private BigDecimal version;

	public Jbpm4Property() {
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public BigDecimal getVersion() {
		return this.version;
	}

	public void setVersion(BigDecimal version) {
		this.version = version;
	}

}