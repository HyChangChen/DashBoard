package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the HX_AUTHGROUP_MENU database table.
 * 
 */
@Entity
@Table(name="HX_AUTHGROUP_MENU")
public class HxAuthgroupMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	private String description;

	@Id
	private String groupid;

	private String id;

	private String menuid;

	private String menuname;

	private BigDecimal menuorder;

	private String menutxt;

	public HxAuthgroupMenu() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenuid() {
		return this.menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getMenuname() {
		return this.menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public BigDecimal getMenuorder() {
		return this.menuorder;
	}

	public void setMenuorder(BigDecimal menuorder) {
		this.menuorder = menuorder;
	}

	public String getMenutxt() {
		return this.menutxt;
	}

	public void setMenutxt(String menutxt) {
		this.menutxt = menutxt;
	}

}