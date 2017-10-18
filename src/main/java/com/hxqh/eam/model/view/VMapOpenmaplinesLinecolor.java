package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the V_MAP_OPENMAPLINES_LINECOLOR database table.
 * 
 */
@Entity
@Table(name="V_MAP_OPENMAPLINES_LINECOLOR")
public class VMapOpenmaplinesLinecolor implements Serializable {
	private static final long serialVersionUID = 1L;

	private String linecolor;

	@Id
	private BigDecimal rn;

	public VMapOpenmaplinesLinecolor() {
	}

	public String getLinecolor() {
		return this.linecolor;
	}

	public void setLinecolor(String linecolor) {
		this.linecolor = linecolor;
	}

	public BigDecimal getRn() {
		return this.rn;
	}

	public void setRn(BigDecimal rn) {
		this.rn = rn;
	}

}