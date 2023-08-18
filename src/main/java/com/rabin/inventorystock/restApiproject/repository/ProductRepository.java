package com.rabin.inventorystock.restApiproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rabin.inventorystock.restApiproject.entity.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer>{

	List<ProductEntity> findByName(String name);

	

}
