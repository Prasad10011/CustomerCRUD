package com.SpringBootCRUD.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "customer")
@Entity
public class Customer {

	@Id
	@Column(name = "customer_id",length = 50)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	@Column(name = "customer_name",length = 50)
	private String customerName;
	@Column(name = "customer_address",length = 60)
	private String customerAddress;
	@Column(name = "mobile_no",length = 12)
	private int mobileNo;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int customerId, String customerName, String customerAddress, int mobileNo) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.mobileNo = mobileNo;
	}



	public Customer(String customerName, String customerAddress, int mobileNo) {
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.mobileNo = mobileNo;
	}

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

}

