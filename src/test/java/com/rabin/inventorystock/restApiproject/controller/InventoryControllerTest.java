package com.rabin.inventorystock.restApiproject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rabin.inventorystock.restApiproject.service.ProductService;
import com.rabin.inventorystock.restApiproject.vo.ProductVo;
@ExtendWith(MockitoExtension.class)
class InventoryControllerTest {
	
	@InjectMocks
	InventoryController inventoryController;
	
	@Mock
	ProductService productService;
	
	ProductVo productVo;
	List<ProductVo>productVoList;
	
	@BeforeEach
	void setup() throws Exception {
		productVo=new ProductVo();
		productVo.setName("Material");
		productVo.setDescription("building material");
		productVo.setPrice(2000);
		productVo.setQuantity(5000);
		
		productVoList=new ArrayList<>();
		productVoList.add(productVo);
	}
	
//	@GetMapping("/getAllRecords")
//	public ResponseEntity<List<ProductVo>> getAllListOfRecord() {
//		List<ProductVo> productVo = productService.getAllProductRrecord();
//		if (productVo.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		} else {
//			return new ResponseEntity<>(productVo, HttpStatus.OK);
//		}
//	}

	@Test
	void testGetAllListOfRecord() {
		
		when(productService.getAllProductRrecord()).thenReturn(productVoList);
		
		ResponseEntity<List<ProductVo>> response= inventoryController.getAllListOfRecord();
		
		assertNotNull(productVoList);
		// Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productVoList, response.getBody());

        // Verify that the getAllProductRrecord() method was called once on the mock ProductService
        verify(productService, times(1)).getAllProductRrecord();
	}
	
	
	
//	@PostMapping("/productIncomings")
//	public ResponseEntity<ProductVo> inventoryProductIncoming(@RequestBody ProductVo productVo) {
//		ProductVo product = productService.incomingProductFromOutsideIntoInventory(productVo);
//		return ResponseEntity.ok(product);
//	}
	
	@Test
	void testInventoryProductIncoming() {
		when(productService.incomingProductFromOutsideIntoInventory(any())).thenReturn(productVo);
		
		ResponseEntity<ProductVo> response=inventoryController.inventoryProductIncoming(productVo);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}

}
