package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SF_ORGANIZATION_USER_LOB database table.
 * 
 */
@Entity
@Table(name="SF_ORGANIZATION_USER_LOB")
public class SfOrganizationUserLob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Lob
	private byte[] photo;

	public SfOrganizationUserLob() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}