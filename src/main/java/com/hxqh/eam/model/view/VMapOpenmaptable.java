package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_MAP_OPENMAPTABLE database table.
 * 
 */
@Entity
@Table(name="V_MAP_OPENMAPTABLE")
public class VMapOpenmaptable implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal num;

	@Id
	private BigDecimal rn;

	private BigDecimal treg;

	@Column(name="\"TYPE\"")
	private String type;

	public VMapOpenmaptable() {
	}

	public BigDecimal getNum() {
		return this.num;
	}

	public void setNum(BigDecimal num) {
		this.num = num;
	}

	public BigDecimal getRn() {
		return this.rn;
	}

	public void setRn(BigDecimal rn) {
		this.rn = rn;
	}

	public BigDecimal getTreg() {
		return this.treg;
	}

	public void setTreg(BigDecimal treg) {
		this.treg = treg;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}