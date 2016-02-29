package com.miage.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
	@NamedQuery(name = "Reservations.findReservations",
	query = "select r from Reservations r where r.user.idUtilisateur = ?1"),
	@NamedQuery(name= "Reservations.findCars",
	query = "select r.car from Reservations r where r.user.idUtilisateur = ?1")
})
public class Reservations implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5368985851607807705L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idReservation;
	
	@OneToOne
	private Car car;
	
	@OneToOne
	private Users user;

	private String dateReservation;
	
	public Integer getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(String dateReservation) {
		this.dateReservation = dateReservation;
	}
	
	
	
}
