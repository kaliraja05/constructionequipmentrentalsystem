package com.construction.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.construction.model.Cart;

class CartDaoImplTest {

	@Test
	public void testAddToCart() {
		CartDaoImpl cartdao = new CartDaoImpl();
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    ((DriverManagerDataSource) dataSource).setDriverClassName("com.mysql.cj.jdbc.Driver");
	    ((AbstractDriverBasedDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/constructions");
	    ((AbstractDriverBasedDataSource) dataSource).setUsername("root");
		((AbstractDriverBasedDataSource) dataSource).setPassword("cse23");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		cartdao.setJdbcTemplate(jdbcTemplate);
		Cart cart = new Cart(1,1,"Hammer",12,1,1,12);
		assertTrue(cartdao.addToCart(cart));
	}
	
	@Test
	public void testDeleteCart() {
		CartDaoImpl cartdao = new CartDaoImpl();
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    ((DriverManagerDataSource) dataSource).setDriverClassName("com.mysql.cj.jdbc.Driver");
	    ((AbstractDriverBasedDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/constructions");
	    ((AbstractDriverBasedDataSource) dataSource).setUsername("root");
		((AbstractDriverBasedDataSource) dataSource).setPassword("cse23");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		cartdao.setJdbcTemplate(jdbcTemplate);
		assertEquals(1,cartdao.deleteCart(1));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testGetCartById() {
		CartDaoImpl cartdao = new CartDaoImpl();
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    ((DriverManagerDataSource) dataSource).setDriverClassName("com.mysql.cj.jdbc.Driver");
	    ((AbstractDriverBasedDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/constructions");
	    ((AbstractDriverBasedDataSource) dataSource).setUsername("root");
		((AbstractDriverBasedDataSource) dataSource).setPassword("cse23");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		cartdao.setJdbcTemplate(jdbcTemplate);
		List<Cart> cl = cartdao.getCartById(5);
		equals(cl.size() >= 1);
	}

}
