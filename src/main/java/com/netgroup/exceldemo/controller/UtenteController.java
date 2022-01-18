package com.netgroup.exceldemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.netgroup.exceldemo.data.dao.Utente;
import com.netgroup.exceldemo.service.UtenteService;


@Controller
public class UtenteController {

//  @Autowired
//  EncryptionUtils encryptionPass;

  @Autowired
  UtenteService utenteService;

  @GetMapping(value = "/register")
  public ModelAndView register() {
    return new ModelAndView("/login/register").addObject("oggettoUtente", new Utente());
  }

  /*in questo metodo bisogna implementare un custom per controllare se esiste il user prima di salvarlo!  */
  
  @PostMapping(value = "/register" )
  public ModelAndView saveUser(@Valid @ModelAttribute("oggettoUtente") Utente utente, BindingResult bindingResult) {
    
    if (bindingResult.hasErrors()) {
      return new ModelAndView("/login/register").addObject("oggettoUtente", utente);
    } else {
      utenteService.salva(utente);
    }

    return new ModelAndView("redirect:/login").addObject("oggettoUtente", utente);
  }

  @GetMapping(value = "/login")
  public ModelAndView login() {
    return new ModelAndView("/login/login").addObject("oggettoUtente", new Utente());
  }
  
  
  
  @PostMapping(value = "/home")
  public ModelAndView homePost() {
    return new ModelAndView("Home/Home");
  }
  @GetMapping(value = "/home")
  public ModelAndView homeGet() {
    return new ModelAndView("Home/Home");
  }
  

}