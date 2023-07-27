package com.rabin.inventorystock.restApiproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabin.inventorystock.restApiproject.entity.CategoryEntity;
import com.rabin.inventorystock.restApiproject.entity.ProductEntity;
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

}
