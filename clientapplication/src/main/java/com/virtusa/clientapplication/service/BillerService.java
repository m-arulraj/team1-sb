package com.virtusa.clientapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.clientapplication.domain.Bill;
import com.virtusa.clientapplication.domain.Product;
import com.virtusa.clientapplication.domain.Stock;
import com.virtusa.clientapplication.util.EndPointConstant;

@Service
public class BillerService {

	@Autowired
	RestTemplate restTemplate;

	public List<Product> getAllProducts() {

		ResponseEntity<List<Product>> response = restTemplate.exchange(
				EndPointConstant.PRODUCT_SERVICE_URI + "/products", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Product>>() {
				});
		List<Product> products = (List<Product>) response.getBody();
		return products;

	}

	public Stock getStock(Long id) {

		ResponseEntity<Stock> response = restTemplate
				.getForEntity(EndPointConstant.PRODUCT_SERVICE_URI + "/stock/" + id, Stock.class);

		return response.getBody();
	}

	public void saveBill(Bill theBill, int quantity, Long stockId) {

		ResponseEntity<Bill> response = restTemplate.postForEntity(EndPointConstant.BILLER_SERVICE_URI + "bill",
				theBill, Bill.class);

		if (response != null) {

			ResponseEntity<Stock> stockresponse = restTemplate.exchange(
					EndPointConstant.PRODUCT_SERVICE_URI + "/stock/" + stockId + "/quantity/" + quantity,
					HttpMethod.PUT, null, Stock.class);

			Stock stockbody = stockresponse.getBody();
			System.out.println(stockbody);
		}

	}

}
