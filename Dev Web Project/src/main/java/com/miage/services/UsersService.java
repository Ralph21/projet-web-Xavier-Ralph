package com.miage.services;

import com.miage.domain.Users;

public interface UsersService {
    Iterable<Users> listAllUsers();

    Users getUtilisateurById(Integer id);

    Users saveUtilisateur(Users users);
}
