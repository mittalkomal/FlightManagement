package com.nagarro.javatraining.flightSearch.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.nagarro.javatraining.flightSearch.dao.FlightNAirlineDao;
import com.nagarro.javatraining.flightSearch.model.Flight;
import com.nagarro.javatraining.flightSearch.model.FlightDetailsEntered;
import com.nagarro.javatraining.flightSearch.service.FlightControlService;
import com.nagarro.javatraining.flightSearch.util.AppContextUtil;
import com.nagarro.javatraining.flightSearch.util.FlightDurationComparator;
import com.nagarro.javatraining.flightSearch.util.FlightPriceComparator;

public class FlightControlServiceImpl implements FlightControlService {

	@Override
	public List<Flight> getListOfMatchingFlights(FlightDetailsEntered flightDetails) {
		FlightNAirlineDao flightDao = (FlightNAirlineDao) AppContextUtil.context.getBean("flightDao");
		List<Flight> allFlights = flightDao.getFlights();
		ArrayList<Flight> matchingFlights = new ArrayList<Flight>();

		for (Flight flight : allFlights) {
			if (flight.getDepLoc().equalsIgnoreCase(flightDetails.getDepLoc())
					&& flight.getArrLoc().equalsIgnoreCase(flightDetails.getArrLoc())
					&& flight.getFlightClass().equalsIgnoreCase(flightDetails.getFlightClass())
					&& (flightDetails.getFlightDate().compareTo(flight.getValidTill()) <= 0)
					&& flight.isSeatAvailability())
				matchingFlights.add(flight);
		}

		if (flightDetails.getOutputPreference() == 1)
			Collections.sort(matchingFlights, new FlightPriceComparator());
		else
			Collections.sort(matchingFlights, new FlightDurationComparator());
		return matchingFlights;
	}

}
