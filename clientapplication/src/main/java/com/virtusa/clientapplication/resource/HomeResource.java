package com.virtusa.clientapplication.resource;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeResource {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage() {
		return "admin";
	}

	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public String managerPage() {
		return "manager";
	}

	@RequestMapping(value = "/biller", method = RequestMethod.GET)
	public String sample1() {
		return "biller";
	}
}
