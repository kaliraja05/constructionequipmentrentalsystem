package com.construction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.construction.dao.OrderDao;
import com.construction.model.Order;

@Controller
public class OrderManageController {
     
	@Autowired
	private OrderDao orderdao;
	
	 @GetMapping("/vieworder") 
     public  String viewusers(Model model) {
        	List<Order> list = orderdao.getOrder();
        	model.addAttribute("listorder",list);
        	return "OrderManagement";
        }
	 
	 @RequestMapping(value="/updateorder",method=RequestMethod.POST)
	 public String updateOrders(Order order) {
		 orderdao.updateOrder(order);
		 return "redirect:vieworder";
	 }
	 
	 }