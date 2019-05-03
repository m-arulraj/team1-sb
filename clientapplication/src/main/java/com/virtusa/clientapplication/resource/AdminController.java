package com.virtusa.clientapplication.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.clientapplication.domain.User;
import com.virtusa.clientapplication.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user) {
		adminService.saveUser(user);
		return null;

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

}
