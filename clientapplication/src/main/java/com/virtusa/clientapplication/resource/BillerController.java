package com.virtusa.clientapplication.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.clientapplication.domain.Product;
import com.virtusa.clientapplication.service.BillerService;

@Controller
@RequestMapping("/biller")
public class BillerController {

	@Autowired
	BillerService billerService;
	
	@RequestMapping(value="/bill",method=RequestMethod.GET)
	public ModelAndView  generateBill()
	{
		ModelAndView model = new ModelAndView("generate-bill");
		List<Product> products = billerService.getAllProducts();
		model.addObject("products",products);
		return model;
	}
	
}
