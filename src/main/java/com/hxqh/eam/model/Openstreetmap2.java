package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OPENSTREETMAP2 database table.
 * 
 */
@Entity
@Table(name = "OPENSTREETMAP2")
public class Openstreetmap2 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String description;

	private String mapx;

	private String mapy;

	private String name;

	@Id
	private String openstreetmapid;

	@Column(name="\"TYPE\"")
	private String type;

	public Openstreetmap2() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMapx() {
		return this.mapx;
	}

	public void setMapx(String mapx) {
		this.mapx = mapx;
	}

	public String getMapy() {
		return this.mapy;
	}

	public void setMapy(String mapy) {
		this.mapy = mapy;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpenstreetmapid() {
		return this.openstreetmapid;
	}

	public void setOpenstreetmapid(String openstreetmapid) {
		this.openstreetmapid = openstreetmapid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}