package com.example.webdbs.service;

import org.springframework.stereotype.Service;

import com.example.webdbs.entity.ImageHome;

@Service
public interface ImageHomeService {
	
	ImageHome save(ImageHome imageHome);
}
