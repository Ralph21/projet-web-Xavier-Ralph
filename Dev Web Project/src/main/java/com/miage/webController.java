package com.miage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class webController {

	@Autowired
	carRepository car_bdd;

	/**
	 * Lors de l'appel du chemin /index, lance index.html
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String AccessIndex(Model model,RedirectAttributes redirectAttributes) {
		
		//avant d'afficher la page index on récupère tous les car de la BDD
		List<car> car = (List<car>) car_bdd.findAll();
		model.addAttribute("car_list", car);
		
		return "index";
	}

	/**
	 * par default, lance la page index.html
	 */
	@RequestMapping("/")
	public String retourIndex(Model model,RedirectAttributes redirectAttributes) {
		
		//avant d'afficher la page index on récupère tous les car de la BDD
		List<car> car = (List<car>) car_bdd.findAll();
		model.addAttribute("car_list", car);
		return "index";
	}

	/**
	 * Lors de l'appel du chemin /index, lance index.html
	 */
	@RequestMapping(value = "/contact")
	public String AccessContact() {
		return "contact";
	}
	
	@RequestMapping(value = "/informations")
	public String AccessInformations() {
		return "informations";
	}

}
