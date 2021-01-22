package com.nagarro.javatraining.flightSearch.dao;

import java.util.List;

import com.nagarro.javatraining.flightSearch.model.Airline;
import com.nagarro.javatraining.flightSearch.model.Flight;

public interface FlightNAirlineDao {

	/*
	 * Method used to save airline name
	 * 
	 * @param airline
	 * 
	 */
	public void saveAirline(Airline airline);
	
	/*
	 * Method used to save airline name
	 * 
	 * @returns List<Flights>
	 * 
	 */

	public List<Flight> getFlights();
	
	
	/*
	 * Method used to save airline name
	 * 
	 * @param airline
	 * 
	 */
	public void deleteAirline(String airlineName);
}
