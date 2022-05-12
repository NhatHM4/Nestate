package com.example.webdbs.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.webdbs.entity.Admin;
import com.example.webdbs.entity.ProductDetail;

@Controller
@SessionAttributes(types = Admin.class, names = "adminSession")
public class ManagementPageController {
	
	@GetMapping("/management")
	public String Management(@ModelAttribute("adminSession") Admin admin, Model model) {
		System.out.println(admin);
		if (admin !=null) {
			model.addAttribute("productDetail", new ProductDetail());
			return "Management/Admin/detailProduct";
			
		}
		
		return "redirect:/login";
	}
	
	
	
	@ModelAttribute("adminSession")
	public Admin getAdmin() {
		return null;
	}
}
