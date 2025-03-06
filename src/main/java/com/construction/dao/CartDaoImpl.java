package com.construction.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.construction.model.Cart;

@Component
public class CartDaoImpl implements CartDao {
	
   @Autowired
    private JdbcTemplate jdbcTemplate;
	@Autowired
	private Cart cart;
     @Override
    public List<Cart> displayCartById(int u_id){    
    	List<Cart> uList = new ArrayList<Cart>();
		String query = "select * from constructions.cart where user_id=? ";
		List<Map<String, Object>> orderRows = jdbcTemplate.queryForList(query, new Object[] {u_id});

		for (Map<String, Object> i : orderRows) {
			Cart cart = new Cart();

			        cart.setCart_id((int)i.get("cart_id"));        
	                cart.setUser_id((int)i.get("user_id"));
                    cart.setPro_id((int)i.get("pro_id"));
	                cart.setP_name((String)i.get("p_name"));
                    cart.setPrice((int)i.get("price"));
	                cart.setQuantity((int)i.get("quantity"));
	                cart.setTime((int)i.get("time"));
	                cart.setTotal_cost((int)i.get("total_cost"));
			
			uList.add(cart);
		}

		return uList;
    }
	@Override
	public boolean addToCart(Cart cart) {
		// TODO Auto-generated method stub
		boolean status = false;
		String query = "INSERT INTO cart(user_id, pro_id, p_name, price, quantity, time, total_cost) VALUES (?, ?, ?, ?, ?, ?, ?)";

		Object[] args = new Object[] { cart.getUser_id(), cart.getPro_id(), cart.getP_name(), cart.getPrice(), cart.getQuantity(), cart.getTime(), cart.getTotal_cost() };

		int out = jdbcTemplate.update(query, args);
		if(out>0)
		{
			status=true;
		}
		else {
			status=false;
		}
		return status;
	}
	
	 @Override
	    public List<Cart> getCartById(int u_id){    
	    	List<Cart> uList = new ArrayList<Cart>();
			String query = "select * from constructions.cart where user_id=? ";
			List<Map<String, Object>> orderRows = jdbcTemplate.queryForList(query, new Object[] {u_id});

			for (Map<String, Object> i : orderRows) {
				Cart cart = new Cart();

				        cart.setCart_id((int)i.get("cart_id"));        
		                cart.setUser_id((int)i.get("user_id"));
	                    cart.setPro_id((int)i.get("pro_id"));
		                cart.setP_name((String)i.get("p_name"));
	                    cart.setPrice((int)i.get("price"));
		                cart.setQuantity((int)i.get("quantity"));
		                cart.setTime((int)i.get("time"));
		                cart.setTotal_cost((int)i.get("total_cost"));
				
				uList.add(cart);
			}

			return uList;
	    }
	 
	 @Override
	    public int deleteCartAfterOrder(int u_id){    
	        String sql="delete from cart where user_id="+u_id+"";    
	        return jdbcTemplate.update(sql);    
	    }   

	 @Override
	    public int deleteCart(int cart_id){    
	        String sql="delete from cart where cart_id="+cart_id+"";    
	        return jdbcTemplate.update(sql);    
	    }
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate2) {
		// TODO Auto-generated method stub
		
	}   
}
