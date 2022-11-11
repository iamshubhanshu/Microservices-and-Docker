package com.ecommerce.microservices.cartService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CartServiceApplication {
	
	@Bean
	public RestTemplate restemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
	}
}
