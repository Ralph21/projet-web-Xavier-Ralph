package com.miage.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5851248576524551454L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idEquipement;
	
	String libelle;

	public Equipement() {
	}

	public Integer getIdEquipement() {
		return idEquipement;
	}

	public void setIdEquipement(Integer idEquipement) {
		this.idEquipement = idEquipement;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
}
