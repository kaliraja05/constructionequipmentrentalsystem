package com.construction.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.construction.model.Admin;

class AdminDaoImplTest {

	@Test
	void adminVaidateTest() {
		AdminDaoImpl admindao = new AdminDaoImpl();
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    ((DriverManagerDataSource) dataSource).setDriverClassName("com.mysql.cj.jdbc.Driver");
	    ((AbstractDriverBasedDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/constructions");
	    ((AbstractDriverBasedDataSource) dataSource).setUsername("root");
		((AbstractDriverBasedDataSource) dataSource).setPassword("cse23");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		admindao.setJdbcTemplate(jdbcTemplate);
		Admin admin =new Admin("mukesh","password");
		assertEquals(1,admindao.validate(admin));
		
	}
	
	@Test
	public void saveAdminTest() {
		  AdminDaoImpl admindao = new AdminDaoImpl();
		  DriverManagerDataSource dataSource = new DriverManagerDataSource();
		  ((DriverManagerDataSource) dataSource).setDriverClassName("com.mysql.cj.jdbc.Driver");
		  ((AbstractDriverBasedDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/constructions");
		  ((AbstractDriverBasedDataSource) dataSource).setUsername("root");
	      ((AbstractDriverBasedDataSource) dataSource).setPassword("cse23");
	      JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	      admindao.setJdbcTemplate(jdbcTemplate);
   		  Admin admin = new Admin("mukesh", "mukesh@gmail.com", "password");
   		  assertTrue(admindao.saveAdmin(admin));
	}

}
