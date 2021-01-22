package com.nagarro.javatraining.flightSearch.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogOut {
	
	
	@RequestMapping(value ="/logout" , method=RequestMethod.GET)
	public ModelAndView getlogin(HttpSession session){
	    session.getAttribute("loginedUser") ;
		session.removeAttribute("loginedUser");
		ModelAndView modelAndView = new ModelAndView("redirect:login") ;
		return modelAndView ;
	}
	
}
