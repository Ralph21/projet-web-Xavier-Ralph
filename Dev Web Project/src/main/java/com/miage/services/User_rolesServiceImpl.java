package com.miage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.miage.domain.User_roles;
import com.miage.repositories.User_rolesRepository;

public class User_rolesServiceImpl implements User_rolesService{

	private User_rolesRepository user_rolesRepository;

	@Autowired
	@Qualifier("User_rolesRepository")
	public void setUtilisateurRepository(User_rolesRepository user_rolesRepository) {
		this.user_rolesRepository = user_rolesRepository;
	}
	@Override
	public Iterable<User_roles> listAllRole() {
		return user_rolesRepository.findAll();
	}

	@Override
	public User_roles getRoleById(Integer id) {
		return user_rolesRepository.findOne(id);
	}

	@Override
	public User_roles saveRole(User_roles user_roles) {
		return user_rolesRepository.save(user_roles);
	}

}
