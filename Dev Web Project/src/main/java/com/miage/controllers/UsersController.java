package com.miage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.miage.services.UsersService;

@Controller
@ComponentScan("com.miage.services")
public class UsersController extends WebMvcConfigurerAdapter {

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

//	 @RequestMapping(value="/inscription", method=RequestMethod.GET)
//	 public String showForm(Users utilisateur) {
//	 return "inscription";
//	 }

	// @RequestMapping(value="/utilisateurs", method=RequestMethod.GET)
	// public String showForm(Users utilisateur) {
	// return "utilisateurs";
	// }

	@RequestMapping("utilisateur/{id}")
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("utilisateur", usersService.getUtilisateurById(id));
		return "utilisateursListe";
	}
	
//    @RequestMapping(value = {"/inscription/save"}, method = RequestMethod.POST)
//    public String saveEmployee(@ModelAttribute("users") Users users, final RedirectAttributes redirectAttributes) {
//    	usersRepository.save(users);
//        return "redirect:/";
//    }

//	 @RequestMapping(value="/inscription", method=RequestMethod.POST)
//	 public String checkPersonInfo(@Valid Users utilisateur,
//	 BindingResult bindingResult) {
//	
//	 if (bindingResult.hasErrors()) {
//	 return "inscription";
//	 }
//	
//	 return "redirect:/resultatInscription";
//	 }
}