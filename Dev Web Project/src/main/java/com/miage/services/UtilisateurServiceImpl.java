package com.miage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miage.domain.Utilisateur;
import com.miage.repositories.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	@Override
	public Iterable<Utilisateur> listAllUtilisateurs() {
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur getUtilisateurById(Integer id) {
		return utilisateurRepository.findOne(id);
	}

	@Override
	public Utilisateur saveProduct(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

}
