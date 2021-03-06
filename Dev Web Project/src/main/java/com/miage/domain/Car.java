package com.miage.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
	@NamedQuery(name = "Car.findByBrand",
	query = "select c from Car c where c.brand = ?1"),
	@NamedQuery(name = "Car.findByCarId",
	query = "select c.equipements from Car c where c.id = ?1"),
	@NamedQuery(name = "Car.findByModel",
	query = "select c.equipements from Car c where c.model = ?1 and c.base = 1")
})
public class Car implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4791820351664305590L;

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

	private boolean base;

	private String vignette;

	@OneToMany(fetch=FetchType.EAGER)
    private List<Equipement> equipements =new ArrayList<Equipement>();


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
	
	public Integer getPower() {
		return power;
	}

	public String getVignette() {
		return vignette;
	}

	public void setVignette(String vignette) {
		this.vignette = vignette;
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

	public List<Equipement> getEquipements() {
		return equipements;
	}

	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}

	public boolean isBase() {
		return base;
	}

	public void setBase(boolean base) {
		this.base = base;
	}

	

//	public void addOption(Option option) {
//		this.options.add(option);
//	}
//	
//	public List<Option> getOptions(){
//		return this.options;
//	}
//	
//	public void delOption(Option option){
//		this.options.remove(option);
//	}
}