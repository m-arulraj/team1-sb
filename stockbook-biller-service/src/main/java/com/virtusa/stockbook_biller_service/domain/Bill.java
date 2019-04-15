package com.virtusa.stockbook_biller_service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="bill")
public class Bill {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="name")
	String name;
	@Column(name="contact")
	int conatct;
	@Column(name="biller_name")
	String billerName;
	@Column(name="grand_total")
	double grandTotal;
	@Column(name="bill_date")
	String billDate; 
}
