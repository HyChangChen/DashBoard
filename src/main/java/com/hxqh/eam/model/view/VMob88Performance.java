package com.hxqh.eam.model.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the V_MOB_88_PERFORMANCE database table.
 * 
 */
@Entity
@Table(name="V_MOB_88_PERFORMANCE")
public class VMob88Performance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String regional;

	public VMob88Performance() {
	}

	public String getRegional() {
		return this.regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

}