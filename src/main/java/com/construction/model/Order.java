package com.construction.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class Order {
	
		
	private int order_id;
	private int u_id;
	private int p_id;
	private String pro_name;
	private int quant;
	private int time;
	private int totalprice;
	private String orderdate ;
	private String delivery;
	private String status;
	
	
	
	public Order(LocalDate date, String orderdate1, int order_id, int u_id, int p_id, String pro_name, int quant,
			int time, int totalprice, String orderdate, String delivery, String status) {
		super();
		
		this.order_id = order_id;
		this.u_id = u_id;
		this.p_id = p_id;
		this.pro_name = pro_name;
		this.quant = quant;
		this.time = time;
		this.totalprice = totalprice;
		this.orderdate = orderdate;
		this.delivery = delivery;
		this.status = status;
	}
	
	
	public Order(int u_id, int p_id, String pro_name, int quant, int time, int totalprice, String orderdate,
			String delivery, String status) {
		super();
		this.u_id = u_id;
		this.p_id = p_id;
		this.pro_name = pro_name;
		this.quant = quant;
		this.time = time;
		this.totalprice = totalprice;
		this.orderdate = orderdate;
		this.delivery = delivery;
		this.status = status;
	}

    
	


	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
