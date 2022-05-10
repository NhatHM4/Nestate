package com.example.webdbs.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.webdbs.entity.ProductDetail;

@Controller
public class AddProdetailController {

	@PostMapping("/add")
	public String addProjectDetail(@ModelAttribute("projectDetail") ProductDetail productDetail) {
		System.out.println(productDetail);
		return "";
	}
}
