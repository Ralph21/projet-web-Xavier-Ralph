package com.miage;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class webController {

		@RequestMapping(value = "/index")
		public String AccessIndex() 
		{				
			return "index";
		}
	
}
