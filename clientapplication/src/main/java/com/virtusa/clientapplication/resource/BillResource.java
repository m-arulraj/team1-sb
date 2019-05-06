package com.virtusa.clientapplication.resource;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.clientapplication.domain.Product;
import com.virtusa.clientapplication.domain.Stock;
import com.virtusa.clientapplication.service.ClientService;

@RestController
public class BillResource {


	@Autowired
	ClientService clientService;
	
	@GetMapping(value = "/biller/stockBill")
	public List<Stock> addToBill(@RequestParam("productId") Long id) {

			List<Stock> stock = clientService.getStockList(id);
			return stock.stream().sorted(Comparator.comparing(Stock::getDate)).collect(Collectors.toList());
	}
	
	 @GetMapping(value="/product")
	 public Product getProduct(@RequestParam("productId")Long id)
	 {
		 return clientService. getProductById(id);
	 }
	 
	 @PutMapping(value="/api/product")
	 public ResponseEntity<String> updateProduct(){
		 
		 return ResponseEntity.ok("ok");
	 }
}
