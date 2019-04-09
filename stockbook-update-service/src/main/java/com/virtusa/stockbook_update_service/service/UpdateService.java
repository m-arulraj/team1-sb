package com.virtusa.stockbook_update_service.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.stockbook_update_service.domain.User;
import com.virtusa.stockbook_update_service.repository.UserRepository;
import com.virtusa.stockbook_update_service.resource.UpdateResource;

@Service
public class UpdateService {

	final static Logger logger = Logger.getLogger(UpdateResource.class);

	@Autowired
	UserRepository userRepository;

	public User updateUserPassword(User user2) {
		logger.debug("entered Updateservice");
		User use=null;
		Optional<User> user = userRepository.findById(user2.getId());
		
		
		if (user.isPresent()) {
			use=user.get();
			use.setPassword(user2.getNewpassword());
			return userRepository.save(use);
		}
		
		else {
			logger.debug("Object with that id is not present");
			return null;
		}
		

	}

	public User updateUserName(User user2) {
		logger.debug("entered Updateservice");
		User use=null;
		Optional<User> user = userRepository.findById(user2.getId());
		
		
		if (user.isPresent()) {
			use=user.get();
			use.setUsername(user2.getNewusername());
			return userRepository.save(use);
		}
		
		else {
			logger.debug("Object with that id is not present");
			return null;
		}
	}

	public User updateUserProfile(User user2) {
		
		User use=null;
		Optional<User> user=userRepository.findById(user2.getId());
		if(user.isPresent()) {
			use=user.get();
			use.setName(user2.getName());
			use.setContact(user2.getContact());
			use.setEmail(user2.getEmail());
			use.setEnabled(user2.getEnabled());
			return userRepository.save(use);
		}
		else
		{
			logger.debug("Object with that is not present");
			return null;
		}
		
		
	}

	public User addUserProfile(User user) {
		return	userRepository.save(user);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * public void updateUserName(int id, String username, User user) {
	 * logger.debug("entered Updateservice Method"); User userr = null;
	 * Optional<User> user1 = userRepository.findById(id); if (user1.isPresent()) {
	 * logger.debug("User with given Id is present"); userr = user1.get(); if
	 * (userr.getUsername().equals(username)) {
	 * userr.setUsername(user.getUsername()); } else {
	 * logger.debug("Entered old Username is wrong");
	 * 
	 * } } else { logger.debug("User with given Id is notpresent");
	 * 
	 * }
	 * 
	 * }
	 */
}
