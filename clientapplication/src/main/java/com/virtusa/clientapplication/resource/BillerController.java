package com.virtusa.clientapplication.resource;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.clientapplication.domain.Bill;
import com.virtusa.clientapplication.domain.Product;
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
		model.addObject("billdata", new Bill());
		model.addObject("product", new Product());
		return model;
	}

	@RequestMapping(value = "/updateform", method = RequestMethod.GET)
	public ModelAndView updateProfile() {
		ModelAndView mav = new ModelAndView("updateform");

		return mav;
	}

	/*
	 * @RequestMapping(value = "/getstock", method = RequestMethod.GET) public
	 * ModelAndView getStock(@RequestParam("stockId") Long id, HttpSession session)
	 * {
	 * 
	 * ModelAndView mav = new ModelAndView("billform"); Stock stock =
	 * billerService.getStock(id); mav.addObject("billdata", new Bill());
	 * mav.addObject("stockdata", stock); session.setAttribute("stock", stock);
	 * return mav; }
	 */

	@RequestMapping(value = "/add/bill", method = RequestMethod.POST)
	public ModelAndView saveBill(@ModelAttribute("billdata") Bill bill, HttpSession httpSession, Principal principal) {

		// Stock stock = (Stock) httpSession.getAttribute("stock");

		System.out.println(bill.getsId());

		Bill theBill = new Bill();
		theBill.setName(bill.getName());

		theBill.setContact(bill.getContact());
		theBill.setBillerName(principal.getName());

		theBill.setGrandTotal(bill.getGrandTotal());
		theBill.setBillDate(LocalDate.now().toString());
		System.out.println(theBill.getBillDate());
	//	billerService.saveBill(theBill, bill.getQuantity(), );

		return new ModelAndView("success");

	}

}
