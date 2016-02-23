package com.miage.services;

import com.miage.domain.Car;

public interface CarService {
    Iterable<Car> listAllCars();

    Car getCarById(Integer id);

    
    Car saveCar(Car car);
}
