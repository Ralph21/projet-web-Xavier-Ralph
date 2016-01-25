package com.miage;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class webController {

	
		/**
		 * Lors de l'appel du chemin /index, lance index.html
		 */
		@RequestMapping(value = "/index")
		public String AccessIndex() 
		{				
			return "index";
		}
		
		/**
		 * par default, lance la page index.html
		 */
	    @RequestMapping("/")
	    public String retourIndex(RedirectAttributes redirectAttributes)
	    {
	    	return "index";
	    }
	
}
