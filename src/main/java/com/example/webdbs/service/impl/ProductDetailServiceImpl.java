package com.example.webdbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webdbs.entity.ProductDetail;
import com.example.webdbs.respository.ProductDetailRepository;
import com.example.webdbs.service.ProductDetailService;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

	@Autowired
	private ProductDetailRepository productDetailRepository;
	
	@Override
	public ProductDetail save(ProductDetail productDetail) {
		// TODO Auto-generated method stub
		return productDetailRepository.save(productDetail);
	}

}
