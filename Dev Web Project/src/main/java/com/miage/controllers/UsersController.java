package com.miage.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miage.domain.User_roles;
import com.miage.domain.Users;
import com.miage.repositories.User_rolesRepository;
import com.miage.repositories.UsersRepository;
import com.miage.services.UsersService;


@Controller
@ComponentScan("com.miage.services")
public class UsersController extends WebMvcConfigurerAdapter {

	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	User_rolesRepository user_rolesRepository;
	
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
	
    @RequestMapping(value = "/modification", method = RequestMethod.GET)
    public String modifierUser(@RequestParam Integer id, Model model,RedirectAttributes redirectAttributes)
    {
    	Users user = usersRepository.findOne(id);
    	model.addAttribute("user", user);
    	return "modification";
    }
	
    @RequestMapping(value = "/modification", method = RequestMethod.POST)
    public String saveModifUser(@RequestParam Integer id, Users user, RedirectAttributes redirectAttributes)
    {
    	
    	Users nUser= usersRepository.findOne(id);
    	nUser.setAge(user.getAge());
//    	nUser.setEmail(user.getEmail());
    	nUser.setFirstName(user.getFirstName());
    	nUser.setLastName(user.getLastName());
//    	nUser. setPasswordEncode(user.getPassword());
    	nUser.setSexe(user.getSexe());
//    	nUser.setUsername(user.getEmail());
    	
    	usersRepository.save(nUser);
    	
    	return "redirect:/gestionUsers";
    }
	
	
	@RequestMapping(value = "/gestionInfos", method = RequestMethod.GET)
	public String accessInfos(Model model,RedirectAttributes redirectAttributes) throws SQLException {
		User usr = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users userMod = usersRepository.findByUserName(usr.getUsername());
    	model.addAttribute("userMod", userMod);
    	return "gestionInfos";
	}
	
	@RequestMapping(value = "/gestionInfos", method = RequestMethod.POST)
	public String writeInfos(Users user, RedirectAttributes redirectAttributes) {
		User usr = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users nUser = usersRepository.findByUserName(usr.getUsername());
    	nUser.setAge(user.getAge());
//    	nUser.setEmail(user.getEmail());
    	nUser.setFirstName(user.getFirstName());
    	nUser.setLastName(user.getLastName());
//    	nUser. setPasswordEncode(user.getPassword());
    	nUser.setSexe(user.getSexe());
//    	nUser.setUsername(user.getEmail());
    	
    	usersRepository.save(nUser);
    	
    	return "redirect:/index";
	}
	
    @RequestMapping("/remove/{id}")
    public String deleteUser(@PathVariable("id") Integer userID,RedirectAttributes redirectAttributes)
    {
    	usersRepository.delete(userID);
    	return "redirect:/gestionUsers";
    }

	@RequestMapping("utilisateur/{id}")
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("utilisateur", usersService.getUtilisateurById(id));
		return "utilisateursListe";
	}

}