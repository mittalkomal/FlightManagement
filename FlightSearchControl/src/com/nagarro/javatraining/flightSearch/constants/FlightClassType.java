package com.nagarro.javatraining.flightSearch.constants;

public enum FlightClassType {

	Economic("E"), Business("EB");

	private String value;

	public String getValue() {
		return this.value;
	}

	private FlightClassType(String value) {
		this.value = value;
	}

}
