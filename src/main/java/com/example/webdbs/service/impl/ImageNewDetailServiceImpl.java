package com.example.webdbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webdbs.entity.ImageNewsDetail;
import com.example.webdbs.respository.ImageNewDetailRepository;
import com.example.webdbs.service.ImageNewsDetailService;

@Service
public class ImageNewDetailServiceImpl implements ImageNewsDetailService{

	@Autowired
	 ImageNewDetailRepository imageNewDetailRepository;
	
	@Override
	public ImageNewsDetail save(ImageNewsDetail image) {
		// TODO Auto-generated method stub
		return imageNewDetailRepository.save(image);
	}

	
}
