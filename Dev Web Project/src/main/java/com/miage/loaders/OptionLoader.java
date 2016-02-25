//package com.miage.loaders;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//
//import com.miage.domain.Option;
//import com.miage.repositories.OptionRepository;
//
//public class OptionLoader implements ApplicationListener<ContextRefreshedEvent>{
//	
//	private  OptionRepository optionRepository;
//	
//
//	    @Autowired
//	    public void setOptionRepository(OptionRepository optionRepository){
//	    	this.optionRepository = optionRepository;
//	    }
//
//	    @Override
//	    public void onApplicationEvent(ContextRefreshedEvent event) {
////	    	Option option = new Option();
////	    	option.setLibelle("intérieur cuir");
////	    	option.setOwnerId(1);
////	    	optionRepository.save(option);
//	    }  
//
//}
