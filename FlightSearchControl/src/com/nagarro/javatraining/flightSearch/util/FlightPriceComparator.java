package com.nagarro.javatraining.flightSearch.util;

import java.util.Comparator;

import com.nagarro.javatraining.flightSearch.model.Flight;

public class FlightPriceComparator implements Comparator<Flight>
{
	@Override
	public int compare(Flight arg0, Flight arg1) {
		return arg0.getFare()-arg1.getFare();
	}
}
