package com.microservices.ecommerce.productService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.ecommerce.productService.model.Product;
import com.microservices.ecommerce.productService.service.ProductService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	private ProductService ProductService;
	
	@GetMapping
	public List<Product> getAllProduct(){
		return this.ProductService.getAllProduct();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") long productId){
		return this.ProductService.getProductById(productId).orElseThrow();
	}
	
	@GetMapping("/products-by-category/{category}")
	public List<Product> getProductBycategory(@PathVariable("category") String category) {
		List<Product> products = this.ProductService.getAllProduct();
		List<Product> tempProductList = new ArrayList<Product>();
		for(Product product : products) {
			if(product.getCategory().equals(category)) {
				Long pId = product.getId();
				String pName = product.getName();
				String pBrand = product.getBrand();
				String pCategory = product.getCategory();
				Double price = product.getPrice();
				
				Product filteredProduct = new Product(pId,pName,pBrand,pCategory,price);
				tempProductList.add(filteredProduct);
			}
			
		}
		
		return tempProductList;
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product Product) {
		return this.ProductService.saveProduct(Product);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@RequestBody Product Product, @PathVariable("id") long ProductId) {
		
		Product existingProduct = this.ProductService.getProductById(ProductId).orElseThrow();
		//existingProduct.setTopic(Product.getTopic());
		//existingProduct.setDescription(Product.getDescription());
		return this.ProductService.saveProduct(existingProduct);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") long ProductId) {
		Product existingProduct = this.ProductService.getProductById(ProductId).orElseThrow();
		this.ProductService.deleteProduct(existingProduct);
		
		return ResponseEntity.ok().build();
	}
	

}
