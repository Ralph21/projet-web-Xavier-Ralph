package com.miage.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User_roles {
	
	@Id
	private Integer idRole;
	
	private String role;
	
	private int utilisateurId;
	
	private String username;
//	private Users utilisateur;

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUtilisateur() {
		return utilisateurId;
	}

	public void setUtilisateur(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public int getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
//	public Users getUtilisateur() {
//		return utilisateur;
//	}
//
//	public void setUtilisateur(Users utilisateur) {
//		this.utilisateur = utilisateur;
//	}


	
	
}
