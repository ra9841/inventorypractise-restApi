package com.rabin.inventorystock.restApiproject.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.rabin.inventorystock.restApiproject.entity.CategoryEntity;
import com.rabin.inventorystock.restApiproject.entity.ProductEntity;
import com.rabin.inventorystock.restApiproject.exception.EmptyDataException;
import com.rabin.inventorystock.restApiproject.repository.ProductRepository;
import com.rabin.inventorystock.restApiproject.vo.CategoryVo;
import com.rabin.inventorystock.restApiproject.vo.ProductVo;
@Transactional
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository poductRepostitory;

	@Override
	public ProductVo incomingProductFromOutsideIntoInventory(ProductVo productVo) {
		ProductEntity productEntity=new ProductEntity();//blank
		BeanUtils.copyProperties(productVo, productEntity);
		
		List<CategoryVo>CategoryVoo=productVo.getCategories();//getting categories and making process in list
		List<CategoryEntity>CategoryEntityList=new ArrayList<>();//blank list
		
		for(CategoryVo category:CategoryVoo) {
			CategoryEntity categoryEntity=new CategoryEntity();//blank
			BeanUtils.copyProperties(category, categoryEntity);
			Random random = new Random();//for random number because id cannot be shown in front it is primary key
			int randomWithNextInt = random.nextInt();
			categoryEntity.setCategory_id(randomWithNextInt);
			CategoryEntityList.add(categoryEntity);
		}
		productEntity.setCategories(CategoryEntityList);
		productEntity.setCost(productEntity.getPrice()*productEntity.getQuantity());
		Random random = new Random();//for random number because id cannot be shown in front it is primary key
		int randomWithNextInt = random.nextInt();
		productEntity.setProduct_id(randomWithNextInt);
		poductRepostitory.save(productEntity);
		
		ModelMapper model=new ModelMapper();//it is same as BeanUtils
		ProductVo productVoos=model.map(productEntity, ProductVo.class);
		return productVoos;
	}

//	@Override
//	public List<ProductVo> getAllProductRrecord() {
//		List<ProductEntity>productEntity= poductRepostitory.findAll();
//		List<ProductVo>productVoList=new ArrayList<>();//blank list
//		
//		for(ProductEntity product:productEntity) {
//			ModelMapper model=new ModelMapper();
//			ProductVo ProductVo=model.map(product, ProductVo.class);
//			productVoList.add(ProductVo);
//		}
//		
//		return productVoList;
//	}
	
	
	@Override
	public List<ProductVo> getAllProductRrecord() {
	    List<ProductEntity> productEntityList = poductRepostitory.findAll();
	    
	    return productEntityList.stream()
	        .map(product -> {
	          //  ModelMapper model = new ModelMapper();
	          //  return model.map(product, ProductVo.class);
	        	ProductVo productVo = new ProductVo();
	        	BeanUtils.copyProperties(product, productVo);
	            return productVo;
	        })
	        .collect(Collectors.toList());
	}

	@Override
	public List<ProductVo> getProductRecordByName(String name){
		List<ProductEntity> productEntity = poductRepostitory.findByName(name);
		List<ProductVo> productVoList = new ArrayList<>();// blank list
	
			if (!productEntity.isEmpty()) {
				for (ProductEntity product : productEntity) {
					ProductVo ProductVo = new ProductVo();
					BeanUtils.copyProperties(product, ProductVo);
					productVoList.add(ProductVo);
				}
			}else {
				throw new EmptyDataException("Empty data received");
			}
			return productVoList;
		}

	@Override
	public List<ProductVo> sortingRecordInAscendingOrder() {
		List<ProductVo> productVo=getAllProductRrecord() ;//calling method
		Comparator<ProductVo> comparator=Comparator.comparing(ProductVo::getName,String.CASE_INSENSITIVE_ORDER);
		Collections.sort(productVo,comparator);
		return productVo;
	}

//	@Override
//	public List<ProductVo> sortingRecordInAscendingOrderOnPrice() {
//		List<ProductVo> productVo=getAllProductRrecord() ;//calling method
//		Comparator<ProductVo>comparator=Comparator.comparing(ProductVo::getPrice);
//		Collections.sort(productVo,comparator);
//				
//		return productVo;
//	}
	
	
	@Override
	public List<ProductVo> sortingRecordInAscendingOrderOnPrice() {
	    List<ProductVo> productVoList = getAllProductRrecord(); // calling method
	    
	    return productVoList.stream()
	        .sorted(Comparator.comparing(ProductVo::getPrice))
	        .collect(Collectors.toList());
	}

	@Override
	public List<ProductVo> sortingRecordInAscendingOrderOnPriceOnDscending() {
		List<ProductVo> productVo=getAllProductRrecord() ;//calling method
		Comparator<ProductVo>comparator=Comparator.comparing(ProductVo::getPrice,Comparator.reverseOrder());
		Collections.sort(productVo,comparator);
		return productVo;
	} 
	
	

		
	
	
		
	}

	


