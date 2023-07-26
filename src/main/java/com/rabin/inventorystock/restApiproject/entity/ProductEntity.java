package com.rabin.inventorystock.restApiproject.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="product")
public class ProductEntity{ //implements Serializable{
	//private static final long serialVersionUID=7565643646543636L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int product_id;
	//@Column(length=5,nullable=false)
	private String name;
	private int price;
	//@Column(length=5,nullable=false)
	private String description;
	private double quantity;
	private double cost;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id",referencedColumnName="id")
	private List<CategoryEntity> categories=new ArrayList<>();//Product class has a list of Category
	
	

	//CascadeType.ALL, which means that any changes made to the ProductEntity (e.g., persisting, updating,
	//or deleting) will be cascaded to the associated CategoryEntity instances.
	//FetchType.LAZY, the associated CategoryEntity instances will be loaded lazily, i.e., they will not 
	//be fetched from the database until explicitly accessed
	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductEntity( String name, int price, String description, double quantity, double cost,
			List<CategoryEntity> categories) {
		super();
		
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.cost = cost;
		this.categories = categories;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public List<CategoryEntity> getCategories() {
		return categories;
	}
	public void setCategories(List<CategoryEntity> categories) {
		this.categories = categories;
	}


	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", quantity=" + quantity + ", cost=" + cost + ", categories=" + categories + "]";
	}
	
	
	
	

}
//USE THIS ON POSTMAN
//{
//    "name":"electronics",
//    "price":"1500",
//    "description":"apple",
//    "quantity":"7500",
//    "category":[
//        {
//            "id":"111",
//            "name":"iphone",
//            "description":"iphone 14"
//        },
//        {
//            "id":"112",
//          "name":"laptop",
//            "description":"macbook"  
//        },
//        {
//            "id":"113",
//          "name":"watch",
//            "description":"iWatch"  
//        }
//    ]
//}
