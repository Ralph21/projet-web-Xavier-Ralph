package com.miage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class User_rolesController extends WebMvcConfigurerAdapter {

//	private User_rolesService user_rolesService;

	//TODO : mettre les controllers relatifs à un role ici.
	
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