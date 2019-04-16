package com.virtusa.clientapplication.domain;

import java.util.List;

public class Product {

	public Product(String name, String description, Category category) {

		this.name = name;
		this.description = description;
		this.category = category;
	}
	
	public Product(Long id,String name, String description, Category category) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
	}

	public Product() {
	}


	private Long id;
	
	private String name;
	
	private String description;
	
	private Category category;
	
	private List<Stock> stockList;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category + "]";
	}

}
