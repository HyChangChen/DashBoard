package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the V_MAP_OPENMAPLINES database table.
 * 
 */
@Entity
@Table(name="V_MAP_OPENMAPLINES")
public class VMapOpenmapline implements Serializable {
	private static final long serialVersionUID = 1L;

	private String color;

	@Column(name="FROM_X")
	private String fromX;

	@Column(name="FROM_Y")
	private String fromY;

	@Id
	private BigDecimal rn;

	@Column(name="TO_X")
	private String toX;

	@Column(name="TO_Y")
	private String toY;

//	private Date adddate;



	public VMapOpenmapline() {
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFromX() {
		return this.fromX;
	}

	public void setFromX(String fromX) {
		this.fromX = fromX;
	}

	public String getFromY() {
		return this.fromY;
	}

	public void setFromY(String fromY) {
		this.fromY = fromY;
	}

	public BigDecimal getRn() {
		return this.rn;
	}

	public void setRn(BigDecimal rn) {
		this.rn = rn;
	}

	public String getToX() {
		return this.toX;
	}

	public void setToX(String toX) {
		this.toX = toX;
	}

	public String getToY() {
		return this.toY;
	}

	public void setToY(String toY) {
		this.toY = toY;
	}

}