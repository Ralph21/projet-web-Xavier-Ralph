//package com.miage.loaders;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//import com.miage.domain.Car;
//import com.miage.repositories.CarRepository;
//
//@Component
//public class CarLoader implements ApplicationListener<ContextRefreshedEvent>{
//	
//	private  CarRepository carRepository;
//
//	    @Autowired
//	    public void setCarRepository(CarRepository carRepository) {
//	        this.carRepository = carRepository;
//	    }
//	    
//
//	    @Override
//	    public void onApplicationEvent(ContextRefreshedEvent event) {
//	    	Car a3 = new Car();
//	    	a3.setBrand("Audi");
//	    	a3.setModel("A3");
//			a3.setVignette("src/main/resources/static/css/images/audix5.jpg");
//			carRepository.save(a3);
//	    	Car q5 = new Car();
//	    	q5.setBrand("Audi");
//	    	q5.setModel("Q5");
//			q5.setVignette("src/main/resources/static/css/images/audix6.jpg");
//			carRepository.save(q5);
//	    	Car golf = new Car();
//	    	golf.setBrand("Volkswagen");
//	    	golf.setModel("Golf");
//			golf.setVignette("src/main/resources/static/css/images/vwx5.jpg");
//			carRepository.save(golf);
//	    	Car tiguan = new Car();
//	    	tiguan.setBrand("Volkswagen");
//	    	tiguan.setModel("Tiguan");
//	    	tiguan.setVignette("src/main/resources/static/css/images/vwx6.jpg");
//			carRepository.save(tiguan);
//	    }  
//	
//}
