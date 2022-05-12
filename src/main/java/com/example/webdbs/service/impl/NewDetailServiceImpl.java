package com.example.webdbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webdbs.entity.NewsDetail;
import com.example.webdbs.respository.NewsDetailRepository;
import com.example.webdbs.service.NewDetailService;

@Service
public class NewDetailServiceImpl implements NewDetailService{

	@Autowired
	private NewsDetailRepository detailRepository;
	
	@Override
	public NewsDetail save(NewsDetail newsDetail) {
		// TODO Auto-generated method stub
		return detailRepository.save(newsDetail);
	}

}
