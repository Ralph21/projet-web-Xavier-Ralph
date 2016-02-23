package com.miage.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCar;
	
	@NotNull
	private String brand;

	@NotNull
	private String model;

//	 @OneToMany(cascade=CascadeType.ALL, mappedBy="customer")
//	 public Set<carImage>  images;

}