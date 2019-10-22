package com.hcl.OrderService.persentation.test;

import com.hcl.OrderService.model.OrderModel;

public class OrderBuilder {
	private int orderId = 1;

	private Double price = 306.0;

	private Double quantity = 3.5;

	private String orderType = "SELL";

	private String userId = "TEST_USER";

	public OrderBuilder setOrderId(int orderId) {
		this.orderId = orderId;
		return this;
	}

	public OrderBuilder setPrice(Double price) {
		this.price = price;
		return this;
	}

	public OrderBuilder setQuantity(Double quantity) {
		this.quantity = quantity;
		return this;
	}

	public OrderBuilder setOrderType(String orderType) {
		this.orderType = orderType;
		return this;
	}

	public OrderBuilder setUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	public OrderModel build() {
		OrderModel obj = new OrderModel();
		obj.setOrderId(orderId);
		obj.setOrderType(orderType);
		obj.setPrice(price);
		obj.setQuantity(quantity);
		obj.setUserId(userId);
		return obj;
	}
	
	

}
