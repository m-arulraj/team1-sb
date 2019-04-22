package com.virtusa.clientapplication.resource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.virtusa.clientapplication.service.CanvasjsChartService;

@Controller
@RequestMapping(value = "/canvasjschart")
public class ChartResource {

	@Autowired
	private CanvasjsChartService canvasjsChartService;

	@RequestMapping(value = "/chartdata", method = RequestMethod.GET)
	public String springMVC(ModelMap modelMap) {
		List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		return "chart";
	}

}