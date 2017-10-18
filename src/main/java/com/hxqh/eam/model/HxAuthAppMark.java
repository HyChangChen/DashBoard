package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HX_AUTH_APP_MARK database table.
 * 
 */
@Entity
@Table(name="HX_AUTH_APP_MARK")
public class HxAuthAppMark implements Serializable {
	private static final long serialVersionUID = 1L;

	private String appid;

	@Id
	private String authappid;

	private String description;

	private String id;

	private String menuclass;

	private String menuid;

	private String menuname;

	public HxAuthAppMark() {
	}

	public String getAppid() {
		return this.appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAuthappid() {
		return this.authappid;
	}

	public void setAuthappid(String authappid) {
		this.authappid = authappid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenuclass() {
		return this.menuclass;
	}

	public void setMenuclass(String menuclass) {
		this.menuclass = menuclass;
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

}