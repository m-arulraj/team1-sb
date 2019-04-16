package com.virtusa.clientapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.clientapplication.domain.Category;
import com.virtusa.clientapplication.util.EndPointConstant;

@Service
public class ClientService {

	@Autowired
	RestTemplate restTemplate;
	
	
	public ResponseEntity<List<Category>> getCategoryList() {
		ResponseEntity<List<Category>> responses = restTemplate.exchange(EndPointConstant.CATEGORY_SERVICE_URI,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Category>>() {
				});
		return responses;
	}
	
}
