package com.miage.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.miage.domain.Car;
import com.miage.domain.Reservations;

public interface ReservationsRepository extends CrudRepository<Reservations, Integer>{

	List<Reservations> findReservations(Integer userId);
	
	List<Car> findCars(Integer userId);
	
}
