package com.miage.loaders;

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

@Component
public class CarLoader implements ApplicationListener<ContextRefreshedEvent>{
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
	    	Path img = Paths.get("src/main/resources/static/css/images/audix6.jpg");
			byte[] data = null;
			try {
				data = Files.readAllBytes(img);
			} catch (IOException e) {
				e.printStackTrace();
			}
			a1.setVignette(data);
	    	carRepository.save(a1);
	    }  
	
}
