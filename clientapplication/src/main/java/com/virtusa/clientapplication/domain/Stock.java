package com.virtusa.clientapplication.domain;

public class Stock {

	@Override
	public String toString() {
		return "Stock [id=" + id + ", date=" + date + ", quantity=" + quantity + ", manufacturer=" + manufacturer
				+ ", costPrice=" + costPrice + ", sellingPrice=" + sellingPrice + ", discount=" + discount
				+ ", totalCp=" + totalCp + ", gst=" + gst + ", threshold=" + threshold + ", productId=" + productId
				+ "]";
	}


	private Long id;

	private String date;

	private Long quantity;

	private String manufacturer;

	private Double costPrice;

	private Double sellingPrice;

	private Float discount;

	private Double totalCp;

	private Float gst;

	private Long threshold;

	private Long productId;
    
	private Long originalQuantity;
	
	public Stock() {

	}

	public Stock(Long id, String date, Long quantity, String manufacturer, Double costPrice, Double sellingPrice,
			float discount, Double totalCp, float gst, Long threshold, Long productId) {
		this.id = id;
		this.date = date;
		this.quantity = quantity;
		this.manufacturer = manufacturer;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.discount = discount;
		this.totalCp = totalCp;
		this.gst = gst;
		this.threshold = threshold;
		this.productId = productId;
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

	public Long getOriginalQuantity() {
		return originalQuantity;
	}

	public void setOriginalQuantity(Long originalQuantity) {
		this.originalQuantity = originalQuantity;
	}

	
}
