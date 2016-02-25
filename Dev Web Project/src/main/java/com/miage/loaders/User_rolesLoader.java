//package com.miage.loaders;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//import com.miage.domain.User_roles;
//import com.miage.repositories.User_rolesRepository;
//
//@Component
//public class User_rolesLoader implements ApplicationListener<ContextRefreshedEvent>{
//
//		private User_rolesRepository user_rolesRepository;
//
//		    @Autowired
//		    public void setUtilisateurRepository(User_rolesRepository user_rolesRepository) {
//		        this.user_rolesRepository = user_rolesRepository;
//		    }
//
//		    @Override
//		    public void onApplicationEvent(ContextRefreshedEvent event) {
//
//		    	User_roles administrateur = new User_roles();
//		    	administrateur.setRole("ROLE_ADMIN");
//		    	administrateur.setUtilisateur(1);
//		    	administrateur.setUsername("ralph.gaume@gmail.com");
//		    	user_rolesRepository.save(administrateur);
//		    	
//		    	
//		    	User_roles usr = new User_roles();
//		    	usr.setRole("ROLE_USER");
//		    	usr.setUtilisateur(2);
//		    	usr.setUsername("xavier.simon@gmail.com");
//		    	user_rolesRepository.save(usr);
//		    }	    
//}
//
