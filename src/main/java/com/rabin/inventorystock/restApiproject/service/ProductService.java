package com.rabin.inventorystock.restApiproject.service;

import java.util.List;

import com.rabin.inventorystock.restApiproject.exception.EmptyDataException;
import com.rabin.inventorystock.restApiproject.vo.ProductVo;

public interface ProductService {

	ProductVo incomingProductFromOutsideIntoInventory(ProductVo productVo);

	List<ProductVo> getAllProductRrecord();

	List<ProductVo> getProductRecordByName(String name) throws EmptyDataException;

	List<ProductVo> sortingRecordInAscendingOrder();

	List<ProductVo> sortingRecordInAscendingOrderOnPrice();

	List<ProductVo> sortingRecordInAscendingOrderOnPriceOnDscending();

}
