package com.virtusa.clientapplication.domain;

import java.util.List;

public class Bill {

	int id;
	String name;
	long contact;
	String billerName;
	double grandTotal;
	String billDate;
	float discount;
	float gst;
	String manfacturer;
	List<Long> stockIds;
	List<Integer> qtyList;

	public List<Integer> getQtyList() {
		return qtyList;
	}

	public void setQtyList(List<Integer> qtyList) {
		this.qtyList = qtyList;
	}

	public List<Long> getStockIds() {
		return stockIds;
	}

	public List<Long> getsId() {
		return stockIds;
	}

	public void setStockIds(List<Long> sId) {
		this.stockIds = sId;
	}

	public String getManfacturer() {
		return manfacturer;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public void setManfacturer(String manfacturer) {
		this.manfacturer = manfacturer;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public float getGst() {
		return gst;
	}

	public void setGst(float gst) {
		this.gst = gst;
	}

	float sellingprice;


	public float getSellingprice() {
		return sellingprice;
	}

	public void setSellingprice(float sellingprice) {
		this.sellingprice = sellingprice;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getBillerName() {
		return billerName;
	}

	public void setBillerName(String billerName) {
		this.billerName = billerName;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

}
