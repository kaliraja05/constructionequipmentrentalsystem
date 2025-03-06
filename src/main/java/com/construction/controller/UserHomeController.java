package com.construction.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.construction.dao.CartDao;
import com.construction.dao.OrderDao;
import com.construction.dao.ProductDao;
import com.construction.dao.UserDao;
import com.construction.model.Cart;
import com.construction.model.Order;
import com.construction.model.Product;
import com.construction.model.User;

@Controller
public class UserHomeController {
	
	
	@Autowired
	private UserDao userdao;
	@Autowired
	private User user;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private CartDao cartdao;
	@Autowired
	private OrderDao orderdao;
	
	/*
	 * @RequestMapping("/") public String home() { return "index"; }
	 */
	   @RequestMapping("/register")
	   public String register(){
		   return "register";
	   }
	   @PostMapping("/register")
		public ModelAndView registerUser(@ModelAttribute("RegisterUser") User user, ModelAndView mv) {
			boolean status = userdao.saveUser(user);
			mv.setViewName("login");
			return mv;
		}
	   @RequestMapping("/userlogout")
	   public String logout(HttpSession session) {
		   session.invalidate();
		   return "redirect:/login";
	   }
	   
	   @RequestMapping("/login")
	   public String login() {
		   return "login";
	   }
	   @PostMapping("/login")
		public String loginuser(@RequestParam("uname") String uname,@RequestParam("password") String password,
				HttpSession session,  Model mv)
		{
		User login = new User(uname,password);
		int result=userdao.validate(login);
		user=userdao.getUserByName(uname);
		session.setAttribute("u_id", user.getU_id());
		int u_id = user.getU_id();
		List<Product> productlist = productDao.getAllProducts();
		List<Order> orderlist = orderdao.getOrdersById(u_id);
		List<Cart> cartlist = cartdao.displayCartById(u_id);
		if(result==1) {
			session.setAttribute("cartlist",cartlist);
			session.setAttribute("orderlist",orderlist);
			session.setAttribute("productlist", productlist);
			session.setAttribute("user", user);
			return "welcome";
		}else {
			mv.addAttribute("error", "Wrong Credentials!!!");
			return "login";
		}
		 
       
}
}
