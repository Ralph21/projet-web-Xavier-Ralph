package com.miage;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author xababa_mac
 *
 */
@Entity
public class car implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	@GeneratedValue
	@Id
	protected long id;
	
	protected String marque;
	protected String modele;
	

	
	public long getId() {
		return id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}
	
	public car() {
		super();
	}

	public car(long id, String modele, String marque) {
		super();
		this.id = id;
		this.modele = modele;
		this.marque = marque;
	}
	
	public car(String modele, String marque) {
		super();
		this.modele = modele;
		this.marque = marque;
	}
	

}
