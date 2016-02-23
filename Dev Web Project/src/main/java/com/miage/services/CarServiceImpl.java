package com.miage.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.miage.domain.Car;
import com.miage.repositories.CarRepository;

public class CarServiceImpl implements CarService {

	private CarRepository carRepository;
	
	@Autowired
	public void setCarRepository(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	
	@Override
	public Iterable<Car> listAllCars() {
		return carRepository.findAll();
	}

	@Override
	public Car getCarById(Integer id) {
		return carRepository.findOne(id);
	}

	@Override
	public Car saveCar(Car car) {
		return carRepository.save(car);
	}

}
