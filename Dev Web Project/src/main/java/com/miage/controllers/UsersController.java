package com.miage.controllers;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miage.domain.Reservations;
import com.miage.domain.User_roles;
import com.miage.domain.Users;
import com.miage.repositories.CarRepository;
import com.miage.repositories.ReservationsRepository;
import com.miage.repositories.User_rolesRepository;
import com.miage.repositories.UsersRepository;
import com.miage.services.UsersService;
import com.sun.mail.smtp.SMTPTransport;


@Controller
@ComponentScan("com.miage.services")
public class UsersController extends WebMvcConfigurerAdapter {

	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	User_rolesRepository user_rolesRepository;
	
	@Autowired
	ReservationsRepository reservationsRepository;
	
	@Autowired
	CarRepository carRepository;
	
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
    	nUser.setFirstName(user.getFirstName());
    	nUser.setLastName(user.getLastName());
    	nUser.setSexe(user.getSexe());
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
	
	@RequestMapping(value = "/gestionEssais", method = RequestMethod.GET)
	public String accessEssais(Model model) {		
		User usr = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users userMod = usersRepository.findByUserName(usr.getUsername());
    	List<Reservations> reservations = reservationsRepository.findReservations(userMod.getIdUtilisateur());
    	model.addAttribute("reservations", reservations);
    	return "gestionEssais";
	}
	
	@RequestMapping(value="/testMail")//,== method=RequestMethod.POST)
	public String mail() throws MessagingException{

		System.out.println("envoi d'un mail");
		
		//Envoi d'un email à l'admin du site
			//pour lui donner le message de l'internaute
		Properties props = System.getProperties();
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.auth","true");
        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        
        //de la part de
        msg.setFrom(new InternetAddress("ralph.gaume@gmail.com"));;
        msg.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse("contact.rgxs@gmail.com", false));//mail_c --> destinataire. Ici, formulaire de contact
        msg.setSubject("Formulaire de contact"+System.currentTimeMillis());
        msg.setText("Message de :  Voici son message : ");
        msg.setHeader("X-Mailer", "Coucou");
        Date d = new Date();
        msg.setSentDate(d);
        SMTPTransport t =
            (SMTPTransport)session.getTransport("smtps");
        t.connect("smtp.gmail.com", "contact.rgxs@gmail.com", "projetxavralph");
        t.sendMessage(msg, msg.getAllRecipients());
        System.out.println("Response: " + t.getLastServerResponse());
        t.close();
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/gestionEssaisAdm", method = RequestMethod.GET)
	public String accessEssaisAdm(Model model) {
    	List<Reservations> reservations = (List<Reservations>) reservationsRepository.findAll();
    	model.addAttribute("reservations", reservations);
    	return "gestionEssais";
	}
	
	@RequestMapping(value = "/gestionInfos", method = RequestMethod.POST)
	public String writeInfos(Users user, RedirectAttributes redirectAttributes) {
		User usr = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users nUser = usersRepository.findByUserName(usr.getUsername());
    	nUser.setAge(user.getAge());
    	nUser.setFirstName(user.getFirstName());
    	nUser.setLastName(user.getLastName());
    	nUser.setSexe(user.getSexe());
    	usersRepository.save(nUser);
    	return "redirect:/index";
	}
	
    @RequestMapping("/remove/{id}")
    public String deleteUser(@PathVariable("id") Integer userID,RedirectAttributes redirectAttributes)
    {
    	usersRepository.delete(userID);
    	return "redirect:/gestionUsers";
    }

    @RequestMapping("/removeReservation/{id}")
    public String deleteReservation(@PathVariable("id") Integer reservationId,RedirectAttributes redirectAttributes)
    {
    	Reservations reservation = reservationsRepository.findOne(reservationId);
    	reservationsRepository.delete(reservationId);
    	carRepository.delete(reservation.getCar().getIdCar());
    	UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String role = user_rolesRepository.findRoleByUID(usersRepository.findByUserName(userDetails.getUsername()).getIdUtilisateur()).getRole();
    	if(role.equalsIgnoreCase("ROLE_ADMIN")) {
    		return "redirect:/gestionEssaisAdm";
    	} else {
    		return "redirect:/gestionEssais";
    	}
    }
    
    @RequestMapping("/apercu")
    public String apercuReservation(@RequestParam Integer id, Model model)
    {
    	Reservations reservation = reservationsRepository.findOne(id);
    	model.addAttribute("reservation", reservation);
    	return "apercu";
    }

    
	@RequestMapping("utilisateur/{id}")
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("utilisateur", usersService.getUtilisateurById(id));
		return "utilisateursListe";
	}

}