package com.example.demo;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootTest
@ComponentScan(basePackages= {"com.construction."})
class ConstructionApplicationTests {

	@Test
	void contextLoads() {
		
	}
	
    @Bean
    @Profile("test")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/constructions");
        dataSource.setUsername("root");
        dataSource.setPassword("cse23");

        return dataSource;
    }
    


}
