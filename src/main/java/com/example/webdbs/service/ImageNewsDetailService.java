package com.example.webdbs.service;

import org.springframework.stereotype.Service;

import com.example.webdbs.entity.ImageNewsDetail;

@Service
public interface ImageNewsDetailService {

	ImageNewsDetail save(ImageNewsDetail image);
}
