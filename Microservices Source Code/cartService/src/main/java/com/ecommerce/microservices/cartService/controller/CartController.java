package com.ecommerce.microservices.cartService.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.microservices.cartService.model.Product;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("*")
public class CartController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String BASE_URL="http://localhost:9000/api/product/";
	private List<Product> productList = new ArrayList<>();
	
	@GetMapping("/add-multiple-to-cart/{category}/{brand}")
	public List<Product> addMultipleToCart(@PathVariable("category")String category, @PathVariable("brand")String brand ){
		
		String uri = BASE_URL+"/products-by-category/"+category;
		List<LinkedHashMap<String,Object>> response = restTemplate.getForObject(uri, List.class);
		List<Product> tempList = new ArrayList<>();
		
		for(LinkedHashMap<String, Object> productMap : response) {
			Integer pId = (Integer)productMap.get("id");
			String pName = (String)productMap.get("name");
			String pBrand = (String)productMap.get("brand");
			String pCategory = (String)productMap.get("category");
			Double price = (Double)productMap.get("price");
			
			Product product = new Product(pId, pName, pBrand, pCategory, price);
			tempList.add(product);
		}
		
		productList = tempList.stream().filter((prod)->prod.getBrand().equals(brand)).collect(Collectors.toList());
		return productList;
	}
	
	
	@GetMapping("add-one-to-cart/{productId}")
	public Product addOneToCart(@PathVariable("productId")int id) {
		productList.clear();
		String url = BASE_URL+id;
		Product product = restTemplate.getForObject(url, Product.class);
		productList.add(product);
		return product;
	}
	
	@GetMapping("/view-cart")
	public List<Product> viewCart(){
		return productList;
	}
	
}
