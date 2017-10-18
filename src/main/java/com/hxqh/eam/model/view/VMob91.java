package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;


/**
 * The persistent class for the V_MOB_91 database table.
 * 
 */
@Entity
@Table(name="V_MOB_91")
public class VMob91 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer rn;

	private String ioc1;

	private BigDecimal ioc2;

	private BigDecimal ioc3;

	private BigDecimal ioc4;

	private String ioc5;

	private BigDecimal ioc6;

	private String ioc7;

	public VMob91() {
	}

	public Integer getRn() {
		return rn;
	}

	public void setRn(Integer rn) {
		this.rn = rn;
	}

	public String getIoc1() {
		return this.ioc1;
	}

	public void setIoc1(String ioc1) {
		this.ioc1 = ioc1;
	}

	public BigDecimal getIoc2() {
		return this.ioc2;
	}

	public void setIoc2(BigDecimal ioc2) {
		this.ioc2 = ioc2;
	}

	public BigDecimal getIoc3() {
		return this.ioc3;
	}

	public void setIoc3(BigDecimal ioc3) {
		this.ioc3 = ioc3;
	}

	public BigDecimal getIoc4() {
		return this.ioc4;
	}

	public void setIoc4(BigDecimal ioc4) {
		this.ioc4 = ioc4;
	}

	public String getIoc5() {
		return this.ioc5;
	}

	public void setIoc5(String ioc5) {
		this.ioc5 = ioc5;
	}

	public BigDecimal getIoc6() {
		return this.ioc6;
	}

	public void setIoc6(BigDecimal ioc6) {
		this.ioc6 = ioc6;
	}

	public String getIoc7() {
		return this.ioc7;
	}

	public void setIoc7(String ioc7) {
		this.ioc7 = ioc7;
	}

}