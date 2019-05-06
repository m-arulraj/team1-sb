package com.stockbook.adminservice.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockbook.adminservice.domain.Authorities;
import com.stockbook.adminservice.domain.Bill;
import com.stockbook.adminservice.domain.Stock;
import com.stockbook.adminservice.domain.User;
import com.stockbook.adminservice.repository.AuthoritiesRepository;
import com.stockbook.adminservice.repository.BillRepository;
import com.stockbook.adminservice.repository.StockRepository;
import com.stockbook.adminservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	BillRepository billRepository;
	@Autowired
	AuthoritiesRepository authoritiesRepository;

	List<Double> listOfCp = new ArrayList<Double>();
	List<Double> listOfSp = new ArrayList<Double>();

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	Predicate<Stock> withDate(Integer month) {
		return i -> LocalDate.parse(i.getDate(), formatter).getMonthValue() == month;
	}
	
	Predicate<Bill> withDate1(Integer month) {
		return i -> LocalDate.parse(i.getBillDate(), formatter).getMonthValue() == month;
	}

	public User saveUser(User user) {

		Authorities authorities = saveAuthorites(user);
		user.setAuthorities(authorities);
          user.setEnabled(1);
		return userRepository.save(user);

	}

	public Authorities saveAuthorites(User user) {
		Authorities authorities = new Authorities();
		authorities.setUsername(user.getUsername());
		authorities.setRole("ROLE_" + user.getAuthorities().getRole());
		authoritiesRepository.save(authorities);
		return authorities;

	}

	public Optional<User> getUser(Long id) {

		return userRepository.findById(id);
	}

	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	public void deleteById(Long id) {

		userRepository.deleteById(id);

	}

	public void blockUser(Long id) {

		Optional<User> user = userRepository.findById(id);

		if (user.isPresent()) {
			User userStatus = user.get();
			userStatus.setEnabled(0);

			userRepository.save(userStatus);
		}

	}

	public User getUserByUserName(String username) {

		return userRepository.findByUsername(username);
	}

	public List<Double> getTotalCP() {
		int i = 1;
		List<Stock> stocks = stockRepository.findAll();
		while (i <=12) {

			List<Stock> thestock = stocks.stream().filter(withDate(i)).collect(Collectors.toList());
			Double cpTotal = thestock.stream().collect(Collectors.summingDouble(j -> j.getTotalCp()));

			listOfCp.add(cpTotal);
			i++;
		}
		return listOfCp;
	}

	
	public List<Double> getTotalSP() {
		int i = 1;
		List<Bill> bills = billRepository.findAll();
		while (i <=12) {

			List<Bill> thebill = bills.stream().filter(withDate1(i)).collect(Collectors.toList());
			Double spTotal = thebill.stream().collect(Collectors.summingDouble(j -> j.getGrandTotal()));

			listOfSp.add(spTotal);
			i++;
		}
		return listOfSp;
	}
}
