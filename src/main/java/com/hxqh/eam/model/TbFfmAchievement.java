package com.hxqh.eam.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the TB_FFM_ACHIEVEMENT database table.
 * 
 */
@Entity
@Table(name="TB_IOC_PRO_TICKET_FFM")
public class TbFfmAchievement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_FFM_ACHIEVEMENT_FFMACHIEVEMENTID_GENERATOR", sequenceName="SEQ_TB_FFM_ACHIEVEMENT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_FFM_ACHIEVEMENT_FFMACHIEVEMENTID_GENERATOR")
	private long ffmachievementid;

	@Temporal(TemporalType.DATE)
	private Date adddate;

	private String hari;

	private String jam;

	private String jumlah;

	private String keterangan;

	public TbFfmAchievement() {
	}

	public long getFfmachievementid() {
		return this.ffmachievementid;
	}

	public void setFfmachievementid(long ffmachievementid) {
		this.ffmachievementid = ffmachievementid;
	}

	public Date getAdddate() {
		return this.adddate;
	}

	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}

	public String getHari() {
		return this.hari;
	}

	public void setHari(String hari) {
		this.hari = hari;
	}

	public String getJam() {
		return this.jam;
	}

	public void setJam(String jam) {
		this.jam = jam;
	}

	public String getJumlah() {
		return this.jumlah;
	}

	public void setJumlah(String jumlah) {
		this.jumlah = jumlah;
	}

	public String getKeterangan() {
		return this.keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

}