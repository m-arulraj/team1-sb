package com.virtusa.clientapplication.resource;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.clientapplication.domain.Category;
import com.virtusa.clientapplication.domain.Product;
import com.virtusa.clientapplication.service.ClientService;

@Controller
public class clientResource {
	
	@Autowired
	ClientService clientService;

	private static Logger logger = Logger.getLogger(clientResource.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage() {
		logger.info("entered login page");
		return "login";
	}

	@RequestMapping(value = "/admin")
	public String adminPage() {
		logger.info("entered amin page");
		return "admin";
	}

	@RequestMapping(value = "/manager")
	public String managerPage() {
		logger.info("entered manager page");
		return "manager";
	}

	@RequestMapping(value="/biller",method=RequestMethod.GET)
	public String sample() {
		return "biller";
	}

	@RequestMapping(value="/search",method=RequestMethod.GET)
	public ModelAndView billerPage(@RequestParam("productname") String product) {
		
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "bag", 1, "tourist Bag"));
		ModelAndView mav=new ModelAndView("biller");
		mav.addObject("listproducts", list);
		return mav;
	}

	@RequestMapping("/viewstock")
	public String sample2() {
		return "viewstock";
	}
	
	@RequestMapping(value="/registermanager",method=RequestMethod.GET)
	public String registerManager() {
		return "registermanager";
	}
	
	@RequestMapping(value="/registerBiller",method=RequestMethod.GET)
	public String registerBiller() {
		return "registerBiller";
	}
	
	@RequestMapping(value="/addproduct")
	public ModelAndView addProduct() {
		ModelAndView mav=new ModelAndView("addproduct");
		/*
		 * List<Category> list=(List<Category>) clientService.getCategoryList();
		 * //mav.addObject("categorylist", list);
		 */		return mav;
	}


}
