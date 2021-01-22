package com.nagarro.javatraining.flightSearch.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Airline {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	@Column(name="user_name")
	private String name ;
	
	@OneToMany(mappedBy = "airline" , cascade =  CascadeType.ALL )
	private Set<Flight> flights ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Flight> getFlights() {
		return flights;
	}
	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}
}
