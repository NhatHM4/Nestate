package com.example.webdbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webdbs.entity.ImageHome;
import com.example.webdbs.respository.ImageHomeRepository;
import com.example.webdbs.service.ImageHomeService;

@Service
public class ImageHomeServiceImpl implements ImageHomeService {

	@Autowired
	private ImageHomeRepository imageHomeRepository;
	
	@Override
	public ImageHome save(ImageHome imageHome) {
		// TODO Auto-generated method stub
		return imageHomeRepository.save(imageHome);
	}

}
