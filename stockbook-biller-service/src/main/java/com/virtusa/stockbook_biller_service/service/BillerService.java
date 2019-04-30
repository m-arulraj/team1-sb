package com.virtusa.stockbook_biller_service.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.stockbook_biller_service.domain.Bill;
import com.virtusa.stockbook_biller_service.repository.BillRepository;

@Service
public class BillerService {

	@Autowired
	BillRepository billRepository;

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	Predicate<Bill> withDate (Integer month) {
		return i -> LocalDate.parse(i.getBillDate(), formatter).getMonthValue() == month;
	}
	public Bill saveBill(Bill bill) {
		Bill bill2 = billRepository.save(bill);
		
		return bill2;
	}

	public Bill getBillById(int id) {
		Optional<Bill> bill = billRepository.findById(id);
		if (bill.isPresent()) {
			Bill thebill = bill.get();
			return thebill;
		} else {

			return null;
		}

	}

	public List<Bill> getBillsByBillerName(String billername) {
		List<Bill> bills = billRepository.findAll();
		
		List<Bill> theBills = bills.stream().filter(i -> i.getBillerName().equals(billername)).collect(Collectors.toList());
		return theBills;
	}

	public List<Bill> getBillByMonthlyWise(String month) {
		System.out.println("entred BillService");
		List<Bill> bills = billRepository.findAll();
		Integer m = Integer.parseInt(month);
		List<Bill> theBills = bills.stream().filter(withDate(m)).collect(Collectors.toList());
		System.out.println("month "+theBills.size());
		return theBills;
		
		
	}

}
