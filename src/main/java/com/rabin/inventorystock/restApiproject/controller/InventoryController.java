package com.rabin.inventorystock.restApiproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabin.inventorystock.restApiproject.service.ProductService;
import com.rabin.inventorystock.restApiproject.vo.ProductVo;

@RestController
@RequestMapping("/rabin")
public class InventoryController {
	@Autowired
	private ProductService productService;
	
//	@PostMapping("/productIncomings")
//	public ResponseEntity<String> inventoryProductIncoming(@RequestBody ProductVo productVo) {
//		productService.incomingProductFromOutsideIntoInventory(productVo);
//		return new ResponseEntity<>("save succesfully",HttpStatus.CREATED);
//	}
	@PostMapping("/productIncomings")
	public ResponseEntity<ProductVo> inventoryProductIncoming(@RequestBody ProductVo productVo) {
	    ProductVo product = productService.incomingProductFromOutsideIntoInventory(productVo);
	    return ResponseEntity.ok(product);
	}
	

}
