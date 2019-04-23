package com.virtusa.clientapplication.resource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.virtusa.clientapplication.domain.User;
import com.virtusa.clientapplication.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping(value = "/chartdata", method = RequestMethod.GET)
	public String chartData(ModelMap modelMap) {
		List<List<Map<Object, Object>>> canvasjsDataList = adminService.getCanvasjsChartData();
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		return "chart";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user) {
		adminService.saveUser(user);
		return null;

	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public User aboutUser() {
		
		return null;
		
		
	}
 
}
