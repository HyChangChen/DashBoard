package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MENU database table.
 * 
 */
@Entity
@Table(name = "MENU")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	private String accesskey;

	private String elementtype;

	private String headerdescription;

	private String images;

	private String keyvalue;

	private String menuclass;

	@Id
	private String menuid;

	private BigDecimal menuorder;

	private String menupower;

	private String menupowershow;

	private String menutype;

	private String moduleapp;

	private String moduleappch;

	private String modulename;

	private String parent;

	@Column(name="\"POSITION\"")
	private String position;

	private String subposition;

	private String tabdisplay;

	private String url;

	private String visible;

	public Menu() {
	}

	public String getAccesskey() {
		return this.accesskey;
	}

	public void setAccesskey(String accesskey) {
		this.accesskey = accesskey;
	}

	public String getElementtype() {
		return this.elementtype;
	}

	public void setElementtype(String elementtype) {
		this.elementtype = elementtype;
	}

	public String getHeaderdescription() {
		return this.headerdescription;
	}

	public void setHeaderdescription(String headerdescription) {
		this.headerdescription = headerdescription;
	}

	public String getImages() {
		return this.images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getKeyvalue() {
		return this.keyvalue;
	}

	public void setKeyvalue(String keyvalue) {
		this.keyvalue = keyvalue;
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

	public BigDecimal getMenuorder() {
		return this.menuorder;
	}

	public void setMenuorder(BigDecimal menuorder) {
		this.menuorder = menuorder;
	}

	public String getMenupower() {
		return this.menupower;
	}

	public void setMenupower(String menupower) {
		this.menupower = menupower;
	}

	public String getMenupowershow() {
		return this.menupowershow;
	}

	public void setMenupowershow(String menupowershow) {
		this.menupowershow = menupowershow;
	}

	public String getMenutype() {
		return this.menutype;
	}

	public void setMenutype(String menutype) {
		this.menutype = menutype;
	}

	public String getModuleapp() {
		return this.moduleapp;
	}

	public void setModuleapp(String moduleapp) {
		this.moduleapp = moduleapp;
	}

	public String getModuleappch() {
		return this.moduleappch;
	}

	public void setModuleappch(String moduleappch) {
		this.moduleappch = moduleappch;
	}

	public String getModulename() {
		return this.modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

	public String getParent() {
		return this.parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSubposition() {
		return this.subposition;
	}

	public void setSubposition(String subposition) {
		this.subposition = subposition;
	}

	public String getTabdisplay() {
		return this.tabdisplay;
	}

	public void setTabdisplay(String tabdisplay) {
		this.tabdisplay = tabdisplay;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVisible() {
		return this.visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

}