package com.ecommerce.microservices.priceService.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.microservices.priceService.model.Price;


@RestController
@RequestMapping("/api/product-price")
@CrossOrigin("*")
public class PriceController {
	
	@Autowired
	private RestTemplate restTemplate;
	private String BASE_URL="http://localhost:9000/api/product";
	
	@GetMapping
	public List<Price> getAllProductPrice(){
		
		String uri = BASE_URL;
		List<LinkedHashMap<String,Object>> response = restTemplate.getForObject(uri, List.class);
		List<Price> tempList = new ArrayList<Price>();
		for (LinkedHashMap<String, Object> productMap : response) {
			Integer productId = (Integer)productMap.get("id");
			Double price =(Double)productMap.get("price");
			Price productPrice = new Price(productId,price);
			tempList.add(productPrice);
		}
		return tempList;
	}
	
	@GetMapping("/{id}")
	public Double getProductPriceById(@PathVariable("id") Integer productId,Double productPrice){
		String uri = BASE_URL;
		List<LinkedHashMap<String,Object>> response = restTemplate.getForObject(uri, List.class);
//		Double productPrice = 0.0 ;
		for (LinkedHashMap<String, Object> productMap : response) {
			Integer getId = (Integer)productMap.get("id");
			if(getId.equals(productId)) {
				Double price = (Double)productMap.get("price");
				productPrice = price;
			}
			
		}
		return productPrice;
	}

}
