package com.miage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.miage.services.User_rolesService;

@Controller
public class User_rolesController extends WebMvcConfigurerAdapter {

	private User_rolesService user_rolesService;

//	@Autowired
//	@Qualifier("User_roles")
//	public void setUtilisateurService(User_rolesService user_rolesService) {
//		this.roleService = user_rolesService;
//	}

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/resultatInscription").setViewName("resultatInscription");
//	}

	// @RequestMapping(value="/inscription", method=RequestMethod.GET)
	// public String showForm(Users utilisateur) {
	// return "inscription";
	// }

	// @RequestMapping(value="/utilisateurs", method=RequestMethod.GET)
	// public String showForm(Users utilisateur) {
	// return "utilisateurs";
	// }

//	@RequestMapping("role/{id}")
//	public String showProduct(@PathVariable Integer id, Model model) {
//		model.addAttribute("role", user_rolesService.getRoleById(id));
//		return "roleListe";
//	}

	// @RequestMapping(value="/inscription", method=RequestMethod.POST)
	// public String checkPersonInfo(@Valid Users utilisateur,
	// BindingResult bindingResult) {
	//
	// if (bindingResult.hasErrors()) {
	// return "inscription";
	// }
	//
	// return "redirect:/resultatInscription";
	// }
}