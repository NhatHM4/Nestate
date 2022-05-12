package com.example.webdbs.service;

import org.springframework.stereotype.Service;

import com.example.webdbs.entity.ImageProductDetail;

@Service
public interface ImageProductDetailService {
	
	ImageProductDetail save(ImageProductDetail imageProductDetail) ;
}
