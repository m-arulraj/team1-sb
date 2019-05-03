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
import com.virtusa.clientapplication.domain.Stock;
import com.virtusa.clientapplication.util.EndPointConstant;

@Service
public class ClientService {

	@Autowired
	RestTemplate restTemplate;

	public List<Category> getCategoryList() {
		ResponseEntity<List<Category>> responses = restTemplate.exchange(
				EndPointConstant.CATEGORY_SERVICE_URI + "categories", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Category>>() {
				});
		return responses.getBody();
	}

	public Product addproduct(Product product) {

		ResponseEntity<Product> response = restTemplate.postForEntity(EndPointConstant.CATEGORY_SERVICE_URI + "product",
				product, Product.class);

		System.out.println(response);
		return response.getBody();

	}

	public void saveStock(Stock stock) {
		restTemplate.postForEntity(EndPointConstant.PRODUCT_SERVICE_URI + "stock",
				stock, Stock.class);
		
	}

	

	public List<Product> getAllProducts() {

		ResponseEntity<List<Product>> response = restTemplate.exchange(
				EndPointConstant.PRODUCT_SERVICE_URI + "products", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Product>>() {
				});
		return response.getBody();
	}

	public List<Stock> getStockList(Long id) {
		ResponseEntity<List<Stock>> responses = restTemplate.exchange(
				EndPointConstant.PRODUCT_SERVICE_URI + "/stock/product/" + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Stock>>() {
				});
		return responses.getBody();
	}

	public Product getProductById(Long productId)
	{
		ResponseEntity<Product> response = restTemplate.exchange(
				EndPointConstant.PRODUCT_SERVICE_URI + "product/"+productId, HttpMethod.GET, null,
				new ParameterizedTypeReference<Product>() {
				});
		return response.getBody();
	}

}
