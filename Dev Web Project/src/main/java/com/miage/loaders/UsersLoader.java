package com.miage.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.miage.domain.Users;
import com.miage.repositories.UsersRepository;

@Component
public class UsersLoader implements ApplicationListener<ContextRefreshedEvent>{

	private UsersRepository usersRepository;

	    @Autowired
	    public void setUtilisateurRepository(UsersRepository usersRepository) {
	        this.usersRepository = usersRepository;
	    }

	    @Override
	    public void onApplicationEvent(ContextRefreshedEvent event) {

	        Users ralph = new Users();
	        ralph.setAge(24);
	        ralph.setFirstName("Ralph");
	        ralph.setLastName("Gaume");
	        ralph.setEmail("ralph.gaume@gmail.com");
	        ralph.setSexe("Homme");
	        ralph.setUsername("ralph.gaume@gmail.com");
	        ralph.setPassword("ralph");
	        ralph.setEnabled(1);
	        usersRepository.save(ralph);

/*	        Users xavier = new Users();
	        xavier.setAge(24);
	        xavier.setFirstName("Xavier");
	        xavier.setLastName("Simon");
	        xavier.setEmail("xavier.com");
	        xavier.setSexe("Homme");
	        xavier.setUsername("xavier.com");
	        xavier.setPassword("xavier");
	        xavier.setEnabled(1);
	        usersRepository.save(xavier);*/

	    }
	    
	    

}