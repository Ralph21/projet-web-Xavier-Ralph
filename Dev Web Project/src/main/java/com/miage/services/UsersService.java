package com.miage.services;

import com.miage.domain.Users;

public interface UsersService {
    Iterable<Users> listAllUtilisateurs();

    Users getUtilisateurById(Integer id);

    Users saveUtilisateur(Users users);
}
