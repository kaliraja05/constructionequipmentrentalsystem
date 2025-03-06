package com.construction.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.construction.model.Order;

class OrderDaoImplTest {

	@Test
	public void listAllOrdersInAdmin() {
		OrderDaoImpl orderdao = new OrderDaoImpl();
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    ((DriverManagerDataSource) dataSource).setDriverClassName("com.mysql.cj.jdbc.Driver");
	    ((AbstractDriverBasedDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/constructions");
	    ((AbstractDriverBasedDataSource) dataSource).setUsername("root");
		((AbstractDriverBasedDataSource) dataSource).setPassword("cse23");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		orderdao.setJdbcTemplate(jdbcTemplate);
		orderdao.setDatasource(dataSource);
		List<Order> list = orderdao.getOrder();
		equals(list.size() >= 1);
	}


	
	
	@Test
	public void deleteOrderUser( ) {
		OrderDaoImpl orderdaoimpl = new OrderDaoImpl();
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
		    ((DriverManagerDataSource) dataSource).setDriverClassName("com.mysql.cj.jdbc.Driver");
		    ((AbstractDriverBasedDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/constructions");
		    ((AbstractDriverBasedDataSource) dataSource).setUsername("root");
			((AbstractDriverBasedDataSource) dataSource).setPassword("cse23");
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			orderdaoimpl.setJdbcTemplate(jdbcTemplate);
			orderdaoimpl.setDatasource(dataSource);
			int affectedrow = orderdaoimpl.deleteOrder(16);
			assertTrue(affectedrow == 0);
	}
	
	@Test
	public void orderRetriveByUserId() {
		OrderDaoImpl orderdao = new OrderDaoImpl();
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
		    ((DriverManagerDataSource) dataSource).setDriverClassName("com.mysql.cj.jdbc.Driver");
		    ((AbstractDriverBasedDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/constructions");
		    ((AbstractDriverBasedDataSource) dataSource).setUsername("root");
			((AbstractDriverBasedDataSource) dataSource).setPassword("cse23");
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			orderdao.setJdbcTemplate(jdbcTemplate);
			orderdao.setDatasource(dataSource);
			List<Order> listorder = orderdao.getOrdersById(2);
			equals(listorder.size() >= 1);
	}
}
