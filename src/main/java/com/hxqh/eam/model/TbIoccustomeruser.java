package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TB_IOCCUSTOMERUSER database table.
 * 
 */
@Entity
@Table(name="TB_IOCCUSTOMERUSER")
public class TbIoccustomeruser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_IOCCUSTOMERUSER_IOCCUSTOMERUSERID_GENERATOR", sequenceName="SEQ_TB_IOCCUSTOMERUSER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_IOCCUSTOMERUSER_IOCCUSTOMERUSERID_GENERATOR")
	private long ioccustomeruserid;

	@Temporal(TemporalType.DATE)
	private Date adddate;

	@Column(name="CUST_ABBREV")
	private String custAbbrev;

	@Column(name="CUST_NAME")
	private String custName;

	private String div;

	@Column(name="GRP_CUST")
	private String grpCust;

	private String lvl;

	public TbIoccustomeruser() {
	}

	public long getIoccustomeruserid() {
		return this.ioccustomeruserid;
	}

	public void setIoccustomeruserid(long ioccustomeruserid) {
		this.ioccustomeruserid = ioccustomeruserid;
	}

	public Date getAdddate() {
		return this.adddate;
	}

	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}

	public String getCustAbbrev() {
		return this.custAbbrev;
	}

	public void setCustAbbrev(String custAbbrev) {
		this.custAbbrev = custAbbrev;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getDiv() {
		return this.div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

	public String getGrpCust() {
		return this.grpCust;
	}

	public void setGrpCust(String grpCust) {
		this.grpCust = grpCust;
	}

	public String getLvl() {
		return this.lvl;
	}

	public void setLvl(String lvl) {
		this.lvl = lvl;
	}

}