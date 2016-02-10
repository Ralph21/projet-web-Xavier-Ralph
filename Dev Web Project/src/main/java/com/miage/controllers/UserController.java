package com.miage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.miage.services.UtilisateurService;

@Controller
public class UserController extends WebMvcConfigurerAdapter {

	private UtilisateurService utilisateurService;

	@Autowired
	public void setProductService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/resultatInscription").setViewName("resultatInscription");
	}

	// @RequestMapping(value="/inscription", method=RequestMethod.GET)
	// public String showForm(Utilisateur utilisateur) {
	// return "inscription";
	// }

	// @RequestMapping(value="/utilisateurs", method=RequestMethod.GET)
	// public String showForm(Utilisateur utilisateur) {
	// return "utilisateurs";
	// }

	@RequestMapping("utilisateur/{id}")
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("utilisateur", utilisateurService.getUtilisateurById(id));
		return "utilisateursListe";
	}

	// @RequestMapping(value="/inscription", method=RequestMethod.POST)
	// public String checkPersonInfo(@Valid Utilisateur utilisateur,
	// BindingResult bindingResult) {
	//
	// if (bindingResult.hasErrors()) {
	// return "inscription";
	// }
	//
	// return "redirect:/resultatInscription";
	// }
}