package com.SpringBootCRUD.DTO;

public class CustomerSaveDTO {

	private String customerName;
	private String customerAddress;
	private int mobileNo;
	
	public CustomerSaveDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerSaveDTO(int customerId, String customerName, String customerAddress, int mobileNo) {
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.mobileNo = mobileNo;
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
