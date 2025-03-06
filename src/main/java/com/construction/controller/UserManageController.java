package com.construction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.construction.dao.UserDao;
import com.construction.model.User;

@Controller
public class UserManageController {
     
	@Autowired
	private UserDao userdao;
	@Autowired
	private User user;
	
        
     @GetMapping("/viewuser") 
     public  String viewusers(Model model) {
        	List<User> list = userdao.getUser();
        	model.addAttribute("list",list);
        	return "UserManage";
        }
     
     @RequestMapping(value="/edituser",method = RequestMethod.GET)
     public String edit(@RequestParam("u_id") int u_id , Model m ) {
    	 user = userdao.getUserById(u_id);
    	 m.addAttribute("user", user);
    	 return "EditUser";
     }
     
     
     @RequestMapping(value="/save",method=RequestMethod.POST)
     public String update(@ModelAttribute("user") User user) {
    	 userdao.update(user);
    	 return "redirect:viewuser";
     }
     
     @RequestMapping("/deleteuser")
     public String deleteUser(@RequestParam("u_id") int u_id) {
    	 userdao.delete(u_id);
    	 return "redirect:viewuser";
     }
     
}
