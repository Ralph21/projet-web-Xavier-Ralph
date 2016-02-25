package com.miage.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.miage.domain.Car;
import com.miage.domain.Equipement;

public interface CarRepository extends CrudRepository<Car, Integer>{

	List<Car> findByBrand(String brand);
	
	List<Equipement> findByCarId(Integer id);
	
}
