package com.microservices.ecommerce.productService.service;

import java.util.List;
import java.util.Optional;

import com.microservices.ecommerce.productService.model.Product;

public interface ProductService {

	public List<Product> getAllProduct();

	public Optional<Product> getProductById(long productId);

	public Product saveProduct(Product saveProduct);

	public void deleteProduct(Product existingProduct);
}
