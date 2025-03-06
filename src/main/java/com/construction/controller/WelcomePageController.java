package com.construction.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.construction.dao.CartDao;
import com.construction.dao.OrderDao;
import com.construction.dao.ProductDao;
import com.construction.dao.UserDao;
import com.construction.model.Cart;
import com.construction.model.Order;
import com.construction.model.Product;
import com.construction.model.User;

@Controller
public class WelcomePageController {
      
	@Autowired
	private UserDao userdao;
	@Autowired
	private User user;
	@Autowired
	User unpass;
	@Autowired
	private CartDao cartdao;
	@Autowired
	private OrderDao orderdao;
	@Autowired
	private ProductDao productdao;
	@Autowired
	private Product product;
	
	@RequestMapping("/userhome")
	public String welcome(HttpSession session) {
		int u_id = user.getU_id();
		List<Order> orderlist = orderdao.getOrdersById(u_id);
		List<Cart> cartlist = cartdao.displayCartById(u_id);
		List<Product> productlist = productdao.getAllProducts();
		session.setAttribute("cartlist",cartlist);
		session.setAttribute("orderlist",orderlist);
		session.setAttribute("productlist", productlist);
	    return "welcome";
	}
	
	@RequestMapping(value="/EditProfile",method = RequestMethod.GET)
    public String edit(@RequestParam("u_id") int u_id , Model m ) {
   	 user = userdao.getUserById(u_id);
   	 m.addAttribute("user", user);
   	 return "EditProfile";
    }
	
	@RequestMapping(value="/EditDetails",method=RequestMethod.POST)
    public String saveDetails(@ModelAttribute("user") User user) {
   	 userdao.update(user);
   	 return "welcome";
    }
	
	@RequestMapping(value="/ChangePassword", method=RequestMethod.POST)
	public String changepassword(@RequestParam("uname") String uname , @RequestParam("newpassword") String newpassword) {
		unpass.setUname(uname);
		unpass.setPassword(newpassword);
		userdao.changePassword(unpass);
		return "welcome";
	}
	
	@RequestMapping("/addtocart")
	public String AddToCart(@RequestParam("product_id") int product_id,HttpSession session,Model m) {
		int u_id = (int) session.getAttribute("u_id");
		user=userdao.getUserById(u_id);
		m.addAttribute("u_id",u_id);
		product=productdao.getProductById(product_id);
		session.setAttribute("user", user);
		session.setAttribute("product", product);
		return "AddToCart";
	}
	
	 @GetMapping("/viewproduct") 
     public  String viewproduct(@RequestParam("product_id") int product_id , Model model) {
        	List<Product> list = (List<Product>) productdao.getProductById(product_id);
        	model.addAttribute("productlist",list);
        	return "UserManage";
        }

	
	
	
	@RequestMapping("/GetImage")
	public void GetImage(@RequestParam("product_id") int productId, HttpServletResponse response) {
		response.setContentType("image/image2.jpg");
		Blob image = productdao.getImage(productId);
		byte[] bytes;
		try {
			bytes = image.getBytes(1, (int) image.length());
			InputStream inputStream = new ByteArrayInputStream(bytes);
			IOUtils.copy(inputStream, response.getOutputStream());
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping("/deleteorder")
	public String deleteOrder(@RequestParam("order_id") int order_id) {
		orderdao.deleteOrder(order_id);
		return "redirect:/userhome";
	}
	
	@RequestMapping("/adminuserview")
	public String adminUserView(HttpSession session) {
		List<Product> productlist = productdao.getAllProducts();
		session.setAttribute("productlist", productlist);
		session.setAttribute("user", user);
		return "welcome";
	}
}
