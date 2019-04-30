package com.virtusa.clientapplication.resource;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.clientapplication.domain.Bill;
import com.virtusa.clientapplication.domain.Product;
import com.virtusa.clientapplication.domain.Stock;
import com.virtusa.clientapplication.service.BillerService;
import com.virtusa.clientapplication.service.ClientService;

@Controller
@RequestMapping("/biller")
public class BillerController {

	@Autowired
	BillerService billerService;

	@Autowired
	ClientService clientService;

	@RequestMapping(value = "/bill", method = RequestMethod.GET)
	public ModelAndView generateBill() {
		ModelAndView model = new ModelAndView("generate-bill");
		List<Product> products = billerService.getAllProducts();
		model.addObject("products", products);
		model.addObject("product", new Product());
		return model;
	}

	@RequestMapping(value = "/updateform", method = RequestMethod.GET)
	public ModelAndView updateProfile() {
		ModelAndView mav = new ModelAndView("updateform");

		return mav;
	}

	@RequestMapping(value = "/getstock", method = RequestMethod.GET)
	public ModelAndView getStock(@RequestParam("stockId") Long id, HttpSession session) {

		ModelAndView mav = new ModelAndView("billform");
		Stock stock = billerService.getStock(id);
		mav.addObject("billdata", new Bill());
		mav.addObject("stockdata", stock);
		session.setAttribute("stock", stock);
		return mav;
	}

	@RequestMapping(value = "/add/bill", method = RequestMethod.POST)
	public ModelAndView saveBill(@ModelAttribute("billdata") Bill bill, HttpSession httpSession) {
		float total = ((bill.getQuantity() * bill.getSellingprice()) - bill.getDiscount() + bill.getGst());
		Stock stock = (Stock) httpSession.getAttribute("stock");
		Bill theBill = new Bill();
		theBill.setName(bill.getName());

		theBill.setContact(bill.getContact());
		theBill.setBillerName(bill.getBillerName());
		theBill.setGrandTotal(total);
		theBill.setBillDate(bill.getBillDate());
		billerService.saveBill(theBill, bill.getQuantity(), stock.getId());

		return new ModelAndView("success");

	}

	@RequestMapping(value = "/stockBill", method = RequestMethod.GET)
	public ModelAndView addToBill(@RequestParam("productId") Long id) {

		ModelAndView mav = new ModelAndView("generate-bill");
		List<Stock> stock = clientService.getStockList(id);
		List<Product> products = billerService.getAllProducts();
		mav.addObject("products", products);
		mav.addObject("product", new Product());
		mav.addObject("stockdetails",
				stock.stream().sorted(Comparator.comparing(Stock::getDate)).collect(Collectors.toList()));
		return mav;

	}

}
