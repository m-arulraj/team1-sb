package com.virtusa.clientapplication.resource;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.clientapplication.service.CanvasjsChartService;

@Controller
@RequestMapping(value = "/p")
public class ChartResource {

	@Autowired
	private CanvasjsChartService canvasjsChartService;

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public ModelAndView springMVC(ModelMap modelMap) {

		List<Double> canvasjsDataList = canvasjsChartService.getProfit();
		List<String> months = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sep", "Oct",
				"Nov", "Dec");

		Map<String, Double> profitdata = new LinkedHashMap<>();

		for (int i = 0; i < 12; i++) {
			profitdata.put(months.get(i), canvasjsDataList.get(i));
		}
		ModelAndView mav = new ModelAndView("chart");
		mav.addObject("dataPointsList", profitdata);
		return mav;
	}

}