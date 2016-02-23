package com.miage.domain;


import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
		//return Base64.encode(vignette);
		return vignette;
	}

	public void setVignette(byte[] bVignette) {
		this.vignette = bVignette;
				//Base64.decode(bVignette);//   encodeBase64URLSafeString(bVignette);
	}
	
	   public static String encode(String value) throws Exception {
		      return  Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
		   }

		   public static String decode(String value) throws Exception {
		      byte[] decodedValue = Base64.getDecoder().decode(value);
		      return new String(decodedValue, StandardCharsets.UTF_8);
		   }

}