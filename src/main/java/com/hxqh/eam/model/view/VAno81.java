package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the V_ANO_81 database table.
 * 
 */
@Entity
@Table(name="V_ANO_81")
public class VAno81 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer rn;

	private String ioc1;

	private String ioc2;

	private String ioc3;

	private String ioc4;

	private String ioc5;

	private String ioc6;

	private String ioc7;

	private String downunit;



	public VAno81() {
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

	public String getIoc4() {
		return this.ioc4;
	}

	public void setIoc4(String ioc4) {
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

	public String getDownunit() {
		return downunit;
	}

	public void setDownunit(String downunit) {
		this.downunit = downunit;
	}
}