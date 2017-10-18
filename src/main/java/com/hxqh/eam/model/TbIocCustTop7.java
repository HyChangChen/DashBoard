package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TB_IOC_CUST_TOP7 database table.
 * 
 */
@Entity
@Table(name="TB_IOC_CUST_TOP7")
public class TbIocCustTop7 implements Serializable {
	private static final long serialVersionUID = 1L;


	private String custid;

	private String custname;

	private String custrank;

	private String custtype;

	private String filename;

	@Id
	private String ioccustomerusertop7id;

	private String loginpath;

	private String name;

	private String ts;

	public TbIocCustTop7() {
	}

	public String getCustid() {
		return this.custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return this.custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getCustrank() {
		return this.custrank;
	}

	public void setCustrank(String custrank) {
		this.custrank = custrank;
	}

	public String getCusttype() {
		return this.custtype;
	}

	public void setCusttype(String custtype) {
		this.custtype = custtype;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getIoccustomerusertop7id() {
		return this.ioccustomerusertop7id;
	}

	public void setIoccustomerusertop7id(String ioccustomerusertop7id) {
		this.ioccustomerusertop7id = ioccustomerusertop7id;
	}

	public String getLoginpath() {
		return this.loginpath;
	}

	public void setLoginpath(String loginpath) {
		this.loginpath = loginpath;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

}