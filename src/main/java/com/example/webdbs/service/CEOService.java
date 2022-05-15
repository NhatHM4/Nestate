package com.example.webdbs.service;

import org.springframework.stereotype.Service;

import com.example.webdbs.entity.CEO;

@Service
public interface CEOService {

	CEO findById(Long id);
	
	void save(CEO ceo);
}
