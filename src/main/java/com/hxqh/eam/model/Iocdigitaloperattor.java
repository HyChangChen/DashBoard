package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the IOCDIGITALOPERATTOR database table.
 * 
 */
@Entity
@Table(name="IOCDIGITALOPERATTOR")
public class Iocdigitaloperattor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ACH_OUTLOOK1")
	private String achOutlook1;

	@Column(name="ACH_OUTLOOK2")
	private String achOutlook2;

	private String ach1;

	private String ach2;

	@Column(name="AMOUNT_OUTLOOK1")
	private String amountOutlook1;

	@Column(name="AMOUNT_OUTLOOK2")
	private String amountOutlook2;

	private String filename;

	private String fy;

	@Column(name="FY_PERCENT")
	private String fyPercent;

	@Column(name="INSERT_DATE")
	private String insertDate;

	private String mom;

	@Column(name="PREV_MONTH")
	private String prevMonth;

	@Column(name="PREV_YEAR")
	private String prevYear;

	private String real1;

	private String real2;

	private String target1;

	private String target2;

	@Id
	@Column(name="\"TYPE\"")
	private String type;

	private String type2;

	private String unit;

	private String yoy;

	public Iocdigitaloperattor() {
	}

	public String getAchOutlook1() {
		return this.achOutlook1;
	}

	public void setAchOutlook1(String achOutlook1) {
		this.achOutlook1 = achOutlook1;
	}

	public String getAchOutlook2() {
		return this.achOutlook2;
	}

	public void setAchOutlook2(String achOutlook2) {
		this.achOutlook2 = achOutlook2;
	}

	public String getAch1() {
		return this.ach1;
	}

	public void setAch1(String ach1) {
		this.ach1 = ach1;
	}

	public String getAch2() {
		return this.ach2;
	}

	public void setAch2(String ach2) {
		this.ach2 = ach2;
	}

	public String getAmountOutlook1() {
		return this.amountOutlook1;
	}

	public void setAmountOutlook1(String amountOutlook1) {
		this.amountOutlook1 = amountOutlook1;
	}

	public String getAmountOutlook2() {
		return this.amountOutlook2;
	}

	public void setAmountOutlook2(String amountOutlook2) {
		this.amountOutlook2 = amountOutlook2;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFy() {
		return this.fy;
	}

	public void setFy(String fy) {
		this.fy = fy;
	}

	public String getFyPercent() {
		return this.fyPercent;
	}

	public void setFyPercent(String fyPercent) {
		this.fyPercent = fyPercent;
	}

	public String getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	public String getMom() {
		return this.mom;
	}

	public void setMom(String mom) {
		this.mom = mom;
	}

	public String getPrevMonth() {
		return this.prevMonth;
	}

	public void setPrevMonth(String prevMonth) {
		this.prevMonth = prevMonth;
	}

	public String getPrevYear() {
		return this.prevYear;
	}

	public void setPrevYear(String prevYear) {
		this.prevYear = prevYear;
	}

	public String getReal1() {
		return this.real1;
	}

	public void setReal1(String real1) {
		this.real1 = real1;
	}

	public String getReal2() {
		return this.real2;
	}

	public void setReal2(String real2) {
		this.real2 = real2;
	}

	public String getTarget1() {
		return this.target1;
	}

	public void setTarget1(String target1) {
		this.target1 = target1;
	}

	public String getTarget2() {
		return this.target2;
	}

	public void setTarget2(String target2) {
		this.target2 = target2;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType2() {
		return this.type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getYoy() {
		return this.yoy;
	}

	public void setYoy(String yoy) {
		this.yoy = yoy;
	}

}