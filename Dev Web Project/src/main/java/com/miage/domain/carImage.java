package com.miage.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class carImage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idcI;
	
	@NotNull
	@Lob
	private byte[] picture;

	public Integer getIdcI() {
		return idcI;
	}

	public void setIdcI(Integer idcI) {
		this.idcI = idcI;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	
}
