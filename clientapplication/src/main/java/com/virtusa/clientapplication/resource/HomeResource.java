package com.virtusa.clientapplication.resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeResource {

	private static Logger logger = Logger.getLogger(HomeResource.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		logger.info("entered login page");
		return "login";
	}

	@RequestMapping(value = "/admin")
	public String adminPage() {
		logger.info("entered admin page");
		return "admin";
	}

	@RequestMapping(value = "/manager")
	public String managerPage() {
		logger.info("entered manager page");
		return "manager";
	}

	@RequestMapping("pavan")
	public String sample() {
		return "pavan";
	}

	@RequestMapping("biller")
	public String sample1() {
		return "Biller";
	}

	@RequestMapping("viewstock")
	public String sample2() {
		return "viewstock";
	}
}