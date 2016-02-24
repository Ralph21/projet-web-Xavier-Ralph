package com.miage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miage.repositories.CarRepository;
import com.miage.services.CarService;

@Controller
@ComponentScan("com.miage.services")
public class CarController {

	@Autowired
	CarRepository carRepository;
	
	private CarService carService;
	
	@Autowired
	public void setCarService(CarService carService){
		this.carService = carService;
	}
	
	
	@RequestMapping(value = "/summary")
	public String AccessSummary() {
		return "summary";
	}
}
