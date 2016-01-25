package com.miage;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class webController {

		@RequestMapping(value = "/index", method = RequestMethod.GET)
		public String AccessIndex(Model model,RedirectAttributes redirectAttributes,HttpSession session) 
		{				
			return "index";
		}
	
}
