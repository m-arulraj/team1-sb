package com.virtusa.clientapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.clientapplication.domain.Category;
import com.virtusa.clientapplication.domain.Product;
import com.virtusa.clientapplication.util.EndPointConstant;

@Service
public class BillerService {

	@Autowired
	RestTemplate restTemplate;
	
	public List<Product> getAllProducts() {
		
		ResponseEntity<List<Product>> response =
				restTemplate.exchange(EndPointConstant.PRODUCT_SERVICE_URI+"/products",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
				});
		List<Product>  products = (List<Product>) response.getBody();
		return products;
		
	}
	
	
	
	
}
