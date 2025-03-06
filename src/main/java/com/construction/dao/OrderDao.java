package com.construction.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.construction.model.Order;
import com.construction.model.Product;

@Service
public interface OrderDao {
	
	public List<Order> getOrder();
	public int updateOrder(Order order);
	public int saveOrder(Order order);
	public Order getOrderById(int u_id);
	public List<Order> getOrdersById(int u_id);
	public boolean addToOrder(Order order);
	public int updateQuantity(Product product);
	public int deleteOrder(int order_id);
}
