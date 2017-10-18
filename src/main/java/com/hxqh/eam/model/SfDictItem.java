package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SF_DICT_ITEM database table.
 * 
 */
@Entity
@Table(name="SF_DICT_ITEM")
public class SfDictItem implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codeno;

	@Temporal(TemporalType.DATE)
	private Date createdate;

	private String description;

	private String dictid;

	@Id
	private String id;

	private BigDecimal itemmark;

	private BigDecimal oorder;

	private String parentid;

	private String text;

	private String userid;

	public SfDictItem() {
	}

	public String getCodeno() {
		return this.codeno;
	}

	public void setCodeno(String codeno) {
		this.codeno = codeno;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDictid() {
		return this.dictid;
	}

	public void setDictid(String dictid) {
		this.dictid = dictid;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getItemmark() {
		return this.itemmark;
	}

	public void setItemmark(BigDecimal itemmark) {
		this.itemmark = itemmark;
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

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}