package com.miage.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miage.domain.Car;
import com.miage.domain.Equipement;
import com.miage.domain.PWDRetriever;
import com.miage.domain.Reservations;
import com.miage.domain.User_roles;
import com.miage.domain.Users;
import com.miage.repositories.CarRepository;
import com.miage.repositories.EquipementRepository;
import com.miage.repositories.PWDRetrieverRepository;
import com.miage.repositories.ReservationsRepository;
import com.miage.repositories.User_rolesRepository;
import com.miage.repositories.UsersRepository;
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
	
	@Autowired
	EquipementRepository equipementRepository;
	
	@Autowired
	PWDRetrieverRepository pwdRetrieverRepository;

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
	public String saveNewUser(Users user, RedirectAttributes redirectAttributes) throws AddressException, MessagingException 
	{
		user.setEnabled(1);
		User_roles role = new User_roles();
		role.setRole("ROLE_USER");
		role.setUsername(user.getEmail());
		user.setUsername(user.getEmail());
		usersRepository.save(user);
		user_rolesRepository.save(role);
		Properties props = System.getProperties();
	    props.put("mail.smtps.host","smtp.gmail.com");
	    props.put("mail.smtps.auth","true");
	    Session session = Session.getInstance(props, null);
	    Message msg = new MimeMessage(session);
	    msg.setFrom(new InternetAddress("contact.rgxs@gmail.com"));;
	    msg.setRecipients(Message.RecipientType.TO,
	    InternetAddress.parse(user.getEmail(), false));
	    msg.setSubject("Inscription N°"+System.currentTimeMillis());
	    msg.setText("Bonjour " + user.getFirstName() +" "+ user.getLastName() + " vous êtes bien inscrit.");
	    msg.setHeader("X-Mailer", "Bonjour");
	    Date d = new Date();
	    msg.setSentDate(d);
	    SMTPTransport t =
	        (SMTPTransport)session.getTransport("smtps");
	    t.connect("smtp.gmail.com", "contact.rgxs@gmail.com", "projetxavralph");
	    t.sendMessage(msg, msg.getAllRecipients());
	    t.close();
		return "redirect:/index";
	}
	

	
    @RequestMapping(value="/motdepasse", method=RequestMethod.GET)
    public String getEmail(Model model,RedirectAttributes redirectAttributes) {
        model.addAttribute("pwdRetriever", new PWDRetriever());
        return "motdepasse";
    }

    @RequestMapping(value="/motdepasse", method=RequestMethod.POST)
    public String validateStuff(Model model,@ModelAttribute PWDRetriever pwdRetriever, RedirectAttributes redirectAttributes) throws AddressException, MessagingException {
    	
    	long range = 1234567L;
    	Random r = new Random();
    	long code = (long)(r.nextDouble()*range);

		Properties props = System.getProperties();
	    props.put("mail.smtps.host","smtp.gmail.com");
	    props.put("mail.smtps.auth","true");
	    Session session = Session.getInstance(props, null);
	    Message msg = new MimeMessage(session);
	    msg.setFrom(new InternetAddress("contact.rgxs@gmail.com"));;
	    msg.setRecipients(Message.RecipientType.TO,
	    InternetAddress.parse(pwdRetriever.getEmail(), false));
	    msg.setSubject("Changement N°"+System.currentTimeMillis());
	    msg.setText("Bonjour  vous avez oublié votre mot de passe. \n Veuillez utiliser ce code pour réinitialiser votre mot de passe : " + code);
	    msg.setHeader("X-Mailer", "Bonjour");
	    Date d = new Date();
	    msg.setSentDate(d);
	    SMTPTransport t =
	        (SMTPTransport)session.getTransport("smtps");
	    t.connect("smtp.gmail.com", "contact.rgxs@gmail.com", "projetxavralph");
	    t.sendMessage(msg, msg.getAllRecipients());
	    t.close();
	    
	    PWDRetriever npwd = new PWDRetriever();
	    npwd.setEmail(pwdRetriever.getEmail());
	    npwd.setTempCode(code);
	    pwdRetrieverRepository.save(npwd);
	    model.addAttribute("retriever", npwd);
	    return "rinitPWD";
    }
//    
//	@RequestMapping(value = "/rinitPWD", method = RequestMethod.GET)
//	public String chPWD(Model model, RedirectAttributes redirectAttributes) {;
//		
//		return "rinitPWD";
//	}
//	
	@RequestMapping(value = "/rinitPWD", method = RequestMethod.POST)
	public String valideCODE(Model model,RedirectAttributes redirectAttributes, PWDRetriever pwdRetriever) {
		System.out.println(pwdRetriever.getCheckCode());
		//Users user = usersRepository.findByUserName(pwdRetriever.getEmail());
//		if(pwdRetriever.getCheckCode()==pwdRetriever.getTempCode()) {
//			System.out.println(pwdRetriever.getMdp());
//			user.setPassword(pwdRetriever.getMdp());
//			pwdRetrieverRepository.delete(pwdRetriever);
//			usersRepository.save(user);
			return "redirect:/index";
//		} else {
//		    model.addAttribute("pwdr", pwdRetriever);
//	        return "rinitPWD";
//		}
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
	
	@RequestMapping(value= "/modificationReservation", method = RequestMethod.GET)
	public String modifierReservation(@RequestParam Integer id, Model model){
		Reservations reservation = reservationsRepository.findOne(id);
		List<Equipement> equipements = carRepository.findByModel(reservation.getCar().getModel());
		reservation.getCar().setEquipements(equipements);
		model.addAttribute("reservation", reservation);
    	return "modificationReservation";
	}
	
	@RequestMapping(value = "/modificationReservation", method = RequestMethod.POST)
	public String finalizeVoiture(@RequestParam Integer id,@ModelAttribute Reservations base, RedirectAttributes redirectAttributes) {
		Reservations reservationMod = reservationsRepository.findOne(id);
		Reservations nReservation = new Reservations();
		nReservation.setUser(reservationMod.getUser());
		Car car = new Car();
		car.setFuel(base.getCar().getFuel());
		car.setBrand(base.getCar().getBrand());
		car.setGearbox(base.getCar().getGearbox());
		car.setModel(base.getCar().getModel());
		car.setPower(base.getCar().getPower());
		car.setTransmission(base.getCar().getTransmission());
		car.setVignette(base.getCar().getVignette());
		car.setPaint(base.getCar().getPaint());
		car.setWheels(base.getCar().getWheels());
		ArrayList<Equipement> choisis = new ArrayList<>();
		for(Equipement equipement : base.getCar().getEquipements()){
			Equipement e = new Equipement();
			e.setLibelle(equipement.getLibelle());
			equipementRepository.save(e);
			choisis.add(e);
		}
		car.setEquipements(choisis);
		car.setBase(false);
		carRepository.save(car);
		nReservation.setCar(car);
		reservationsRepository.save(nReservation);
		reservationsRepository.delete(reservationMod.getIdReservation());
		return new String("redirect:/summaryMod?id="+nReservation.getIdReservation());
	}
	
	@RequestMapping(value = "/summaryMod", method = RequestMethod.GET)
	public String AccessSummaryMod(@RequestParam Integer id,Model model,RedirectAttributes redirectAttributes) {
		Reservations  reservation = reservationsRepository.findOne(id);
		reservationsRepository.delete(reservation.getIdReservation());
		model.addAttribute("car", reservation.getCar());
		model.addAttribute("reservation", reservation);
		return "summaryMod";
	}
	
	@RequestMapping(value = "/summaryMod", method = RequestMethod.POST)
	public String valideReservationMod(@RequestParam Integer id,@ModelAttribute Reservations reservation, Model model,RedirectAttributes redirectAttributes) {
		reservationsRepository.save(reservation);
		return "redirect:/validation";
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
		model.addAttribute("utilisateur", user_rolesRepository.findOne(id));
		return "utilisateursListe";
	}

}