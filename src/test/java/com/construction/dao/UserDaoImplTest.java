package com.construction.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.construction.model.User;

class UserDaoImplTest {

	@Test
	void userLogin() {
		UserDaoImpl userdao = new UserDaoImpl();
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    ((DriverManagerDataSource) dataSource).setDriverClassName("com.mysql.cj.jdbc.Driver");
	    ((AbstractDriverBasedDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/constructions");
	    ((AbstractDriverBasedDataSource) dataSource).setUsername("root");
		((AbstractDriverBasedDataSource) dataSource).setPassword("cse23");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userdao.setJdbcTemplate(jdbcTemplate);
		userdao.setDatasource(dataSource);
		String ranjith = null;
		String passoward = null;
		User user = new User(ranjith,passoward);
		assertEquals(0, userdao.validate(user));
	}
	
	@Test
	public void userRegister() {
		  UserDaoImpl userdao = new UserDaoImpl();
		  DriverManagerDataSource dataSource = new DriverManagerDataSource();
		  ((DriverManagerDataSource) dataSource).setDriverClassName("com.mysql.cj.jdbc.Driver");
		  ((AbstractDriverBasedDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/constructions");
		  ((AbstractDriverBasedDataSource) dataSource).setUsername("root");
	      ((AbstractDriverBasedDataSource) dataSource).setPassword("cse23");
	      JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	      userdao.setJdbcTemplate(jdbcTemplate);
	      userdao.setDatasource(dataSource);
   		  User user = User.create("mukesh", "n", "Mukesh", "23-06-2000", "male", "8956262529", "mukesh@gmail.com", "mukesh123");
   		  boolean u_id = userdao.saveUser(user);
		  equals(u_id == true);
	}
}

