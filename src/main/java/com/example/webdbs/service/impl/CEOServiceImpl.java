package com.example.webdbs.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webdbs.entity.CEO;
import com.example.webdbs.respository.CEORepository;
import com.example.webdbs.service.CEOService;

@Service
public class CEOServiceImpl implements CEOService{

	@Autowired
	private CEORepository ceoRepository;
	
	@Override
	public CEO findById(Long id) {
		Optional<CEO> findById = ceoRepository.findById(id);
		if (findById.isEmpty()) {
			return null;
		}
		return findById.get();
	}

	@Override
	public void save(CEO ceo) {
		ceoRepository.save(ceo);
		
	}

}
