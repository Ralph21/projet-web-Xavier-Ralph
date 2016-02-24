package com.miage.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.apache.commons.codec.binary.Base64;


@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCar;
	
	private String brand;
	
	private Integer power;
	
	private String fuel;
	
	private String transmission;
	
	private String gearbox;
	
	private String paint;

	private String model;

	private String wheels;
	
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

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getGearbox() {
		return gearbox;
	}

	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}

	public String getPaint() {
		return paint;
	}

	public void setPaint(String paint) {
		this.paint = paint;
	}

	public String getWheels() {
		return wheels;
	}

	public void setWheels(String wheels) {
		this.wheels = wheels;
	}

	
	
}