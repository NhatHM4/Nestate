package com.example.webdbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webdbs.entity.Admin;
import com.example.webdbs.respository.AdminRepository;
import com.example.webdbs.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public Admin findByUsernameAndPassword(String username, String password) {
		Admin admin = adminRepository.findByUsernameAndPassword(username, password);
		return admin;
	}

}
