package com.miage.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class webController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String AccessIndex(Model model,RedirectAttributes redirectAttributes) {
		return "index";
	}


	@RequestMapping("/")
	public String retourIndex(Model model,RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("login");
		return "index";
	}


	@RequestMapping(value = "/contact")
	public String AccessContact() {
		return "contact";
	}
	
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String AccessInscription() {
		return "inscription.html";
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
//	    return "redirect:/index?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}

}
