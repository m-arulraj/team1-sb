package com.stockbook.adminservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_details")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "date")
	private String date;

	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "manufacturer")
	private String manufacturer;

	@Column(name = "cost_price")
	private Double costPrice;

	@Column(name = "selling_price")
	private Double sellingPrice;

	@Column(name = "discount")
	private Float discount;

	@Column(name = "total_cp")
	private Double totalCp;

	@Column(name = "gst")
	private Float gst;

	@Column(name = "threshold")
	private Long threshold;

	@Column(name = "product_id")
	private Long productId;

	public Stock() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Double getTotalCp() {
		return totalCp;
	}

	public void setTotalCp(Double totalCp) {
		this.totalCp = totalCp;
	}

	public Float getGst() {
		return gst;
	}

	public void setGst(Float gst) {
		this.gst = gst;
	}

	public Long getThreshold() {
		return threshold;
	}

	public void setThreshold(Long threshold) {
		this.threshold = threshold;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productService) {
		this.productId = productService;
	}

}
