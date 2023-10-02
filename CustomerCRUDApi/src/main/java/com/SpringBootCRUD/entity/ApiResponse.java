package com.SpringBootCRUD.entity;

public class ApiResponse {

	private boolean success;
	private String message;
	private Object data;

	public ApiResponse(boolean success, String message, Object data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}


	public ApiResponse(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}



	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}

}
