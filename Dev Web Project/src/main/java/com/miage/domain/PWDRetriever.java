package com.miage.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PWDRetriever {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPWDRetriever; 
	
	private String email;
	
	Integer counter;
	
	Long tempCode;
	
	Long checkCode;
	
	String mdp;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	public Long getTempCode() {
		return tempCode;
	}

	public void setTempCode(Long tempCode) {
		this.tempCode = tempCode;
	}
	
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public PWDRetriever() {
		super();
		counter=0;
	}

	public Long getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(Long checkCode) {
		this.checkCode = checkCode;
	}

	public Integer getIdPWDRetriever() {
		return idPWDRetriever;
	}

	
	
}
