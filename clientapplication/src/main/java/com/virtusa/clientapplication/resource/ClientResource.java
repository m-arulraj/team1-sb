package com.virtusa.clientapplication.resource;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

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

	@RequestMapping(value = "/viewstockmanager", method = RequestMethod.GET)
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
	public ModelAndView addProductToTable(@ModelAttribute("product") Product product, HttpSession session) {

		ModelAndView mav = new ModelAndView("addstock");

		mav.addObject(product.getName());
		mav.addObject(product.getDescription());
		mav.addObject(product.getCategory().getId());

		logger.debug(product);

		Product prod = clientService.addproduct(product);
		mav.addObject("productdetails", prod);
		session.setAttribute("savedProduct", product.getName());
		session.setAttribute("productid", prod);
		return mav;
	}

	@RequestMapping(value = "/addstock")
	public ModelAndView addStock(HttpSession session, Model model) {
		ModelAndView mav = new ModelAndView("addstocktotable");
		mav.addObject("stockdetails", new Stock());
		model.addAttribute("saved", session.getAttribute("savedProduct"));
		return mav;
	}

	@RequestMapping(value = "/addstockforexistingtotable")
	public String addStockToTableForExisting(@ModelAttribute("stockdetails") Stock stock, HttpSession session) {

		/* Product product = (Product) session.getAttribute("productid"); */

		stock.setOriginalQuantity(stock.getQuantity());

		clientService.saveStock(stock);

		return "stockadded";
	}

	@RequestMapping(value = "/addstocktotable")
	public String addStockToTable(@ModelAttribute("stockdetails") Stock stock, HttpSession session) {

		 Product product = (Product) session.getAttribute("productid"); 
           stock.setProductId(product.getId());
		stock.setOriginalQuantity(stock.getQuantity());

		clientService.saveStock(stock);

		return "stockadded";
	}
	@RequestMapping(value = "/viewstockdetailsmanager", method = RequestMethod.GET)
	public ModelAndView viewStockDetails(@RequestParam("productId") Long id) {

		ModelAndView mav = new ModelAndView("stockdetailsmanager");
		List<Stock> stock = clientService.getStockList(id);
		
		// stock.stream().sorted(Comparator.comparing(Stock::getDate)).collect(Collectors.toList());
		mav.addObject("stockdetails",
				stock.stream().sorted(Comparator.comparing(Stock::getDate)).collect(Collectors.toList()));
		return mav;

	}
	
	@RequestMapping(value="/managerhome")
	public String homePath() {
		
		return "manager";
	}
	
	@RequestMapping(value="/errorpage")
	public String error() {
		
		return "errorpage2";
	}
	
	@RequestMapping(value="/addstockforexistingproduct")
	public ModelAndView addstock() {
		List<Product> products = clientService.getAllProducts();
		ModelAndView mav=new ModelAndView("addingstock");
		mav.addObject("productlist",products);
		mav.addObject("stockdetails",new Stock());
		return mav;
	}
	
	@RequestMapping(value="/manageproduct")
	public String manageProduct() {
		return "manageproduct";
	}
	@RequestMapping(value="/updateproduct")
	public ModelAndView updateProduct() {
		ModelAndView mav=new ModelAndView("updateproduct");
		List<Product> products = clientService.getAllProducts();
		mav.addObject("productlist", products);
		return mav;
	}
	
	
	@RequestMapping(value="/deleteproduct")
	public ModelAndView deleteProduct() {
    
		ModelAndView mav=new ModelAndView("deleteproduct");
		List<Product> products = clientService.getAllProducts();
		mav.addObject("productlist", products);
		return mav;
	}
	
	@RequestMapping(value="/delete")
	public ModelAndView delete(@RequestParam("productId") Long productId) {
             clientService.deleteProductById(productId);
		ModelAndView mav=new ModelAndView("deleteproduct");
		mav.addObject("generated", true);
		return mav ;
	}
	
	
	
}
