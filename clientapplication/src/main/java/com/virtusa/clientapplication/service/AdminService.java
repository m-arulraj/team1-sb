package com.virtusa.clientapplication.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.clientapplication.domain.CanvasjsChartData;
import com.virtusa.clientapplication.domain.User;
import com.virtusa.clientapplication.util.EndPointConstant;

@Service
public class AdminService {

	@Autowired
	RestTemplate restTemplate;

	public List<List<Map<Object, Object>>> getCanvasjsChartData() {

		CanvasjsChartData chart = new CanvasjsChartData();
		return CanvasjsChartData.getCanvasjsDataList();

	}

	public void saveUser(User user) {

		restTemplate.postForEntity(EndPointConstant.ADMIN_SERVICE_URI+"user/", user, String.class);

	}
}
