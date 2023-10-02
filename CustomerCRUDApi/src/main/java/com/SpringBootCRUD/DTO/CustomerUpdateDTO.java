package com.SpringBootCRUD.DTO;

public class CustomerUpdateDTO {

	private int customerId;
	private String customerName;
	private String customerAddress;
	private int mobileNo;
	
	public CustomerUpdateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerUpdateDTO(int customerId, String customerName, String customerAddress, int mobileNo) {
		super();
		this.customerId = customerId;
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
