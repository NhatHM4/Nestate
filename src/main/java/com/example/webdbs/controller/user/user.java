package com.example.webdbs.controller.user;

import java.math.BigInteger;
import java.security.Principal;

import org.hibernate.annotations.Parameter;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webdbs.entity.NewsDetail;
import com.example.webdbs.entity.ProductDetail;
import com.example.webdbs.service.ProductDetailService;

@Controller
@RequestMapping("")
public class user {
	@Autowired
	private ProductDetailService productDetailService;

	
	@GetMapping("/showAllProduct")
	private String showAllProduct(Model model) {
		java.util.List<ProductDetail> listProductDetail = productDetailService.getAll();
		model.addAttribute("allProduct",listProductDetail);
	
		for (ProductDetail productDetail : listProductDetail) {
			System.out.print("--------"+productDetail.getName());
		}
		return "Management/product";
	}
	
	@RequestMapping("/detailProduct/{productID}")
	private String showProduct(Model model,@PathVariable("productID") Long productID ) {
		ProductDetail productDetail = productDetailService.getOneByID(productID);
		model.addAttribute("product",productDetail);
		return "Management/detailProduct";
	}
	
	@GetMapping("/showNew")
	private String showNew(Model model) {
		 
		return "Management/news";
	}
}
