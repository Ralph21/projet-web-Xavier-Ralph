package com.miage.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import org.apache.commons.codec.binary.Base64;


@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCar;
	
	@NotNull
	private String brand;

	@NotNull
	private String model;

	@Lob
	private byte[]  vignette;
	
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
	
	public String generateBase64Image()
	{
	    return Base64.encodeBase64String(this.getVignette());
	}




}