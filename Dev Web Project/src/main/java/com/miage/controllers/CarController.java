package com.miage.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miage.domain.Car;
import com.miage.domain.Equipement;
import com.miage.domain.Reservations;
import com.miage.domain.Users;
import com.miage.repositories.CarRepository;
import com.miage.repositories.EquipementRepository;
import com.miage.repositories.ReservationsRepository;
import com.miage.repositories.UsersRepository;

@Controller
@ComponentScan("com.miage.services")
public class CarController {

	@Autowired
	CarRepository carRepository;
	
	@Autowired
	EquipementRepository equipementRepository;
	
	@Autowired
	UsersRepository userRepository;

	@Autowired
	ReservationsRepository reservationRepository;
	
	@RequestMapping(value = "/summary", method = RequestMethod.GET)
	public String AccessSummary(@RequestParam Integer id,Model model,RedirectAttributes redirectAttributes) {
		Car car = carRepository.findOne(id);
		model.addAttribute("car", car);
		Reservations reservation = new Reservations();
		User usr = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users user = userRepository.findByUserName(usr.getUsername());
		reservation.setUser(user);
		reservation.setCar(car);
		model.addAttribute("reservation", reservation);
		return "summary";
	}
	
	@RequestMapping(value = "/summary", method = RequestMethod.POST)
	public String valideReservation(@RequestParam Integer id,@ModelAttribute Reservations reservation, Model model,RedirectAttributes redirectAttributes) {
		reservationRepository.save(reservation);
		return "redirect:/validation";
	}
	
	@RequestMapping(value = "/validation")
	public String validation() {
		return "validation";
	}
	
	@RequestMapping(value = "/voiture", method = RequestMethod.GET)
	public String AccessVoiture(@RequestParam Integer id,Model model,RedirectAttributes redirectAttributes) {
		Car car = carRepository.findOne(id);
		model.addAttribute("car", car);
		return "voiture";
	}
	
	@RequestMapping(value = "/voiture", method = RequestMethod.POST)
	public String finalizeVoiture(@RequestParam Integer id,@ModelAttribute Car base, RedirectAttributes redirectAttributes) {
		Car car = new Car();
		car.setFuel(base.getFuel());
		car.setBrand(base.getBrand());
		car.setGearbox(base.getGearbox());
		car.setModel(base.getModel());
		car.setPower(base.getPower());
		car.setTransmission(base.getTransmission());
		car.setVignette(base.getVignette());
		car.setPaint(base.getPaint());
		car.setWheels(base.getWheels());
		ArrayList<Equipement> choisis = new ArrayList<>();
		for(Equipement equipement : base.getEquipements()){
			Equipement e = new Equipement();
			e.setLibelle(equipement.getLibelle());
			equipementRepository.save(e);
			choisis.add(e);
		}
		car.setEquipements(choisis);
		car.setBase(false);
		carRepository.save(car);
		return new String("redirect:/summary?id="+car.getIdCar());
	}
}
