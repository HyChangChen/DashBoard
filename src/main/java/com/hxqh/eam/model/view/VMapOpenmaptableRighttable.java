package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the V_MAP_OPENMAPTABLE_RIGHTTABLE database table.
 * 
 */
@Entity
@Table(name="V_MAP_OPENMAPTABLE_RIGHTTABLE")
public class VMapOpenmaptableRighttable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date dates;

	@Column(name="\"INTERFACE\"")
	private String interface_;

	@Column(name="NODE_ID")
	private String nodeId;

	@Id
	private BigDecimal rn;

	private String ruas;

	public VMapOpenmaptableRighttable() {
	}

	public Date getDates() {
		return this.dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

	public String getInterface_() {
		return this.interface_;
	}

	public void setInterface_(String interface_) {
		this.interface_ = interface_;
	}

	public String getNodeId() {
		return this.nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public BigDecimal getRn() {
		return this.rn;
	}

	public void setRn(BigDecimal rn) {
		this.rn = rn;
	}

	public String getRuas() {
		return this.ruas;
	}

	public void setRuas(String ruas) {
		this.ruas = ruas;
	}

}