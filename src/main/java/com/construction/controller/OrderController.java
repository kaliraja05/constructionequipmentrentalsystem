package com.construction.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.construction.dao.CartDao;
import com.construction.dao.OrderDao;
import com.construction.dao.ProductDao;
import com.construction.model.Cart;
import com.construction.model.Order;
import com.construction.model.Product;
import com.construction.model.User;

@Controller
public class OrderController {
	
	@Autowired
	private OrderDao orderdao;
	@Autowired
	private CartDao cartdao;
	@Autowired
	private Order order;
	@Autowired
	private Product product;
	@Autowired
	private ProductDao productdao;
	@Autowired
	private User user;
	@Autowired
	private Cart ocart;
	
	@PostMapping("/saveorder")
	public String saveOrder(@RequestParam("user_id") int u_id,@RequestParam("pro_id") int p_id, @RequestParam("productName") String productName, @RequestParam("quantity") int quantity, @RequestParam("time") int time, @RequestParam("pPrice") int pPrice,HttpSession session) {
	    int totalprice = quantity*time*pPrice;
	    LocalDate date=LocalDate.now();
	    String orderdate = String.valueOf(date);
	    String delivery = "Not Estimated";
	    String status = "Pending";
	    int product_id = product.getProduct_id();
	    List<Order> orderlist = orderdao.getOrdersById(u_id);
		List<Cart> cartlist = cartdao.displayCartById(u_id);
		Order order = new Order(u_id,p_id,productName,quantity,time,totalprice,orderdate,delivery,status);
		orderdao.saveOrder(order);
		session.setAttribute("cartlist",cartlist);
		session.setAttribute("orderlist",orderlist);
		return "welcome";

}
	

	
	  @GetMapping("/vieworders") 
	  public String vieworder(Model model,HttpSession session) {
		  int u_id = (int) session.getAttribute("u_id");
		  List<Order> list = orderdao.getOrdersById(u_id);
		  ((Model) session).addAttribute("orderlist",list); 
		  System.out.println(list);
	      return "welcome";
	  }
	  
	  @PostMapping("/directorder")
		public ModelAndView DirectOrder(@RequestParam("user_id") int user_id, @RequestParam("quantity") int quantity, @RequestParam("time") int time, @RequestParam("pro_id") int pro_id, @RequestParam("productName") String productName, @RequestParam("pPrice") int pPrice, ModelAndView mv) {
			int total_cost = pPrice*quantity*time;
			LocalDate date=LocalDate.now();
			String orderdate = String.valueOf(date);
			String delivery = "Not estimated";
			String ordstatus = "Pending";
			Product product = productdao.getProductById(pro_id);
			int actualQuantity = product.getQuantity();
			int updatedQuantity = actualQuantity - quantity;
			Product quanid = new Product();
			quanid.setQuantity(updatedQuantity);
			quanid.setProduct_id(pro_id);
			orderdao.updateQuantity(quanid);
			Order order = new Order(user_id,pro_id,productName,quantity,time,total_cost,orderdate,delivery,ordstatus);
			if(quantity>actualQuantity) {
				mv.addObject("message", "Only "+actualQuantity+" items are available now");
				mv.setViewName("AddToCart");
			}else {
			if(orderdao.addToOrder(order)){
				mv.setViewName("DirectOrderSummary");
				mv.addObject("order", order);
			}
			else {
				mv.setViewName("AddToCart");
				mv.addObject("message", "Order Unsuccessfull ! ! !");
			}
			}
			return mv;
		}
	  
	  @GetMapping("/cartorder")
		public ModelAndView cartOrder ( ModelAndView mv,HttpSession session) {
		  boolean status = false;
			int u_id = (int) session.getAttribute("u_id");
			List<Cart> lcart = cartdao.getCartById(u_id);
			List<Cart> dcart = cartdao.getCartById(u_id);
			Order order = new Order();
			LocalDate date=LocalDate.now();
			String orderdate = String.valueOf(date);
			  
			  for(Cart c: lcart) {
			  
			  int p_id = c.getPro_id();
			  int quantity = c.getQuantity();
			  String pro_name = c.getP_name();
			  int time = c.getTime();
			  int totalprice = c.getTotal_cost();
			  Product product = productdao.getProductById(p_id);
			  int actualQuantity = product.getQuantity();
			  int updatedQuantity = actualQuantity - quantity;
			  Product quanid = new Product();
			  quanid.setQuantity(updatedQuantity);
			  quanid.setProduct_id(p_id);
			  orderdao.updateQuantity(quanid);
			  
			  order.setU_id(u_id);
			  order.setP_id(p_id);
			  order.setPro_name(c.getP_name());
			  order.setQuant(c.getQuantity());
			  order.setTime(c.getTime());
			  order.setTotalprice(c.getTotal_cost());
			  order.setOrderdate(orderdate);
			  order.setDelivery("undefined");
			  order.setStatus("Pending");
			  
			  status = orderdao.addToOrder(order);
			  }
			if(status==true){
				cartdao.deleteCartAfterOrder(u_id);
				mv.setViewName("OrderSummary");
				mv.addObject("cart", dcart);
			}
			else {
				mv.setViewName("AddToCart");
				mv.addObject("message", "Order Unsuccessfull ! ! !");
			}
			return mv;
		}
	 
	 
}
