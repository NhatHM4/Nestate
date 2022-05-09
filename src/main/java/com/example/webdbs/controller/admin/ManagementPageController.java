package com.example.webdbs.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.webdbs.entity.Admin;

@Controller
@SessionAttributes(types = Admin.class, names = "adminSession")
public class ManagementPageController {
	
	@GetMapping("/management")
	public String Management(@ModelAttribute("adminSession") Admin admin) {
		System.out.println(admin);
		if (admin !=null) {
			return "Management/index";
			
		}
		
		return "redirect:/login";
	}
	
	@ModelAttribute("adminSession")
	public Admin getAdmin() {
		return null;
	}
}
