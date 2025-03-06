package com.construction.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.construction.dao.AdminDao;
import com.construction.dao.UserDao;
import com.construction.model.Admin;

@Controller
public class AdminHomeController {
	
	@Autowired
	private AdminDao admindao;
	@Autowired
	private Admin admin;
	@Autowired
	private UserDao userdao;

	   @RequestMapping("/admin")
	   public String Admin() {
		   return "Admin";
	   }
	   @RequestMapping("/AdminLogin")
	   public String admin() {
		   return "AdminHome";
	   }
	   
	   @RequestMapping("/adminlogout")
	   public String logout(HttpSession session) {
		   session.invalidate();
		   return "redirect:/admin";
	   }

	   @PostMapping("/AdminLogin")
		public String loginadmin(@RequestParam("aname") String aname,@RequestParam("password") String password,
				HttpSession session,  Model mv)
		{
		Admin login = new Admin(aname,password);
		int result=admindao.validate(login);
		 
		if(result==1) {
			session.setAttribute("aname", aname);
			return "AdminHome";
		}else {
			mv.addAttribute("error", "Wrong Credentials!!!");
			return "admin";
		}
		
		
}
}