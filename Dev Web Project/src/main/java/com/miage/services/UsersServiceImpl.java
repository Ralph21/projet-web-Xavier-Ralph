package com.miage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miage.domain.Users;
import com.miage.repositories.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	private UsersRepository usersRepository;

	@Autowired
	public void setUtilisateurRepository(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public Iterable<Users> listAllUsers() {
		return usersRepository.findAll();
	}

	@Override
	public Users getUtilisateurById(Integer id) {
		return usersRepository.findOne(id);
	}

	@Override
	public Users saveUtilisateur(Users users) {
		return usersRepository.save(users);
	}

}
