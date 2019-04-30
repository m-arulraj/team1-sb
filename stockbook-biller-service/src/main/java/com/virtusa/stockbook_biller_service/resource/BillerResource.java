package com.virtusa.stockbook_biller_service.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.stockbook_biller_service.domain.Bill;
import com.virtusa.stockbook_biller_service.service.BillerService;

@RestController
@RequestMapping(value="/api")
public class BillerResource {
	@Autowired
	BillerService billerService;

	@PostMapping(value = "/bill")
	public ResponseEntity<Bill> saveBill(@RequestBody Bill bill) throws URISyntaxException {
		 
		URI uri = new URI("/api/bill/" + billerService.saveBill(bill).getId());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Bill>(headers, HttpStatus.CREATED);
	}
 
	@GetMapping(value = "/api/bill/{id}")
	public ResponseEntity<Bill> geBillById(@PathVariable int id) {
		Bill bill = billerService.getBillById(id);
		if (bill != null)
			return ResponseEntity.ok(bill);
		else
			return ResponseEntity.badRequest().body(null);
	}

	@GetMapping(value = "/api/bill/biller/{billername}")
	public ResponseEntity<List<Bill>> getBillsByBIllerName(@PathVariable("billername") String billername) {
		List<Bill> bills = billerService.getBillsByBillerName(billername);

		if (bills.size()!=0) {
			System.out.println(bills.size());
			return ResponseEntity.ok(bills);
		} else {
			return ResponseEntity.badRequest().body(null); 
		}
	}
	
	@GetMapping(value="/api/bill/month/{month}")
	public ResponseEntity<List<Bill>> getBillMonthlyWise(@PathVariable("month") String month) {
		
		System.out.println("entered Bill Resource");
		
		List<Bill>bill=billerService.getBillByMonthlyWise(month);
		if(bill.size()!=0) {
		return ResponseEntity.ok(bill);
		}
		else {
			return ResponseEntity.badRequest().body(null);
		}
	}

}
