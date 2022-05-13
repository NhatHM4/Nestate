package com.example.webdbs.controller.admin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.webdbs.entity.ImageProductDetail;
import com.example.webdbs.entity.ProductDetail;
import com.example.webdbs.service.ProductDetailService;

@Controller
public class ShowLishProductDetailController {

	@Autowired
	private ProductDetailService productDetailService;

	@GetMapping("/showListProductDetail")
	public String showListProductDetail(Model model) {
		List<ProductDetail> listProductDetail = productDetailService.findAllProductDetail();
		model.addAttribute("listProductDetail", listProductDetail);
		return "Management/Admin/showDetailProduct";
	}

	@GetMapping("/delete/{id}")
	public String deleteProductDetail(@PathVariable("id") ProductDetail productDetail, Model model) {

		productDetailService.deleteProductDetail(productDetail);
		return "redirect:/showListProductDetail";

	}

	@GetMapping("/edit/{idProductDetail}")
	public String edit(@PathVariable("idProductDetail") Long id, Model model) {
		ProductDetail productDetail = productDetailService.findById(id);
		List<ImageProductDetail> listImage = new LinkedList<ImageProductDetail>(productDetail.getSetImage());
		model.addAttribute("productDetail", productDetail);
		model.addAttribute("listImage", listImage);
		return "Management/Admin/EditDetailProduct";
	}

}
