package com.miage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miage.domain.Users;
import com.miage.repositories.UsersRepository;
import com.miage.services.UsersService;

@Controller
@ComponentScan("com.miage.services")
public class UsersController extends WebMvcConfigurerAdapter {

	
	@Autowired
	UsersRepository usersRepository;
	
	private UsersService usersService;

	//TODO : mettre controllers relatifs à un user ici.
	
	@Autowired
	public void setUtilisateurService(UsersService usersService) {
		this.usersService = usersService;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/resultatInscription").setViewName("resultatInscription");
	}
	
    @RequestMapping(value = "/gestionUsers", method = RequestMethod.GET)
    public String list(Model model){
		List<Users> users = (List<Users>) usersRepository.findAll();
		model.addAttribute("users", users);
        return "gestionUsers";
    }
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String createUser(Model model,RedirectAttributes redirectAttributes) 
	{
		model.addAttribute("user", new Users());
		return "inscription";
	}
	
    @RequestMapping("/remove/{id}")
    public String deleteUser(@PathVariable("id") Integer userID,RedirectAttributes redirectAttributes)
    {
    	usersRepository.delete(userID);
    	return "index";
    }

	@RequestMapping("utilisateur/{id}")
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("utilisateur", usersService.getUtilisateurById(id));
		return "utilisateursListe";
	}

}