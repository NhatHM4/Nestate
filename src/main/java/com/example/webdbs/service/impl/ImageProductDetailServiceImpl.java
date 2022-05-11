package com.example.webdbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.webdbs.entity.ImageProductDetail;
import com.example.webdbs.respository.ImageProductDetailRepository;
import com.example.webdbs.service.ImageProductDetailService;

public class ImageProductDetailServiceImpl implements ImageProductDetailService{

	@Autowired
	private ImageProductDetailRepository imageProductDetailRepository;
	
	@Override
	public ImageProductDetail save(ImageProductDetail imageProductDetail) {
		// TODO Auto-generated method stub
		return imageProductDetailRepository.save(imageProductDetail);
	}

}
