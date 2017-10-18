package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OPENSTREETMAP database table.
 * 
 */
@Entity
@Table(name = "OPENSTREETMAP")
public class Openstreetmap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OPENSTREETMAP_OPENSTREETMAPID_GENERATOR", sequenceName="OPENSTREETMAP_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OPENSTREETMAP_OPENSTREETMAPID_GENERATOR")
	private String openstreetmapid;

	private String description;

	private String mapx;

	private String mapy;

	private String name;

	@Column(name="\"TYPE\"")
	private String type;

	public Openstreetmap() {
	}

	public String getOpenstreetmapid() {
		return this.openstreetmapid;
	}

	public void setOpenstreetmapid(String openstreetmapid) {
		this.openstreetmapid = openstreetmapid;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}