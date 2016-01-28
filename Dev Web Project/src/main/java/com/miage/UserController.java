package com.miage;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Controller
public class UserController extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/resultatInscription").setViewName("resultatInscription");
    }

    @RequestMapping(value="/inscription", method=RequestMethod.GET)
    public String showForm(Utilisateur utilisateur) {
        return "inscription";
    }

    @RequestMapping(value="/inscription", method=RequestMethod.POST)
    public String checkPersonInfo(@Valid Utilisateur utilisateur, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "inscription";
        }

        return "redirect:/resultatInscription";
    }
}