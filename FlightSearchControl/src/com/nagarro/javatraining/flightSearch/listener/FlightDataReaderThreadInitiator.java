package com.nagarro.javatraining.flightSearch.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.nagarro.javatraining.flightSearch.util.CSVToDataBaseConverter;

@WebListener
public class FlightDataReaderThreadInitiator implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Server closed");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		/*ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(new CSVToDataBaseConverter(), 0, 3, TimeUnit.SECONDS);*/
		new CSVToDataBaseConverter().execute();
	}

}
