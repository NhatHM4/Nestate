package com.example.webdbs.service;

import org.springframework.stereotype.Service;

import com.example.webdbs.entity.Home;

@Service
public interface HomeService {
	
	Home findById(Long id);
	
	Home save(Home home);
}
