package com.hxqh.eam.model.dto;

public class Mob92PercentDto {

	private String greennum;

	private String id;

	private String orangenum;

	private String rednum;

	public Mob92PercentDto() {
	}

	public Mob92PercentDto(String greennum, String id, String orangenum, String rednum) {
		this.greennum = greennum;
		this.id = id;
		this.orangenum = orangenum;
		this.rednum = rednum;
	}

	public String getGreennum() {
		return greennum;
	}

	public void setGreennum(String greennum) {
		this.greennum = greennum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrangenum() {
		return orangenum;
	}

	public void setOrangenum(String orangenum) {
		this.orangenum = orangenum;
	}

	public String getRednum() {
		return rednum;
	}

	public void setRednum(String rednum) {
		this.rednum = rednum;
	}
}
