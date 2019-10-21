package com.hcl.OrderService.service;

import java.util.List;

import com.hcl.OrderService.model.OrderModel;
import com.hcl.OrderService.persentation.Order;

public interface OrderService {
	
	OrderModel addOrder(Order order)throws Exception;
	void cancelOrder(int id)throws Exception;
	List<OrderModel> getSummary()throws Exception;

}
