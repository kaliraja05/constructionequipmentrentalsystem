package com.construction.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.construction.dao.CartDao;
import com.construction.dao.ProductDao;
import com.construction.model.Cart;
import com.construction.model.Product;

@Controller
public class CartController {
	
	@Autowired
	private CartDao cartDao;
	@Autowired
	private ProductDao productdao;
	
	@PostMapping("/addtocart")
	public ModelAndView AddToCart(@RequestParam("user_id") int user_id, @RequestParam("quantity") int quantity, @RequestParam("time") int time, @RequestParam("pro_id") int pro_id, @RequestParam("productName") String productName, @RequestParam("pPrice") int pPrice, ModelAndView mv) {
		int total_cost = pPrice*quantity*time;
		Cart cart = new Cart(user_id,pro_id,productName,pPrice,quantity,time,total_cost);
		Product product = productdao.getProductById(pro_id);
		int actualQuantity = product.getQuantity();
		if(quantity>actualQuantity)
		{
			mv.addObject("message", "Only "+actualQuantity+" items are available now");
			mv.setViewName("AddToCart");
		}else {
		if(cartDao.addToCart(cart))
		{
			mv.addObject("message","Item Added to the Cart Successfully ! ! !");
			mv.setViewName("AddToCart");
		}
		else {
			mv.addObject("message","Error ! ! ! Item not Added");
			mv.setViewName("AddToCart");
		}
	}
		return mv;
	}
	@GetMapping("/deletecart")
	public String deleteCart(int cart_id) {
		cartDao.deleteCart(cart_id);
		return "redirect:/userhome";
	}

}
