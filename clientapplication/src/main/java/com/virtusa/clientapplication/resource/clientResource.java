package com.virtusa.clientapplication.resource;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.clientapplication.domain.Category;
import com.virtusa.clientapplication.domain.Product;
import com.virtusa.clientapplication.domain.Stock;
import com.virtusa.clientapplication.domain.User;
import com.virtusa.clientapplication.service.ClientService;

@Controller
public class ClientResource {

	@Autowired
	ClientService clientService;

	private static Logger logger = Logger.getLogger(ClientResource.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
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

	@RequestMapping(value = "/biller", method = RequestMethod.GET)
	public String sample() {
		return "biller";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView billerPage(@RequestParam("productname") String product) {

		return null;
	}

	@RequestMapping(value = "/viewstock", method = RequestMethod.GET)
	public ModelAndView viewStock() {

		ModelAndView mav = new ModelAndView("viewstock");

		List<Product> products = clientService.getAllProducts();
		mav.addObject("productlist", products);
		return mav;
	}

	

	@RequestMapping(value = "/registermanager", method = RequestMethod.GET)
	public String registerManager(Model model) {
		model.addAttribute("user", new User());
		return "registermanager";
	}

	@RequestMapping(value = "/registerBiller", method = RequestMethod.GET)
	public String registerBiller(Model model) {
		model.addAttribute("user", new User());
		return "registerBiller";
	}

	@RequestMapping(value = "/addproduct")
	public ModelAndView addProduct() {
		ModelAndView mav = new ModelAndView("addproduct");
		List<Category> list = clientService.getCategoryList();
		mav.addObject("categorylist", list);
		mav.addObject("product", new Product());
		return mav;
	}

	@RequestMapping(value = "/add/product/table", method = RequestMethod.POST)
	public ModelAndView addProductToTable(@ModelAttribute("product") Product product) {

		ModelAndView mav = new ModelAndView("addproduct");

		mav.addObject(product.getName());
		mav.addObject(product.getDescription());
		mav.addObject(product.getCategory().getId());

		logger.debug(product);

		Product prod = clientService.addproduct(product);

		return mav;
	}

	@RequestMapping(value = "/viewstockdetails", method = RequestMethod.GET)
	public ModelAndView viewStockDetails(@RequestParam("productId") Long id) {

		ModelAndView mav = new ModelAndView("stockdetails");
		List<Stock> stock = clientService.getStockList(id);
		//stock.stream().sorted(Comparator.comparing(Stock::getDate)).collect(Collectors.toList());
		mav.addObject("stockdetails", stock.stream().sorted(Comparator.comparing(Stock::getDate)).collect(Collectors.toList()));
		return mav;

	}
}
