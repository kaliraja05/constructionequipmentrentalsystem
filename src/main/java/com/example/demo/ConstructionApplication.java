package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
@ComponentScan("com.construction.")
public class ConstructionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConstructionApplication.class, args);
		
		
	}
}
