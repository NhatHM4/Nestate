package com.example.webdbs.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.webdbs.entity.NewsDetail;

@Service
public interface NewDetailService {

	NewsDetail save(NewsDetail newsDetail);
	
	List<NewsDetail> findAll();
	
	void delete(NewsDetail newsDetail);
	
	NewsDetail findById(Long id);

}
