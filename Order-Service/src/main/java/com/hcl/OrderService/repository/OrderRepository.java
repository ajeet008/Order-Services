package com.hcl.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.OrderService.model.OrderModel;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel,Integer> {

}
