package com.nagarro.javatraining.flightSearch.service;

import java.util.List;

import com.nagarro.javatraining.flightSearch.model.Flight;
import com.nagarro.javatraining.flightSearch.model.FlightDetailsEntered;

public interface FlightControlService {
	
	/*
	 * Method to get list of matching flights
	 * 
	 * @returns  List<Flight>
	 * 
	 * @param FlightDetailsEntered
	 */
	public List<Flight> getListOfMatchingFlights(FlightDetailsEntered flightDetails);

}
