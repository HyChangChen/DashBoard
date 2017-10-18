package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SF_MY_PORTAL_LAYOUT database table.
 * 
 */
@Entity
@Table(name="SF_MY_PORTAL_LAYOUT")
public class SfMyPortalLayout implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Lob
	private String layoutlob;

	public SfMyPortalLayout() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLayoutlob() {
		return this.layoutlob;
	}

	public void setLayoutlob(String layoutlob) {
		this.layoutlob = layoutlob;
	}

}