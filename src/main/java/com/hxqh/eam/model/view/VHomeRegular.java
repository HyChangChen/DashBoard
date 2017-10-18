package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_HOME_REGULAR database table.
 * 
 */
@Entity
@Table(name="V_HOME_REGULAR")
public class VHomeRegular implements Serializable {
	private static final long serialVersionUID = 1L;


	@Column(name="RE_CL")
	private BigDecimal cl;

	@Column(name="RE_OP")
	private BigDecimal op;

	@Column(name="RE_SH")
	private BigDecimal sh;

	@Column(name="RE_SH_1")
	private BigDecimal sh1;

	@Column(name = "REDEV")
	private BigDecimal dev;
	@Id
	private String regional;

	public VHomeRegular() {
	}

	public BigDecimal getCl() {
		return cl;
	}

	public void setCl(BigDecimal cl) {
		this.cl = cl;
	}

	public BigDecimal getOp() {
		return op;
	}

	public void setOp(BigDecimal op) {
		this.op = op;
	}

	public BigDecimal getSh() {
		return sh;
	}

	public void setSh(BigDecimal sh) {
		this.sh = sh;
	}

	public BigDecimal getSh1() {
		return sh1;
	}

	public void setSh1(BigDecimal sh1) {
		this.sh1 = sh1;
	}

	public BigDecimal getDev() {
		return dev;
	}

	public void setDev(BigDecimal dev) {
		this.dev = dev;
	}

	public String getRegional() {
		return this.regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

}