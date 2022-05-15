package com.example.webdbs.service;

import java.util.List;


import org.springframework.stereotype.Service;


import com.example.webdbs.entity.ProductDetail;


public interface ProductDetailService {

	ProductDetail save(ProductDetail productDetail);

	
	List<ProductDetail> findAllProductDetail();
	
	void deleteProductDetail(ProductDetail productDetail);
	
	ProductDetail findById(Long id);


	List<ProductDetail> getAll();

	ProductDetail getOneByID(Long productID);
}
