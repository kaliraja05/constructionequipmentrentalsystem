package com.construction.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.construction.dao.ProductDao;
import com.construction.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDao productdao;
	@Autowired
	private Product product;
	
	@GetMapping("/inventory")
	public String inventpage(Model model) {
		List<Product> list = productdao.getAllProducts();
		model.addAttribute("list", list);
		return "invent";
	}
	
	
	@PostMapping("/inventory")
	public String AddToProduct(Model model, @RequestParam("pname") String pname,@RequestParam("quantity") int quantity,@RequestParam("priceperhr") int priceperhr,@RequestParam("pimage") MultipartFile part, HttpServletRequest request) {
			byte[] pimage;
			try {
				pimage = part.getBytes();
				//product.setPimage(picture);
				Product product = new Product(pname,quantity,priceperhr,pimage);
				productdao.addproduct(product);
				//productdao.addProduct(product);
				//mv.setViewName("invent");
				List<Product> list = productdao.getAllProducts();
				model.addAttribute("list", list);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return "invent";
	}	
	@GetMapping("/deleteproduct")
	public String deleteCart(int product_id) {
		productdao.deleteProduct(product_id);
		return "redirect:/inventory";
	}
	
	@RequestMapping(value="/editproduct",method = RequestMethod.GET)
    public String edit(@RequestParam("product_id") int product_id , Model m ) {
   	 product = productdao.getProductById(product_id);
   	 m.addAttribute("product",product);
   	 return "EditProduct";
    }
	
	@RequestMapping(value="/updateproduct",method = RequestMethod.POST)
    public String editProd(@ModelAttribute("product") Product product) {
		productdao.updateProduct(product);
	    return "redirect:inventory";
    }
    
	}
