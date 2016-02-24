package com.miage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miage.domain.Car;
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
	
	@RequestMapping(value = "/summary", method = RequestMethod.GET)
	public String AccessSummary() {
		return "summary";
	}
	
	@RequestMapping(value = "/voiture", method = RequestMethod.GET)
	public String AccessVoiture(@RequestParam Integer id,Model model,RedirectAttributes redirectAttributes) {
		System.out.println("test");
		Car car = carRepository.findOne(id);
		model.addAttribute("car", car);
		return "voiture";
	}
	
	@RequestMapping(value = "/voiture", method = RequestMethod.POST)
	public String finalizeVoiture(@RequestParam Integer id,Car model,RedirectAttributes redirectAttributes) {
		Car car = new Car();
		car.setBrand(model.getBrand());
		car.setFuel(model.getFuel());
		car.setGearbox(model.getGearbox());
		car.setModel(model.getModel());
		car.setPower(model.getPower());
		car.setTransmission(model.getTransmission());
		car.setVignette(model.getVignette());
		carRepository.save(car);
		return "voiture";
	}
}
