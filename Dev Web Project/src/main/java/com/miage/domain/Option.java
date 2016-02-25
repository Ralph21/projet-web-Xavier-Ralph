package com.miage.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Option implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5851248576524551454L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idOption;
	
	String libelle;

	public Option() {
		super();
	}

	public Integer getIdOption() {
		return idOption;
	}

	public void setIdOption(Integer idOption) {
		this.idOption = idOption;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
}
