package com.miage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class webController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String AccessIndex(Model model,RedirectAttributes redirectAttributes) {		
		return "index";
	}


	@RequestMapping("/")
	public String retourIndex(Model model,RedirectAttributes redirectAttributes) {
		return "index";
	}


	@RequestMapping(value = "/contact")
	public String AccessContact() {
		return "contact";
	}
	
	@RequestMapping(value = "/informations")
	public String AccessInformations() {
		return "informations";
	}

}
