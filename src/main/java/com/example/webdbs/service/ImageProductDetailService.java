package com.example.webdbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.webdbs.entity.ImageProductDetail;
import com.example.webdbs.entity.ProductDetail;


public interface ImageProductDetailService {
	
	ImageProductDetail save(ImageProductDetail imageProductDetail) ;
	 List<ProductDetail> getAll();
	 ProductDetail getOneByID(ProductDetail productDetail);
}
