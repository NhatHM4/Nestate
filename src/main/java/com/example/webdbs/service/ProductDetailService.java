package com.example.webdbs.service;

import org.springframework.stereotype.Service;

import com.example.webdbs.entity.ProductDetail;

@Service
public interface ProductDetailService {

	ProductDetail save(ProductDetail productDetail);
}
