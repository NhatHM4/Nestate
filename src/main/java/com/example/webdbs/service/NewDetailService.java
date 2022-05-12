package com.example.webdbs.service;

import org.springframework.stereotype.Service;

import com.example.webdbs.entity.NewsDetail;

@Service
public interface NewDetailService {

	NewsDetail save(NewsDetail newsDetail);
}
