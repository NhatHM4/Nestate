package com.example.webdbs.service.impl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<NewsDetail> findAll() {
		// TODO Auto-generated method stub
		return detailRepository.findAll();
	}

	@Override
	public void delete(NewsDetail newsDetail) {
		detailRepository.delete(newsDetail);
		
	}

	@Override
	public NewsDetail findById(Long id) {
		// TODO Auto-generated method stub
		Optional<NewsDetail> findById = detailRepository.findById(id);
		if (findById.isEmpty()) {
			return null;
		}
		return findById.get();
	}
	
	

}
