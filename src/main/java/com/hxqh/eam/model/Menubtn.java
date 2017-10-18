package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MENUBTNS database table.
 * 
 */
@Entity
@Table(name="MENUBTNS")
public class Menubtn implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal btnorder;

	private String event;

	private String iconclass;

	@Id
	private String menubtnsid;

	private String name;

	private String optionname;

	private String txt;

	@Column(name="\"TYPE\"")
	private String type;

	private BigDecimal typeorder;

	public Menubtn() {
	}

	public BigDecimal getBtnorder() {
		return this.btnorder;
	}

	public void setBtnorder(BigDecimal btnorder) {
		this.btnorder = btnorder;
	}

	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getIconclass() {
		return this.iconclass;
	}

	public void setIconclass(String iconclass) {
		this.iconclass = iconclass;
	}

	public String getMenubtnsid() {
		return this.menubtnsid;
	}

	public void setMenubtnsid(String menubtnsid) {
		this.menubtnsid = menubtnsid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOptionname() {
		return this.optionname;
	}

	public void setOptionname(String optionname) {
		this.optionname = optionname;
	}

	public String getTxt() {
		return this.txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getTypeorder() {
		return this.typeorder;
	}

	public void setTypeorder(BigDecimal typeorder) {
		this.typeorder = typeorder;
	}

}