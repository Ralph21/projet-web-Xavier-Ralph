package com.miage.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.miage.domain.Utilisateur;
import com.miage.repositories.UtilisateurRepository;

@Component
public class UtilisateurLoader implements ApplicationListener<ContextRefreshedEvent>{

	private UtilisateurRepository utilisateurRepository;

	    @Autowired
	    public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
	        this.utilisateurRepository = utilisateurRepository;
	    }

	    @Override
	    public void onApplicationEvent(ContextRefreshedEvent event) {

	        Utilisateur ralph = new Utilisateur();
	        ralph.setAge(24);
	        ralph.setFirstName("Ralph");
	        ralph.setLastName("Gaume");
	        ralph.setSexe("Homme");
	        utilisateurRepository.save(ralph);

	        Utilisateur xavier = new Utilisateur();
	        xavier.setAge(24);
	        xavier.setFirstName("Xavier");
	        xavier.setLastName("Simon");
	        xavier.setSexe("Juif");
	        utilisateurRepository.save(xavier);

	    }
}

