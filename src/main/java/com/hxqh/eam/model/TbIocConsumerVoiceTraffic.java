package com.hxqh.eam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TB_IOC_CONSUMER_VOICE_TRAFFIC database table.
 * 
 */
@Entity
@Table(name="TB_IOC_CONSUMER_VOICE_TRAFFIC")
public class TbIocConsumerVoiceTraffic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_IOC_CONSUMER_VOICE_TRAFFIC_VOICID_GENERATOR", sequenceName="SEQ_TB_CONSUMER_VOICE_TRAFFIC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_IOC_CONSUMER_VOICE_TRAFFIC_VOICID_GENERATOR")
	@Column(name="VOIC_ID")
	private long voicId;

	private BigDecimal answ;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_TIMES")
	private Date dateTimes;

	private BigDecimal iansw;

	private BigDecimal iseiz;

	private String node;

	private BigDecimal oansw;

	private BigDecimal oseiz;

	private BigDecimal seiz;

	private String ts;

	public TbIocConsumerVoiceTraffic() {
	}

	public long getVoicId() {
		return this.voicId;
	}

	public void setVoicId(long voicId) {
		this.voicId = voicId;
	}

	public BigDecimal getAnsw() {
		return this.answ;
	}

	public void setAnsw(BigDecimal answ) {
		this.answ = answ;
	}

	public Date getDateTimes() {
		return this.dateTimes;
	}

	public void setDateTimes(Date dateTimes) {
		this.dateTimes = dateTimes;
	}

	public BigDecimal getIansw() {
		return this.iansw;
	}

	public void setIansw(BigDecimal iansw) {
		this.iansw = iansw;
	}

	public BigDecimal getIseiz() {
		return this.iseiz;
	}

	public void setIseiz(BigDecimal iseiz) {
		this.iseiz = iseiz;
	}

	public String getNode() {
		return this.node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public BigDecimal getOansw() {
		return this.oansw;
	}

	public void setOansw(BigDecimal oansw) {
		this.oansw = oansw;
	}

	public BigDecimal getOseiz() {
		return this.oseiz;
	}

	public void setOseiz(BigDecimal oseiz) {
		this.oseiz = oseiz;
	}

	public BigDecimal getSeiz() {
		return this.seiz;
	}

	public void setSeiz(BigDecimal seiz) {
		this.seiz = seiz;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

}