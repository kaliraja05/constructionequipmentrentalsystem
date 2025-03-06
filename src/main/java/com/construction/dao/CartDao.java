package com.construction.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.construction.model.Cart;

@Service
public interface CartDao {
	
	public List<Cart> displayCartById(int u_id);
	public boolean addToCart(Cart cart) ;
    public List<Cart> getCartById(int u_id);
    public int deleteCartAfterOrder(int u_id);
    public int deleteCart(int cart_id);

}
