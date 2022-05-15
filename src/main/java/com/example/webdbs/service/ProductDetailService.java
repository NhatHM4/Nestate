package com.example.webdbs.service;

import java.util.List;



import com.example.webdbs.entity.ProductDetail;


public interface ProductDetailService {

	ProductDetail save(ProductDetail productDetail);

	List<ProductDetail> getAll();

	ProductDetail getOneByID(Long productID);
}
