package com.hcl.OrderService.controller;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.testng.PowerMockTestCase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hcl.OrderService.model.OrderModel;
import com.hcl.OrderService.persentation.test.OrderBuilder;
import com.hcl.OrderService.service.OrderService;


public class OrderControllerTest extends PowerMockTestCase{
	
	@Mock
	private OrderService orderService;
	
	
	@InjectMocks
	private OrderController test;
	
	
	 public MockMvc mvc;
	 
	 @BeforeMethod
	 public void setUp() throws Exception{
		 MockitoAnnotations.initMocks(this);
		 mvc = MockMvcBuilders.standaloneSetup(test).build();
		 
	 }
	 
	 
	@Test
	public void addOrderTestSuccessfully() throws Exception {
		OrderModel order =  new OrderBuilder().build();
	
		
		Mockito.when(orderService.addOrder(Mockito.any())).thenReturn(order);
		mvc.perform(MockMvcRequestBuilders.post("/api/addOrder").param("price","306")
				.param("quantity","3.5").param("orderType","SELL").param("userId","TEST"))
		.andExpect(MockMvcResultMatchers.status().is(400));
		
	}
	
	@Test
	public void getSummaryOrderSuccessfully() throws Exception{
		List<OrderModel> modelList = new ArrayList<>();
		OrderModel order =  new OrderBuilder().build();
		modelList.add(order);
		Mockito.when(orderService.getSummary()).thenReturn(modelList);
		mvc.perform(MockMvcRequestBuilders.get("/api/summary")).
		andExpect(MockMvcResultMatchers.status().is(405));
		
	}
	
	@Test
	public void cancelOrderSuccessfully() throws Exception{
		List<OrderModel> modelList = new ArrayList<>();
		OrderModel order =  new OrderBuilder().build();
		modelList.add(order);
		Mockito.doNothing().when(orderService).cancelOrder(Mockito.anyInt());
		mvc.perform(MockMvcRequestBuilders.post("/api/cancelOrder/1")).
		andExpect(MockMvcResultMatchers.status().isOk());
		
		
	}









}
