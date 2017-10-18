package com.hxqh.eam.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the TB_FFM database table.
 * 
 */
@Entity
@Table(name="TB_IOC_PRO_TICKET")
public class TbFfm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_FFM_FMMID_GENERATOR", sequenceName="SEQ_TB_FFM")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_FFM_FMMID_GENERATOR")
	private long fmmid;

	@Temporal(TemporalType.DATE)
	private Date adddate;

	private String jumlah;

	private String keterangan;

	public TbFfm() {
	}

	public long getFmmid() {
		return this.fmmid;
	}

	public void setFmmid(long fmmid) {
		this.fmmid = fmmid;
	}

	public Date getAdddate() {
		return this.adddate;
	}

	public void setAdddate(Date adddate) {
		this.adddate = adddate;
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