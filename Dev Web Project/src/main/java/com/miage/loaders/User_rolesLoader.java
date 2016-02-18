package com.miage.loaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.miage.domain.User_roles;
import com.miage.repositories.User_rolesRepository;

@Component
public class User_rolesLoader implements ApplicationListener<ContextRefreshedEvent>{

		private User_rolesRepository user_rolesRepository;

		    @Autowired
		    public void setUtilisateurRepository(User_rolesRepository user_rolesRepository) {
		        this.user_rolesRepository = user_rolesRepository;
		    }

		    @Override
		    public void onApplicationEvent(ContextRefreshedEvent event) {

		    	User_roles administrateur = new User_roles();
		    	administrateur.setIdRole(1);
		    	administrateur.setRole("ROLE_ADMIN");
		    	administrateur.setUtilisateur(1);
		    	administrateur.setUsername("ralph.gaume@gmail.com");
		    	user_rolesRepository.save(administrateur);
//		        Users ralph = new Users();
//		        ralph.setAge(24);
//		        ralph.setFirstName("Ralph");
//		        ralph.setLastName("Gaume");
//		        ralph.setEmail("ralph.gaume@gmail.com");
//		        ralph.setSexe("Homme");
//		        ralph.setPassword(encodeMDP("ralph"));
//		        utilisateurRepository.save(ralph);
//
//		        Users xavier = new Users();
//		        xavier.setAge(24);
//		        xavier.setFirstName("Xavier");
//		        xavier.setLastName("Simon");
//		        xavier.setEmail("xavier.simon@gmail.com");
//		        xavier.setSexe("Homme");
//		        xavier.setPassword(encodeMDP("xavier"));
//		        utilisateurRepository.save(xavier);

		    }
//		    
		    


}

