package com.nagarro.javatraining.flightSearch.util;

import java.util.Comparator;

import com.nagarro.javatraining.flightSearch.model.Flight;

public class FlightDurationComparator implements Comparator<Flight> {

	@Override
	public int compare(Flight a, Flight b) {
		Double x  = a.getFlightDuration()-b.getFlightDuration() ;
		if (x<0)
		return -1;
		else if (x>0)
			return 1 ;
		else
			return 0;
			
	}

}
