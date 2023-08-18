package com.rabin.inventorystock.restApiproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/getAllRecords")
	public ResponseEntity<List<ProductVo>> getAllListOfRecord() {
		List<ProductVo> productVo = productService.getAllProductRrecord();
		if (productVo.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(productVo, HttpStatus.OK);
		}
	}
	
		
		@GetMapping("/getParticularRecords/{name}")
		public ResponseEntity<List<ProductVo>> getRecordByName(@PathVariable String name){
			List<ProductVo>product =productService.getProductRecordByName(name);
			if (product.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(product, HttpStatus.OK);
			}
		}
		
		@GetMapping("/sortingOnNames")
		public ResponseEntity<List<ProductVo>> sortingAllRecord(){
			List<ProductVo>product=productService.sortingRecordInAscendingOrder();
			if (product.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(product, HttpStatus.OK);
			}
		}
		
		@GetMapping("/sortingOnPrices")
		public ResponseEntity<List<ProductVo>> sortingAllRecordOnPrice(){
			List<ProductVo>product=productService.sortingRecordInAscendingOrderOnPrice();
			if (product.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(product, HttpStatus.OK);
			}
		}
		
		@GetMapping("/sortingDescendingOnPrices")
		public ResponseEntity<List<ProductVo>> sortingAllRecordOnPriceOnDscending(){
			List<ProductVo>product=productService.sortingRecordInAscendingOrderOnPriceOnDscending();
			if (product.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(product, HttpStatus.OK);
			}
		}

	

}
