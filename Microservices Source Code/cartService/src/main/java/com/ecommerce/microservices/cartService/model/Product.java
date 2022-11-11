package com.ecommerce.microservices.cartService.model;


public class Product {

    private Integer id;
    private String name;
    private String brand;
    private String category;
    private Double price;
   
    public Product(Integer id, String name, String brand, String category, Double price) {
    	super();
    	
    	this.id = id;
    	this.name = name;
    	this.brand = brand;
    	this.category = category;
    	this.price = price;
    }
    
    public Product(String name, String brand, String category, Double price) {
    	super();
    	
    	this.name = name;
    	this.brand = brand;
    	this.category = category;
    	this.price = price;
    }
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
	
