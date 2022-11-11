package com.microservices.ecommerce.productService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.microservices.ecommerce.productService.model.Product;
import com.microservices.ecommerce.productService.dao.ProductRepository;

public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository ProductRepository;
	
	
	public List<Product> getAllProduct(){
		return this.ProductRepository.findAll();
	}
	
	public Optional<Product> getProductById(long ProductId){
		return this.ProductRepository.findById(ProductId);
	}
	
	public Product saveProduct(Product Product) {
		return this.ProductRepository.save(Product);
	}
	
	public void deleteProduct(Product existingProduct) {
		this.ProductRepository.delete(existingProduct);
	}

}
