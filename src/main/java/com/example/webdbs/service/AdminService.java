package com.example.webdbs.service;

import org.springframework.stereotype.Service;

import com.example.webdbs.entity.Admin;


public interface AdminService {

	public Admin findByUsernameAndPassword(String username, String password);
}
