package com.miage.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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

	@NotNull
	@Lob
	private byte[] vignette; 
	
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="customer")
//	public Set<carImage>  images;
	
	public Car() {
	}

	public Integer getIdCar() {
		return idCar;
	}

	public void setIdCar(Integer idCar) {
		this.idCar = idCar;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

//	public Set<carImage> getImages() {
//		return images;
//	}
//
//	public void setImages(Set<carImage> images) {
//		this.images = images;
//	}

	public byte[] getVignette() {
		return vignette;
	}

	public void setVignette(byte[] vignette) {
		this.vignette = vignette;
	}

	
}