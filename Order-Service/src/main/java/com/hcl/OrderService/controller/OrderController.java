package com.hcl.OrderService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.OrderService.model.OrderModel;
import com.hcl.OrderService.persentation.Order;
import com.hcl.OrderService.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;

	
	@PostMapping("/api/addOrder")
	public OrderModel addOrder(@RequestBody Order order) throws Exception {
		OrderModel model = null;
		try {
		orderService.addOrder(order);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@PostMapping("/api/cancelOrder/{orderId}")
	public void CancelOrder(@PathVariable(name = "orderId") int id) throws Exception{
		try {
		orderService.cancelOrder(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@PostMapping("/api/summary")
	public List<OrderModel> getSummary() throws Exception{
		List<OrderModel> orderModel = null;
		try {
			orderModel = orderService.getSummary();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderModel;

	}
	
	@SuppressWarnings("unused")
	private Map<Double,Order> getSummaryWithPrice(List<OrderModel> model){
		Map<Double,Order>map = new HashMap<Double,Order>();
		Order orderSum = new Order();
		
		for(OrderModel order: model) {
			if(!map.containsKey(order.getPrice())) {
				double total =  order.getQuantity();
				orderSum.setQuantity(total);
				orderSum.setOrderId(order.getOrderId());
				map.put(order.getPrice(), orderSum);
			}else  {
				double Sum = order.getQuantity();
				orderSum.setQuantity(Sum);
				orderSum.setPrice(order.getPrice());
				orderSum.setOrderId(order.getOrderId());
				map.put(order.getPrice(), orderSum);
				
			}
			
		}
		return map;
		
	}
}
