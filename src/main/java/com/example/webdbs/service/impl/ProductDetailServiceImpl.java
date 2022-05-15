package com.example.webdbs.service.impl;

import java.util.List;


import java.util.Optional;


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

	@Override
	public List<ProductDetail> getAll(){
		List<ProductDetail> listProductDetails = productDetailRepository.findAll();
		return listProductDetails;
	}
	
	@Override
	public ProductDetail getOneByID(Long productID){
		ProductDetail productDetail2 = productDetailRepository.getOnebyProductID(productID);
		return productDetail2;
	}


	

	@Override
	public List<ProductDetail> findAllProductDetail() {
		// TODO Auto-generated method stub
		return productDetailRepository.findAll();
	}



	@Override
	public void deleteProductDetail(ProductDetail productDetail) {
		productDetailRepository.delete(productDetail);
		
	}



	@Override
	public ProductDetail findById(Long id) {
		Optional<ProductDetail> findById = productDetailRepository.findById(id);
		if (findById.isEmpty()) {
			return null;
		}
		return findById.get();
	}




	
	
	
	
	


}
