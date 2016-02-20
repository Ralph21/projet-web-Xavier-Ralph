package com.miage.controllers;

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

import com.miage.domain.User_roles;
import com.miage.domain.Users;
import com.miage.repositories.User_rolesRepository;
import com.miage.repositories.UsersRepository;
import com.miage.services.UsersService;

@Controller
public class webController {

	private UsersService usersService;

	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	User_rolesRepository user_rolesRepository;
	
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
	
	@RequestMapping(value = "/voiture")
	public String AccessVoiture() {
		return "voiture";
	}
	
//	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
//	public String AccessInscription() {
//		return "inscription.html";
//	}
	
    @RequestMapping(value = "/gestionUsers", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("users", usersService.listAllUsers());
        return "gestionUsers";
    }
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String createUser(Model model,RedirectAttributes redirectAttributes) 
	{
		model.addAttribute("user", new Users());
		return "inscription";
	}
	
	

	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public String saveNewUser(Users user, RedirectAttributes redirectAttributes) 
	{
		user.setEnabled(1);
		User_roles role = new User_roles();
		role.setRole("ROLE_USER");
		role.setUsername(user.getEmail());
		user.setUsername(user.getEmail());
		usersRepository.save(user);
		user_rolesRepository.save(role);
		return "redirect:/index";
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
