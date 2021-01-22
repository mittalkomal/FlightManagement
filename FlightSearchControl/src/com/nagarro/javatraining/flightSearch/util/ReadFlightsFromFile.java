package com.nagarro.javatraining.flightSearch.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.StringTokenizer;

import com.nagarro.javatraining.flightSearch.exception.DateInvalidException;
import com.nagarro.javatraining.flightSearch.exception.InvalidFlightClassException;
import com.nagarro.javatraining.flightSearch.model.Airline;
import com.nagarro.javatraining.flightSearch.model.Flight;

public class ReadFlightsFromFile {

	public static final SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");

	public static Airline readFile(File file) {
		BufferedReader reader = null;
		Airline airline = new Airline();
		airline.setName(file.getName());
		HashSet<Flight> flight_Set = new HashSet<Flight>();
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			line = reader.readLine();

			while (line != null) {
				Flight flight = flightLineToDBRow(line, airline);
				line = reader.readLine();
				flight_Set.add(flight);
			}
		} catch (Exception e) {
			System.err.println("Could Not Read the File");
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
					System.err.println("Could Not Close the File");
				}
			}
		}
		airline.setFlights(flight_Set);
		return airline;
	}

	private static Flight flightLineToDBRow(String line, Airline aObj) {
		try {
			StringTokenizer st = new StringTokenizer(line, "|");
			String flightNo = st.nextToken();
			String depLoc = st.nextToken();
			String arrLoc = st.nextToken();
			String validTillDate = st.nextToken();
			Date validTill = new Date();
			validTill = Validations.validateDate(validTillDate);
			String flightTime = st.nextToken();
			Double flightDuration = Double.parseDouble(st.nextToken());
			int fare = Integer.parseInt(st.nextToken());

			String avail = st.nextToken();
			Boolean seatAvailability;
			if (avail.charAt(0) == 'Y')
				seatAvailability = true;
			else
				seatAvailability = false;

			String flightClass = st.nextToken();
			Validations.validateFlightClass(flightClass);
			return new Flight(flightNo, depLoc, arrLoc, fare, validTill, flightTime, flightDuration, seatAvailability,
					flightClass, aObj);
		}

		catch (DateInvalidException e) {
			System.err.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
		} catch (InvalidFlightClassException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}
