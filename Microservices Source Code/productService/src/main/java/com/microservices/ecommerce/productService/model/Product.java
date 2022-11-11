package com.microservices.ecommerce.productService.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotNull(message = "Product name is required.")
    @Basic(optional = false)
    private String name;
    private String brand;
    private String category;
    
    
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

	private Double price;
    
    public Product() {
    	//Default Constructor
    }

    public Product(Long id, String name, String brand, String category, Double price) {
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
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

    //private String pictureUrl;

    // all arguments contructor 
    // standard getters and setters
}
