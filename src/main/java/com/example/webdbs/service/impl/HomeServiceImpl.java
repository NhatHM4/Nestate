package com.example.webdbs.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webdbs.entity.Home;
import com.example.webdbs.respository.HomeRepository;
import com.example.webdbs.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{

	@Autowired
	private HomeRepository homeRepository;
	
	@Override
	public Home findById(Long id) {
			Optional<Home> findById = homeRepository.findById(id);
			if (findById.isEmpty()) {
				return null;
			}
		return findById.get();
	}

	@Override
	public Home save(Home home) {
		
		return homeRepository.save(home);
	}

}
