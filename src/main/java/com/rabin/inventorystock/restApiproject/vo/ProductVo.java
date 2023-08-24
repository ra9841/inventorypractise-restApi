  package com.rabin.inventorystock.restApiproject.vo;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductVo {
	private int product_id;
	private String name;
	private int price;
	private String description;
	private double quantity;
	private List<CategoryVo> categories;
	public ProductVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductVo(int product_id, String name, int price, String description, double quantity,
			List<CategoryVo> categories) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.categories = categories;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public List<CategoryVo> getCategories() {
		return categories;
	}
	public void setCategories(List<CategoryVo> categories) {
		this.categories = categories;
	}
	public static ResponseEntity<ProductVo> builder() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}