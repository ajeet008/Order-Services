package com.hcl.OrderService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.hcl.OrderService.model.OrderModel;
import com.hcl.OrderService.persentation.Order;
import com.hcl.OrderService.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository repository;

	@Override
	@Transactional
	public OrderModel addOrder(Order order) throws Exception {
		OrderModel orderModel = null;
		try {
		if(null != order) {
			OrderModel model = new OrderModel();
			model.setOrderType(order.getOrderType());
			model.setPrice(order.getPrice());
			model.setQuantity(order.getQuantity());
			model.setUserId(order.getUserId());
			orderModel= repository.save(model);
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderModel;
	}

	@Override
	@Transactional
	public void cancelOrder(@PathVariable int orderId) throws Exception{
		try {
		if(orderId != 0) {
			repository.deleteById(orderId);
			
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public List<OrderModel> getSummary() throws Exception{
		List<OrderModel> model = null;
		try {
			model = repository.findAll();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("List has Empty");
		}
		
		return model;
	}



}
