package com.construction.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.construction.model.Product;

class ProductDaoImplTest {

	@Test
	public void testAddToProduct() {
		ProductDaoImpl productdao = new ProductDaoImpl();
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    ((DriverManagerDataSource) dataSource).setDriverClassName("com.mysql.cj.jdbc.Driver");
	    ((AbstractDriverBasedDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/constructions");
	    ((AbstractDriverBasedDataSource) dataSource).setUsername("root");
		((AbstractDriverBasedDataSource) dataSource).setPassword("cse23");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		productdao.setJdbcTemplate(jdbcTemplate);
		Product pro = new Product(1,"Hammr",12,1);
		assertTrue(productdao.addproduct(pro));
	}
	
	@Test
	public void testUpdateProduct() {
		ProductDaoImpl productdao = new ProductDaoImpl();
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    ((DriverManagerDataSource) dataSource).setDriverClassName("com.mysql.cj.jdbc.Driver");
	    ((AbstractDriverBasedDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/constructions");
	    ((AbstractDriverBasedDataSource) dataSource).setUsername("root");
		((AbstractDriverBasedDataSource) dataSource).setPassword("cse23");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		productdao.setJdbcTemplate(jdbcTemplate);
		Product pro = new Product(1,"Hammrr",12,8);
		assertEquals(1,productdao.updateProduct(pro));
	}
	
	@Test
	public void testDeleteProduct() {
		ProductDaoImpl productdao = new ProductDaoImpl();
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    ((DriverManagerDataSource) dataSource).setDriverClassName("com.mysql.cj.jdbc.Driver");
	    ((AbstractDriverBasedDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/constructions");
	    ((AbstractDriverBasedDataSource) dataSource).setUsername("root");
		((AbstractDriverBasedDataSource) dataSource).setPassword("cse23");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		productdao.setJdbcTemplate(jdbcTemplate);
		assertEquals(1,productdao.deleteProduct(12));
	}
	@Test
	public void testGetById() {
		ProductDaoImpl productdao = new ProductDaoImpl();
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    ((DriverManagerDataSource) dataSource).setDriverClassName("com.mysql.cj.jdbc.Driver");
	    ((AbstractDriverBasedDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/constructions");
	    ((AbstractDriverBasedDataSource) dataSource).setUsername("root");
		((AbstractDriverBasedDataSource) dataSource).setPassword("cse23");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		productdao.setJdbcTemplate(jdbcTemplate);
		Product pro = new Product(3,"Nail Puller",12,1	);
		Product prod =productdao.getProductById(3);
		assertEquals(pro.getProduct_id(),prod.getProduct_id());
	}

}
