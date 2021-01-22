package com.nagarro.javatraining.flightSearch.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.javatraining.flightSearch.model.Flight;
import com.nagarro.javatraining.flightSearch.model.FlightDetailsEntered;
import com.nagarro.javatraining.flightSearch.service.FlightControlService;
import com.nagarro.javatraining.flightSearch.serviceImpl.FlightControlServiceImpl;

@Controller
public class FlightSearch {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "flightDate", new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/flightSearch", method = RequestMethod.GET)
	public ModelAndView getFlightSearch() {
		ModelAndView modelAndView = new ModelAndView("flightSearch");
		return modelAndView;
	}

	@RequestMapping(value = "/flightSearch", method = RequestMethod.POST)
	public ModelAndView flightSearch(@Valid @ModelAttribute("flightdetails") FlightDetailsEntered flightDetails,
			BindingResult result) {

		ModelAndView modelAndView = new ModelAndView("flightSearch");
		if (result.hasErrors()) {
			System.err.println(result);
			return modelAndView;
		}
		FlightControlService service = new FlightControlServiceImpl();
		List<Flight> listOfMatchingFlights = service.getListOfMatchingFlights(flightDetails);
		modelAndView = new ModelAndView("FlightList");
		modelAndView.addObject("list", listOfMatchingFlights);
		return modelAndView;
	}
}
