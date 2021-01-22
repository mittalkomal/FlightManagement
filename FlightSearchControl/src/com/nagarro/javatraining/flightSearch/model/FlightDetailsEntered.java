package com.nagarro.javatraining.flightSearch.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class FlightDetailsEntered {

	@Size(min = 3, max = 3, message = "should be a 3 letter code")
	private String depLoc;

	@Size(min = 3, max = 3, message = "should be a 3 letter code")
	private String arrLoc;

	private Date flightDate;

	@Pattern(regexp = "^[E,EB]{1,2}", message = "Please choose valid flight class")
	private String flightClass;

	@Max(value = 2, message = "Choose valid entry")
	@Min(value = 1, message = "is required")
	private int outputPreference;

	public String getDepLoc() {
		return depLoc;
	}

	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}

	public String getArrLoc() {
		return arrLoc;
	}

	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public int getOutputPreference() {
		return outputPreference;
	}

	public void setOutputPreference(int outputPreference) {
		this.outputPreference = outputPreference;
	}

}
