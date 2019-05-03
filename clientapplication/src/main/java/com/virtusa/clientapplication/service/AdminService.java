package com.virtusa.clientapplication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.clientapplication.domain.User;
import com.virtusa.clientapplication.util.EndPointConstant;

@Service
public class AdminService {

	@Autowired
	RestTemplate restTemplate;

	

	public void saveUser(User user) {

		restTemplate.postForEntity(EndPointConstant.ADMIN_SERVICE_URI+"user/", user, String.class);

	}

	public List<User> getAllUser() {
		ResponseEntity<List<User>> response = restTemplate.exchange(
				EndPointConstant.ADMIN_SERVICE_URI + "/users/", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				});
		List<User> users = response.getBody();
		List<User> listOfUsers = users.stream().filter(user->!user.getAuthorities().getRole().equals("ADMIN")&& user.getEnabled()!=0).collect(Collectors.toList());
		
		return listOfUsers;
		
	}

	public void blockUser(Long userId) {
	 restTemplate.exchange(
				EndPointConstant.ADMIN_SERVICE_URI + "/users/user/"+userId,
				HttpMethod.PUT, null, User.class);
		
	}
}
