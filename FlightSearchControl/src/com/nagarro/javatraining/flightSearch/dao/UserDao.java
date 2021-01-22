package com.nagarro.javatraining.flightSearch.dao;

import com.nagarro.javatraining.flightSearch.model.User;

public interface UserDao {
	
	/*
	 * Method used to save user
	 * 
	 * @param user
	 * 
	 */
	public void saveUser(User user);

	/*
	 * Method to return user
	 * 
	 * @param userId
	 * 
	 * @returns user
	 */
	public User getUser(String userId);
}
