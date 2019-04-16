package com.virtusa.clientapplication.domain;

import java.util.List;

public class Category {


	private Long id;
	private String name;
	private List<Product> products;
	

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


	public List<Product> getProducts() {
		return products;
	}

	
	public void setProducts(List<Product> products) {
		this.products = products;
	}

//constructors
	public Category() {

	}

// field constructor	
	public Category(String name, List<Product> products) {
		this.name = name;
		this.products = products;
	}

	public Category(String name) {
		this.name = name;
	}
	
	public Category(Long id,String name) {
		this.name = name;
		this.id= id;
	}
	
	
	

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name +  "]";
	}

	
}
