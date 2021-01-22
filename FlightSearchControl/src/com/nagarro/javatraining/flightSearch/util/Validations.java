package com.nagarro.javatraining.flightSearch.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.nagarro.javatraining.flightSearch.constants.FlightClassType;
import com.nagarro.javatraining.flightSearch.exception.DateInvalidException;
import com.nagarro.javatraining.flightSearch.exception.InvalidFlightClassException;

public class Validations {

	public static final SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");

	public static Date validateDate(String validTillDate) throws DateInvalidException {

		try {
			Date validTill = dateformat.parse(validTillDate);
			return validTill;
		} catch (Exception e) {
			throw new DateInvalidException("Date not in appropriate(dd-MM-yyyy) format");
		}

	}
	

	public static Boolean validateFlightClass(String flightClass) throws InvalidFlightClassException {
		for (FlightClassType type : FlightClassType.values()) {
			if (type.getValue().equals(flightClass)) {
				return true;
			}
		}
		throw new InvalidFlightClassException("Flight class is invalid, it should either be E or B");
	}
	

}
