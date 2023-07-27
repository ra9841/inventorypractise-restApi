package com.rabin.inventorystock.restApiproject.service;

import com.rabin.inventorystock.restApiproject.vo.ProductVo;

public interface ProductService {

	ProductVo incomingProductFromOutsideIntoInventory(ProductVo productVo);

}
