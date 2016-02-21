package com.miage.services;

import com.miage.domain.Users;

public interface UsersService {
    Iterable<Users> listAllUsers();

    Users getUtilisateurById(Integer id);

    Users getUserByUserName(String userName);
    
    Users saveUtilisateur(Users users);
}
