package com.miage.services;

import com.miage.domain.Utilisateur;

public interface UtilisateurService {
    Iterable<Utilisateur> listAllUtilisateurs();

    Utilisateur getUtilisateurById(Integer id);

    Utilisateur saveProduct(Utilisateur utilisateur);
}
