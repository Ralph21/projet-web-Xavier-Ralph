package com.miage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
public class DevWebProjectApplication  extends WebMvcConfigurerAdapter implements CommandLineRunner {
	
	@Autowired
	carRepository car_bdd;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
	}

	//lance l'application
	public static void main(String[] args) throws Throwable {
		SpringApplication.run(DevWebProjectApplication.class, args);
	}
	
	public void run(String... arg0) throws Exception {
		

		car AudiA3 = new car();
		AudiA3.setMarque("Audi");
		AudiA3.setModele("A3");
		car_bdd.save(AudiA3);
		
		car AudiQ5 = new car();
		AudiQ5.setMarque("Audi");
		AudiQ5.setModele("Q5");
		car_bdd.save(AudiQ5);
		
		car VWGolf = new car();
		VWGolf.setMarque("Volkswagen");
		VWGolf.setModele("Golf");
		car_bdd.save(VWGolf);
		
		car VWTiguan = new car();
		VWTiguan.setMarque("Volkswagen");
		VWTiguan.setModele("Tiguan");
		car_bdd.save(VWTiguan);

		System.out.println(" appli lancée");
		
	}
}
