package com.virtusa.clientapplication.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.virtusa.clientapplication.domain.CanvasjsChartData;

@Service
public class CanvasjsChartService {

	

	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		
		CanvasjsChartData chart =new CanvasjsChartData();
		return CanvasjsChartData.getCanvasjsDataList();

	}

}
