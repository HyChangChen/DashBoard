package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_DIG_18 database table.
 * 
 */
@Entity
@Table(name="V_DIG_18")
public class VDig18 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String ioc1;

	private BigDecimal ioc10;

	private String ioc11;

	private String ioc12;

	private String ioc13;

	private String ioc14;

	private String ioc2;

	private String ioc3;

	private BigDecimal ioc4;

	private String ioc5;

	private String ioc6;

	private String ioc7;

	private String ioc8;

	private String ioc9;

	public VDig18() {
	}

	public String getIoc1() {
		return this.ioc1;
	}

	public void setIoc1(String ioc1) {
		this.ioc1 = ioc1;
	}

	public BigDecimal getIoc10() {
		return this.ioc10;
	}

	public void setIoc10(BigDecimal ioc10) {
		this.ioc10 = ioc10;
	}

	public String getIoc11() {
		return this.ioc11;
	}

	public void setIoc11(String ioc11) {
		this.ioc11 = ioc11;
	}

	public String getIoc12() {
		return this.ioc12;
	}

	public void setIoc12(String ioc12) {
		this.ioc12 = ioc12;
	}

	public String getIoc13() {
		return this.ioc13;
	}

	public void setIoc13(String ioc13) {
		this.ioc13 = ioc13;
	}

	public String getIoc14() {
		return this.ioc14;
	}

	public void setIoc14(String ioc14) {
		this.ioc14 = ioc14;
	}

	public String getIoc2() {
		return this.ioc2;
	}

	public void setIoc2(String ioc2) {
		this.ioc2 = ioc2;
	}

	public String getIoc3() {
		return this.ioc3;
	}

	public void setIoc3(String ioc3) {
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

	public String getIoc6() {
		return this.ioc6;
	}

	public void setIoc6(String ioc6) {
		this.ioc6 = ioc6;
	}

	public String getIoc7() {
		return this.ioc7;
	}

	public void setIoc7(String ioc7) {
		this.ioc7 = ioc7;
	}

	public String getIoc8() {
		return this.ioc8;
	}

	public void setIoc8(String ioc8) {
		this.ioc8 = ioc8;
	}

	public String getIoc9() {
		return this.ioc9;
	}

	public void setIoc9(String ioc9) {
		this.ioc9 = ioc9;
	}

}