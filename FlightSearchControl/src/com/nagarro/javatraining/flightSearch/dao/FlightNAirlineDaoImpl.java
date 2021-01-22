package com.nagarro.javatraining.flightSearch.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.hibernate.Query;
import com.nagarro.javatraining.flightSearch.model.Airline;
import com.nagarro.javatraining.flightSearch.model.Flight;

public class FlightNAirlineDaoImpl implements FlightNAirlineDao {
	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public void saveAirline(Airline airline) {
		Session session = template.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(airline);
		session.getTransaction().commit();
		session.close();
	}

	public List<Flight> getFlights() {
		return template.loadAll(Flight.class);
	}

	@Override
	public void deleteAirline(String airlineName) {

		Session session = template.getSessionFactory().openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Airline where name = :string");
		query.setParameter("string", airlineName);
		Airline a = (Airline) query.uniqueResult();
		a = (Airline) session.load(Airline.class, a.getId());
		session.delete(a);

		session.getTransaction().commit();
		session.close();

	}
}
