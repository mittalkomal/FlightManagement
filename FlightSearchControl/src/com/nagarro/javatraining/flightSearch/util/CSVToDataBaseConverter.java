package com.nagarro.javatraining.flightSearch.util;

import java.io.File;

import com.nagarro.javatraining.flightSearch.constants.Constants;
import com.nagarro.javatraining.flightSearch.dao.FlightNAirlineDao;
import com.nagarro.javatraining.flightSearch.model.Airline;

public class CSVToDataBaseConverter {
	File dir = new File(Constants.CSV_DIR_PATH);
	static FlightNAirlineDao flightDao = (FlightNAirlineDao) AppContextUtil.context.getBean("flightDao");

	public void execute() {
		File files[] = dir.listFiles();
		for (File file : files) {
			Airline airline = ReadFlightsFromFile.readFile(file);
			flightDao.saveAirline(airline);

		}
	}
}
