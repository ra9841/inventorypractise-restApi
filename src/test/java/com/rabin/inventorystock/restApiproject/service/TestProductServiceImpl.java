package com.rabin.inventorystock.restApiproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rabin.inventorystock.restApiproject.entity.ProductEntity;
import com.rabin.inventorystock.restApiproject.repository.ProductRepository;
import com.rabin.inventorystock.restApiproject.vo.ProductVo;
@ExtendWith(MockitoExtension.class)
class TestProductServiceImpl {

	@Mock
	private ProductRepository poductRepostitory;
	
	@InjectMocks
	private ProductServiceImpl productServiceImpl;
	
	ProductEntity productEntity;
	ProductEntity productEntity1;
	List<ProductEntity>productEntityList;
	
	@BeforeEach
	void setup() {
		productEntity=new ProductEntity();
		productEntity.setName("Material");
		productEntity.setDescription("building material");
		productEntity.setPrice(2000);
		productEntity.setProduct_id(134556787);
		productEntity.setQuantity(5000);
		
		productEntity1=new ProductEntity();
		productEntity1.setName("Technology");
		productEntity1.setDescription("laptop & charger");
		productEntity1.setPrice(5000);
		productEntity1.setProduct_id(135447834);
		productEntity1.setQuantity(9000);
		
		productEntityList=new ArrayList<>();
		productEntityList.add(productEntity);
		productEntityList.add(productEntity1);
	}
	
	
//	@Override
//	public List<ProductVo> getAllProductRrecord() {
//	    List<ProductEntity> productEntityList = poductRepostitory.findAll();
//	    
//	    return productEntityList.stream()
//	        .map(product -> {
//	          //  ModelMapper model = new ModelMapper();
//	          //  return model.map(product, ProductVo.class);
//	        	ProductVo productVo = new ProductVo();
//	        	BeanUtils.copyProperties(product, productVo);
//	            return productVo;
//	        })
//	        .collect(Collectors.toList());
//	}
	@Test
	final void testGetAllProductRrecord() {
		//Arrange			
		when(poductRepostitory.findAll()).thenReturn(productEntityList);
		
		//Act
		List<ProductVo>result=productServiceImpl.getAllProductRrecord();//calling method
		
		//Assert
		assertEquals(productEntityList.size(),result.size());
	        assertEquals(productEntity.getDescription(), result.get(0).getDescription());
	        assertEquals(productEntity.getName(),result.get(0).getName());
	        assertEquals(productEntity.getPrice(), result.get(0).getPrice());

	        assertEquals(productEntity1.getDescription(), result.get(1).getDescription());
	        assertEquals(productEntity1.getName(),result.get(1).getName());
	        assertEquals(productEntity1.getPrice(), result.get(1).getPrice());
		
	}
	
//	@Override
//	public List<ProductVo> getProductRecordByName(String name){
//		List<ProductEntity> productEntity = poductRepostitory.findByName(name);
//		List<ProductVo> productVoList = new ArrayList<>();// blank list
//	
//			if (!productEntity.isEmpty()) {
//				for (ProductEntity product : productEntity) {
//					ProductVo ProductVo = new ProductVo();
//					BeanUtils.copyProperties(product, ProductVo);
//					productVoList.add(ProductVo);
//				}
//			}else {
//				throw new EmptyDataException("Empty data received");
//			}
//			return productVoList;
//		}

	@Test
	final void testGetProductRecordByName() {
		//arrange	
		when(poductRepostitory.findByName(any())).thenReturn(productEntityList);
		
		//Act
		List<ProductVo> result=productServiceImpl.getProductRecordByName("Material");
		
		//Assert
		assertNotNull(result);
		assertEquals(productEntity.getDescription(),result.get(0).getDescription(),"this is description of product");
		assertEquals(productEntity.getPrice(),result.get(0).getPrice(),"this is price of product");//this is optional: ,"this is price of product"
			
	}

	//for exceptionHandling
	@Test
	final void testProductEntityEmpty() {
		when(poductRepostitory.findByName(any())).thenReturn(null);
		
		assertThrows(NullPointerException.class,
				()->{
					productServiceImpl.getProductRecordByName("Material");
				}
				);
		
	}


}
