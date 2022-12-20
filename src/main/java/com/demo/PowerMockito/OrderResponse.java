package com.demo.PowerMockito;

public class OrderResponse {
	private OrderRequest response;
	private String message;
	private int statusCode;

	public OrderResponse(OrderRequest response, String message, int statusCode) {
		super();
		this.response = response;
		this.message = message;
		this.statusCode = statusCode;
	}

	public Object getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderRequest getResponse() {
		// TODO Auto-generated method stub
		return null;
	}

}