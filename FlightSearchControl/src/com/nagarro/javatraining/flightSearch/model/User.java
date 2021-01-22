package com.nagarro.javatraining.flightSearch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Users")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id  ;
	
	@Column(unique=true)
	@NotEmpty
	private String userId ;
	
	@Pattern(regexp = "^(.+)@(.+)",message="should be valid")
	private String email ;
	@Column(name="user_name")
	@NotEmpty
	private String name ;
	
	@NotEmpty
	private String pass ;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
