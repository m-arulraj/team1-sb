package com.virtusa.clientapplication.resource;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.clientapplication.domain.Product;
import com.virtusa.clientapplication.domain.Stock;
import com.virtusa.clientapplication.domain.User;
import com.virtusa.clientapplication.service.AdminService;
import com.virtusa.clientapplication.service.ClientService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	ClientService clientService;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") User user) {
		User savedUser = adminService.saveUser(user);
	
		if (savedUser.getAuthorities().getRole().equals("ROLE_MANAGER")) {
			ModelAndView mav = new ModelAndView("registermanager");
			mav.addObject("generated", true);
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("registerBiller");
			mav.addObject("generated", true);
			return mav;
		}

	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User aboutUser() {

		return null;

	}

	@RequestMapping(value = "/block")
	public ModelAndView blockUser() {
		List<User> users = adminService.getAllUser();
		ModelAndView mav = new ModelAndView("block");
		mav.addObject("usersList", users);
		return mav;
	}

	@RequestMapping(value = "/blockUser")
	public ModelAndView blocking(@RequestParam("userId") Long userId) {
		adminService.blockUser(userId);
		ModelAndView mav = new ModelAndView("BlockedPage");
		return mav;
	}

	@RequestMapping(value = "/fastmoving", method = RequestMethod.GET)
	public ModelAndView fastMovingItem() {
		ModelAndView mav = new ModelAndView("fastmoving");
		return mav;
	}

	@RequestMapping(value = "/viewstock", method = RequestMethod.GET)
	public ModelAndView viewStock() {

		ModelAndView mav = new ModelAndView("viewstock");

		List<Product> products = clientService.getAllProducts();
		mav.addObject("productlist", products);
		return mav;
	}

	@RequestMapping(value = "/viewstockdetails", method = RequestMethod.GET)
	public ModelAndView viewStockDetails(@RequestParam("productId") Long id) {

		ModelAndView mav = new ModelAndView("stockdetails");
		List<Stock> stock = clientService.getStockList(id);
		// stock.stream().sorted(Comparator.comparing(Stock::getDate)).collect(Collectors.toList());
		mav.addObject("stockdetails",
				stock.stream().sorted(Comparator.comparing(Stock::getDate)).collect(Collectors.toList()));
		return mav;

	}

}
