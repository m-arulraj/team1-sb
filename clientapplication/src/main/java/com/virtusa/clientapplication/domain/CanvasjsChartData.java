package com.virtusa.clientapplication.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanvasjsChartData {

	 static Map<Object, Object> map = null;
	 static List<List<Map<Object, Object>>> list = new ArrayList<List<Map<Object, Object>>>();
	 static List<Map<Object, Object>> dataPoints1 = new ArrayList<Map<Object, Object>>();

	static {
		map = new HashMap<Object, Object>();
		map.put("label", "Jan");
		map.put("y", 60);
		dataPoints1.add(map);
		map = new HashMap<Object, Object>();
		map.put("label", "Feb");
		map.put("y", 50);
		dataPoints1.add(map);
		map = new HashMap<Object, Object>();
		map.put("label", "Mar");
		map.put("y", 10);
		dataPoints1.add(map);
		map = new HashMap<Object, Object>();
		map.put("label", "Apr");
		map.put("y", 25);
		dataPoints1.add(map);
		map = new HashMap<Object, Object>();
		map.put("label", "May");
		map.put("y", 35);
		dataPoints1.add(map);
		map = new HashMap<Object, Object>();
		map.put("label", "June");
		map.put("y", 45);
		dataPoints1.add(map);
		map = new HashMap<Object, Object>();
		map.put("label", "July");
		map.put("y", 66);
		dataPoints1.add(map);
		map = new HashMap<Object, Object>();
		map.put("label", "Aug");
		map.put("y", 55);
		dataPoints1.add(map);
		map = new HashMap<Object, Object>();
		map.put("label", "Sep");
		map.put("y", 50);
		dataPoints1.add(map);
		map = new HashMap<Object, Object>();
		map.put("label", "Oct");
		map.put("y", 40);
		dataPoints1.add(map);
        
		map = new HashMap<Object, Object>();
		map.put("label", "Nov");
		map.put("y", 50);
		dataPoints1.add(map);
        
		map = new HashMap<Object, Object>();
		map.put("label", "Dec");
		map.put("y", 56);
		dataPoints1.add(map);
        
		list.add(dataPoints1);
	}

	public static List<List<Map<Object, Object>>> getCanvasjsDataList() {
		return list;
	}
}