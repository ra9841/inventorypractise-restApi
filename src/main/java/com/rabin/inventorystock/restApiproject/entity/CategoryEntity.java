package com.rabin.inventorystock.restApiproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int category_id;
	private String name;
	private String discreption;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;
	public CategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryEntity( int category_id, String name, String discreption, ProductEntity product) {
		super();
		
		this.category_id = category_id;
		this.name = name;
		this.discreption = discreption;
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscreption() {
		return discreption;
	}
	public void setDiscreption(String discreption) {
		this.discreption = discreption;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	
	


}
