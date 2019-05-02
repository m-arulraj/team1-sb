package com.virtusa.clientapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.clientapplication.util.EndPointConstant;

@Service
public class CanvasjsChartService {

	@Autowired
	RestTemplate restTemplate;

	public List<Double> getProfit() {
		ResponseEntity<List<Double>> responses = restTemplate.exchange(EndPointConstant.ADMIN_SERVICE_URI+"profit",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Double>>() {
				});

		System.out.println(responses.getBody());
		return responses.getBody();
	}

}
