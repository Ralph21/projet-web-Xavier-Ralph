package com.miage.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miage.domain.Car;
import com.miage.repositories.CarRepository;
import com.miage.repositories.User_rolesRepository;
import com.miage.repositories.UsersRepository;


@Controller
public class webController {
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	CarRepository carRepository; 
	
	@Autowired
	User_rolesRepository user_rolesRepository;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String AccessIndex(Model model,RedirectAttributes redirectAttributes) {
		List<Car> cars = (List<Car>) carRepository.findAll();
		model.addAttribute("cars", cars);
		return "index";
	}


	@RequestMapping("/")
	public String retourIndex(Model model,RedirectAttributes redirectAttributes) {
		List<Car> cars = (List<Car>) carRepository.findAll();
		model.addAttribute("cars", cars);
		return "index";
	}
	
	@RequestMapping(value = "/contact")
	public String AccessContact() {
		return "test";
	}
	
	@RequestMapping(value = "/voiture")
	public String AccessVoiture() {
		return "voiture";
	}
	
	@RequestMapping(value = "/informations")
	public String AccessInformations() {
		return "informations";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/";
	}

}
