package com.miage.loaders;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.miage.domain.Car;
import com.miage.repositories.CarRepository;

public class CarLoader {


	@Component
	public class User_rolesLoader implements ApplicationListener<ContextRefreshedEvent>{

			private  CarRepository carRepository;

			    @Autowired
			    public void setUtilisateurRepository(CarRepository carRepository) {
			        this.carRepository = carRepository;
			    }

			    @Override
			    public void onApplicationEvent(ContextRefreshedEvent event) {
			    	Car a1 = new Car();
			    	a1.setBrand("Audi");
			    	a1.setModel("a1");
//			    	Path img = Paths.get("/static/css/images/audix5.jpg");
//			    	try {
//						byte[] data = Files.readAllBytes(img);
//						a1.setVignette(data);
//					} catch (IOException e) {
//						a1.setVignette(null);
//					}
			    	carRepository.save(a1);
			    	Car a2 = new Car();
			    	a2.setBrand("Audi");
			    	a2.setModel("a2");
			    	carRepository.save(a2);
			    }  
	}


	
}
