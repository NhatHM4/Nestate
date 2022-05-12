package com.example.webdbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.webdbs.entity.ImageHome;
import com.example.webdbs.service.ImageHomeService;

public class ImageHomeServiceImpl implements ImageHomeService {

	@Autowired
	private ImageHomeService imageHomeService;
	
	@Override
	public ImageHome save(ImageHome imageHome) {
		// TODO Auto-generated method stub
		return imageHomeService.save(imageHome);
	}

}
