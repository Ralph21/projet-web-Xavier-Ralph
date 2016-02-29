package com.miage.repositories;

import org.springframework.data.repository.CrudRepository;

import com.miage.domain.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {

	Users findByUserName(String username);
}
