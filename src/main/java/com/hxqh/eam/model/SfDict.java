package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SF_DICT database table.
 * 
 */
@Entity
@Table(name="SF_DICT")
public class SfDict implements Serializable {
	private static final long serialVersionUID = 1L;

	private String description;

	private BigDecimal dictmark;

	@Id
	private String id;

	private String name;

	private BigDecimal oorder;

	private String parentid;

	private String text;

	public SfDict() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getDictmark() {
		return this.dictmark;
	}

	public void setDictmark(BigDecimal dictmark) {
		this.dictmark = dictmark;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getOorder() {
		return this.oorder;
	}

	public void setOorder(BigDecimal oorder) {
		this.oorder = oorder;
	}

	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}